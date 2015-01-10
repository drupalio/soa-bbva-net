package com.bbva.czic.loan.business;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.locks.Condition;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.staticmock.MockStaticEntityMethods;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.bbva.czic.dto.net.Balance;
import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.dto.net.ContactInfo;
import com.bbva.czic.dto.net.Email;
import com.bbva.czic.dto.net.EnumContactSourceType;
import com.bbva.czic.dto.net.EnumFinancialStatusType;
import com.bbva.czic.dto.net.EnumLoanStatus;
import com.bbva.czic.dto.net.EnumPhoneNumberType;
import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.czic.dto.net.Location;
import com.bbva.czic.dto.net.Office;
import com.bbva.czic.dto.net.Payment;
import com.bbva.czic.dto.net.PhoneNumber;
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.dao.LoanDAO;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = BusinessServiceTestContextLoader.class, locations = {
		"classpath*:/META-INF/spring/applicationContext-*.xml", "classpath:/META-INF/spring/business-service.xml",
		"classpath:/META-INF/spring/business-service-test.xml" })
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class })
public class SrvIntLoanTest {
	
	@Mock
	LoanDAO loanDao;
	
	@InjectMocks
	@Autowired
	ISrvIntLoan srv;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetRotaryQuota() {
		//setUp - data
		final DTOIntLoan loan = getLoanMock();
		
		//setUp - expectation
		when(loanDao.getRotaryQuota(anyString())).thenReturn(loan);
		
		//SUT's excecution
		final  DTOIntLoan loanResult = srv.getRotaryQuota("123");
		
		//validation
		assertNotNull(loanResult);
	}
	
	@Test(expected = BusinessServiceException.class)
	public void testGetRotaryQuotaWhenIdNull() {
		final  DTOIntLoan loanResult = srv.getRotaryQuota(null);
	}

	/**
	 * Metodo que crea un DTOIntLoan dummy para los test
	 * @author Sebastian Gamba - Entelgy Col.
	 * @since 8/01/2015
	 * @return
	 */
	private DTOIntLoan getLoanMock(){
		DTOIntLoan mock = new DTOIntLoan();
		Money money = new Money();
		money.setAmount(new BigDecimal(0));
		
		Balance balance = new Balance();
		balance.setAvailableBalance(money);
		balance.setTotal(money);
		
		Office office = new Office();
		office.setCode("officeCode");
		office.setLocation(new Location());
		office.setName("officeName");
		office.setPostalAddress("loanPostalAddress");
		
		Conditions conditions = new Conditions();
		conditions.setCategory("loanCategory");
		conditions.setCommission("loanCommission");
		conditions.setDescription("loanDescription");
		conditions.setMobilizationConditions("loanMobilizationConditions");
		conditions.setOffice(office);
		conditions.setOpeningDate(Calendar.getInstance());
		
		Email email = new Email();
		email.setActive(true);
		email.setAddres("mock@test.com");
		email.setPrimary(true);
		email.setSource(EnumContactSourceType.WEB);
		
		List<Email> emails = new ArrayList<Email>();
		emails.add(email);
		
		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setActive(true);
		phoneNumber.setContactSource(EnumContactSourceType.MOBILE);
		phoneNumber.setCountryCode("57");
		phoneNumber.setNumber("3111111");
		phoneNumber.setPrimary(true);
		phoneNumber.setRegionalCode("1");
		phoneNumber.setType(EnumPhoneNumberType.MOBILE);
		
		List<PhoneNumber> numbers = new ArrayList<PhoneNumber>();
		numbers.add(phoneNumber);
		
		ContactInfo contactInfo = new ContactInfo();
		contactInfo.setEmails(emails);
		contactInfo.setPhoneNumbers(numbers);
		
		mock.setAlias("loanAlias");
		mock.setBalance(balance);
		mock.setConditions(conditions);
		mock.setContactInfo(contactInfo);
//		mock.setContract(null);
		mock.setFinancialState(EnumFinancialStatusType.A);
		mock.setId("0010");
		mock.setMovement(null);
		mock.setName("loanName");
		mock.setOperable(true);
		mock.setPayment(new Payment());
		mock.setStatus(EnumLoanStatus.NORMAL);
		mock.setType(EnumProductType.RQ);
		mock.setVisible(true);
		
		return mock;
	}
}

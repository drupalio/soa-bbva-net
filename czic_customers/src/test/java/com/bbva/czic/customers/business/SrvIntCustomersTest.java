package com.bbva.czic.customers.business;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.czic.customers.business.dto.DTOIntCustomer;
import com.bbva.czic.customers.business.dto.DTOIntEnumMonth;
import com.bbva.czic.customers.business.dto.DTOIntFilterCustomerResumes;
import com.bbva.czic.customers.business.impl.SrvIntCustomers;
import com.bbva.czic.customers.dao.CustomersDAO;
import com.bbva.czic.customers.dao.mapper.ICustomerMapper;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.City;
import com.bbva.czic.dto.net.ContactInfo;
import com.bbva.czic.dto.net.Country;
import com.bbva.czic.dto.net.Customer;
import com.bbva.czic.dto.net.Document;
import com.bbva.czic.dto.net.Email;
import com.bbva.czic.dto.net.EnumContactSourceType;
import com.bbva.czic.dto.net.EnumDocumentType;
import com.bbva.czic.dto.net.EnumDwelingType;
import com.bbva.czic.dto.net.EnumSegmentType;
import com.bbva.czic.dto.net.PhoneNumber;
import com.bbva.czic.dto.net.Place;
import com.bbva.czic.dto.net.State;
import com.bbva.czic.routine.commons.rm.utils.converter.UtilsConverter;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = BusinessServiceTestContextLoader.class, 
locations = {
	"classpath*:/META-INF/spring/applicationContext-*.xml",
	"classpath:/META-INF/spring/business-service.xml",
	"classpath:/META-INF/spring/business-service-test.xml"
	})

@TestExecutionListeners(listeners = {
//		MockInvocationContextTestExecutionListener.class, 
		DependencyInjectionTestExecutionListener.class
		})
public class SrvIntCustomersTest {
	
	
	@Mock
	CustomersDAO customersDao;

	@Mock
	ICustomerMapper customerMapper;

	@Autowired
	@InjectMocks
	SrvIntCustomers srv;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected = BusinessServiceException.class)
	public void testGetlistAccountsMovementsResumeNoFilter() {
		//Setup

		//Setup expectation

		//SUT execution
		final List<AccMovementsResume> answer = srv.getlistAccountsMovementsResume("123",null);
		//validation
	}

	@Test
	public void testGetlistAccountsMovementsResume() {
		//Setup
		final DTOIntFilterCustomerResumes filter = mockResumesFilter();
		final List<DTOIntAccMovementsResume> resumes = mockListAccMovementsResume();
		//Setup expectation
		when(customersDao.getlistAccountsMovementsResume(filter)).thenReturn(resumes);
		//SUT execution
		final List<AccMovementsResume> answer = srv.getlistAccountsMovementsResume("123",filter);
		//validation
		assertNotNull(answer);
		assertTrue(answer.size() > 0);
	}

	@Test(expected = Exception.class)
	public void testGetlistAccountsMovementsResumeResultNull() {
		//Setup
		final DTOIntFilterCustomerResumes filter = mockResumesFilter();
		//Setup expectation
		when(customersDao.getlistAccountsMovementsResume(filter)).thenReturn(null);
		//SUT execution
		final List<AccMovementsResume> answer = srv.getlistAccountsMovementsResume("123",filter);
	}

	//GetlistCreditCharges

	@Test(expected = BusinessServiceException.class)
	public void testGetlistCreditChargesNoFilter() {
		//Setup

		//Setup expectation

		//SUT execution
		final List<CardCharge> answer = srv.getlistCreditCharges("123",null);
		//validation
	}

	@Test
	public void testGetlistCreditCharges() {
		//Setup
		final DTOIntFilterCustomerResumes filter = mockResumesFilter();
		final List<DTOIntCardCharge> charges = mockListCardCharge();
		//Setup expectation
		when(customersDao.getlistCreCardCharges(filter)).thenReturn(charges);
		//SUT execution
		final List<CardCharge> answer = srv.getlistCreditCharges("123", filter);
		//validation
		assertNotNull(answer);
		assertTrue(answer.size() > 0);
	}

	@Test(expected = Exception.class)
	public void testGetlistCreditChargesResultNull() {
		//Setup
		final DTOIntFilterCustomerResumes filter = mockResumesFilter();
		//Setup expectation
		when(customersDao.getlistCreCardCharges(filter)).thenReturn(null);
		//SUT execution
		final List<CardCharge> answer = srv.getlistCreditCharges("123", filter);
	}

	private DTOIntFilterCustomerResumes mockResumesFilter(){
		DTOIntFilterCustomerResumes filter = new DTOIntFilterCustomerResumes();

		filter.setEndDate(new Date());
		Calendar cal = Calendar.getInstance();
		cal.set(2015,01,01);
		filter.setStartDate(cal.getTime());

		return  filter;
	}

	private List<DTOIntAccMovementsResume> mockListAccMovementsResume(){
		List<DTOIntAccMovementsResume> list = new ArrayList<DTOIntAccMovementsResume>();

		for(DTOIntEnumMonth month : DTOIntEnumMonth.values()){
			DTOIntAccMovementsResume mr1 = new DTOIntAccMovementsResume();
			mr1.setIncome(UtilsConverter.getMoneyDTO(new BigDecimal(100)));
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.MONTH, Integer.valueOf(month.getCode()));
			mr1.setMonth(cal.getTime());
			mr1.setBalance(UtilsConverter.getMoneyDTO(new BigDecimal(100)));
			mr1.setOutcome(UtilsConverter.getMoneyDTO(new BigDecimal(0)));

			list.add(mr1);
		}

		return list;
	}

	private List<DTOIntCardCharge> mockListCardCharge(){
		List<DTOIntCardCharge> list = new ArrayList<DTOIntCardCharge>();

			DTOIntCardCharge cc = new DTOIntCardCharge();
			cc.setCategory("category");
			cc.setAmount(UtilsConverter.getMoneyDTO(new BigDecimal(100)));
			cc.setChargeDate(new Date());

			list.add(cc);

		return list;
	}
	
//	GetCustomer
	
	@Test
	public void testGetCustomerNoId() {
		//Setup

		//Setup expectation

		//SUT execution
		Customer answer = srv.getCustomer(null);
		//validation
		assertNull(answer);
	}
	
	@Test
	public void testGetCustomer() {
		//Setup
		DTOIntFilterCustomerResumes customer = new DTOIntFilterCustomerResumes();
		customer.setCustomerId("1234567890");
		DTOIntCustomer dtoIntCustomer = mockDTOCustomer();
		Customer mapCustomer = new Customer();
		//Setup expectation
		when(customersDao.getCustomer((DTOIntFilterCustomerResumes) anyObject())).thenReturn(dtoIntCustomer);
		when(customerMapper.map((DTOIntCustomer)anyObject())).thenReturn(mapCustomer);
		//SUT execution
		final Customer answer = srv.getCustomer("1234567890");
		//validation
		assertNotNull(answer);
	}

	public static DTOIntCustomer mockDTOCustomer() {
		DTOIntCustomer customer = new DTOIntCustomer();
		
//		Document documento = new Document();
//		documento.setNumber("1234567890");
//		documento.setType(EnumDocumentType.CEDULACIUDADANIA);
		
		ContactInfo contacto = new ContactInfo();
		List<Email> emails = new ArrayList<Email>();
		Email email = new Email();
		email.setActive(true);
		email.setAddress("prueba@bbva.com");
		email.setPrimary(true);
		email.setSource(EnumContactSourceType.WEB);
		emails.add(email);
		contacto.setEmails(emails);
		contacto.setPhoneNumbers(new ArrayList<PhoneNumber>());
		
		Place homeLocation= new Place();
		homeLocation.setCityName("city");
		homeLocation.setCountryName("Country");
		homeLocation.setStateName("State");
		homeLocation.setPostalAddress("BBVA");
		
		customer.setId("1");
//		customer.setDocument(documento);
		customer.setSegment(EnumSegmentType.PERSONA);
		customer.setName("Cliente de prueba");
		customer.setEmails(contacto);
		customer.setHomeLocation(homeLocation);
		customer.setOfficeLocation(homeLocation);
		customer.setStratum(4);
		customer.setResidenceYears(1);
		customer.setHomeMembers(1);
		customer.setDwelingType(EnumDwelingType.VALIDAR);
		return customer;
	}
}





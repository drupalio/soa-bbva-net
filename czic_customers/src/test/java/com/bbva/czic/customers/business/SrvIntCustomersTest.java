package com.bbva.czic.customers.business;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.ejb.criteria.expression.function.CurrentTimestampFunction;
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
import com.bbva.czic.customers.business.dto.DTOIntEnumCardChargeCategory;
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
import com.bbva.czic.dto.net.EnumDocumentType;
import com.bbva.czic.dto.net.EnumDwelingType;
import com.bbva.czic.dto.net.Location;
import com.bbva.czic.dto.net.PhoneNumber;
import com.bbva.czic.dto.net.State;
import com.bbva.czic.routine.commons.rm.utils.converter.UtilsConverter;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;



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
		//Setup expectation
		when(customersDao.getlistAccountsMovementsResume(filter)).thenReturn(mockListAccMovementsResume());
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
		//Setup expectation
		when(customersDao.getlistCreCardCharges(filter)).thenReturn(mockListCardCharge());
		//SUT execution
		final List<AccMovementsResume> answer = srv.getlistAccountsMovementsResume("123",filter);
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

		for(DTOIntEnumCardChargeCategory category : DTOIntEnumCardChargeCategory.values()){
			DTOIntCardCharge cc = new DTOIntCardCharge();
			cc.setCategory(category);
			cc.setAmount(new Money());
			cc.setChargeDate(new Date());

			list.add(cc);
		}

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
		DTOIntFilterCustomerResumes filter = new DTOIntFilterCustomerResumes();
		filter.setCustomerId("1234567890");
		//Setup expectation
		when(customersDao.getCustomer(filter)).thenReturn(mockCustomer());
		//SUT execution
		final Customer answer = srv.getCustomer("1234567890");
		//validation
		assertNotNull(answer);
	}

	private DTOIntCustomer mockCustomer() {
		DTOIntCustomer customer = new DTOIntCustomer();
		Document documento = new Document();
		documento.setNumber("1234567890");
		documento.setType(EnumDocumentType.CEDULACIUDADANIA);
		ContactInfo contacto = new ContactInfo();
		contacto.setEmails(new ArrayList<Email>());
		contacto.setPhoneNumbers(new ArrayList<PhoneNumber>());
		Location homeLocation= new Location();
		City city = new City();
		city.setId("1");
		city.setName("Bogota");
		State state = new State();
		state.setId("1");
		state.setName("Distrito Capital");
		state.setCities(new ArrayList<City>());
		Country country = new Country();
		country.setId("1");
		country.setName("Colombia");
		country.setStates(new ArrayList<State>());
		homeLocation.setCity(city);
		homeLocation.setCountry(country);
		homeLocation.setState(state);
		homeLocation.setPostalAddress("BBVA");
		
		customer.setDocument(documento);
		customer.setName("Cliente de prueba");
		customer.setContactInfo(contacto);
		customer.setHomeLocation(homeLocation);
		customer.setOfficeLocation(homeLocation);
		customer.setStratum(4);
		customer.setResidenceYears(1);
		customer.setHomeMembers(1);
		customer.setDwelingType(EnumDwelingType.VALIDAR);
		customer.setLastConnectionTime(new GregorianCalendar(2014,1,28,13,24,56));
		return customer;
	}
}





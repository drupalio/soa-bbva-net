package com.bbva.czic.currency.business;

import com.bbva.czic.currency.business.dto.DTOIntCurrency;
import com.bbva.czic.currency.business.impl.SrvIntCurrency;
import com.bbva.czic.currency.dao.CurrencyDAO;
import com.bbva.czic.currency.dao.impl.CurrencyDAOImpl;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = BusinessServiceTestContextLoader.class, locations = {"classpath*:/META-INF/spring/applicationContext-*.xml", "classpath:/META-INF/spring/business-service.xml", "classpath:/META-INF/spring/business-service-test.xml"})
@TestExecutionListeners(listeners = {MockInvocationContextTestExecutionListener.class, DependencyInjectionTestExecutionListener.class})
@ActiveProfiles("dev")
public class SrvIntCurrencyTest {

	@Autowired
	ISrvIntCurrency srv;

	@Mock
	CurrencyDAO currencyDAO;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected=BusinessServiceException.class)
	public void testGetCurrencysWithoutID() {
		// Setup data
		final List<DTOIntCurrency> dtoIntCurrencyList = new ArrayList<DTOIntCurrency>();
		DTOIntCurrency dtoIntCurrency=new DTOIntCurrency();
		dtoIntCurrency.setName("COP");
		dtoIntCurrencyList.add(dtoIntCurrency);

		// Setup expectation
		when(currencyDAO.listCurrencies()).thenReturn(dtoIntCurrencyList);

		// SUT execution
		srv.listCurrencies();

	}

	@Test(expected=BusinessServiceException.class)
	public void testGetCurrencysWithoutName() {
		// Setup data
		final List<DTOIntCurrency> dtoIntCurrencyList = new ArrayList<DTOIntCurrency>();
		DTOIntCurrency dtoIntCurrency=new DTOIntCurrency();
		dtoIntCurrency.setId("ID");
		dtoIntCurrencyList.add(dtoIntCurrency);

		// Setup expectation
		when(currencyDAO.listCurrencies()).thenReturn(dtoIntCurrencyList);

		// SUT execution
		srv.listCurrencies();

	}

	@Test
	public void testGetCurrencysOK() {
		// Setup data
		final List<DTOIntCurrency> dtoIntCurrencyList = new ArrayList<DTOIntCurrency>();
		DTOIntCurrency dtoIntCurrency=new DTOIntCurrency();
		dtoIntCurrency.setId("id");
		dtoIntCurrency.setName("name");
		dtoIntCurrencyList.add(dtoIntCurrency);

		// Setup expectation
		when(currencyDAO.listCurrencies()).thenReturn(dtoIntCurrencyList);

		// SUT execution
		List<DTOIntCurrency> dtoIntCurrencyListResult=srv.listCurrencies();

		Assert.assertNotNull(dtoIntCurrencyListResult);

	}

	private BusinessServiceException getBsnExeptionByAlias(String alias){
		return new BusinessServiceException(alias);
	}

	
	
}


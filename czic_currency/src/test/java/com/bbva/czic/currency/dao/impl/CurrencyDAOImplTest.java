package com.bbva.czic.currency.dao.impl;

import com.bbva.czic.currency.business.ISrvIntCurrency;
import com.bbva.czic.currency.business.dto.DTOIntCurrency;
import com.bbva.czic.currency.dao.CurrencyDAO;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = BusinessServiceTestContextLoader.class, locations = {"classpath*:/META-INF/spring/applicationContext-*.xml", "classpath:/META-INF/spring/business-service.xml", "classpath:/META-INF/spring/business-service-test.xml"})
@TestExecutionListeners(listeners = {MockInvocationContextTestExecutionListener.class, DependencyInjectionTestExecutionListener.class})
@ActiveProfiles("dev")
public class CurrencyDAOImplTest {

	@Autowired
	CurrencyDAO currencyDAO;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
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
		//when(currencyDAO.listCurrencies()).thenReturn(dtoIntCurrencyList);

		// SUT execution
		List<DTOIntCurrency> dtoIntCurrencyListResult=currencyDAO.listCurrencies();

		Assert.assertNotNull(dtoIntCurrencyListResult);

	}

	
}


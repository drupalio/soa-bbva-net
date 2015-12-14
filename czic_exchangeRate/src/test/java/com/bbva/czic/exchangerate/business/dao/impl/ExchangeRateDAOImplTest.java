package com.bbva.czic.exchangerate.business.dao.impl;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRate;
import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRateFilter;
import com.bbva.czic.exchangerate.dao.ExchangeRateDAO;
import com.bbva.czic.exchangerate.dao.impl.ExchangeRateDAOImpl;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;

@ActiveProfiles("dev")
public class ExchangeRateDAOImplTest extends SpringContextBbvaTest {

	@InjectMocks
	ExchangeRateDAO exchangeRateDAO;

	@Before
	public void init() {
		exchangeRateDAO = new ExchangeRateDAOImpl();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetExchangeRatePurchaseOK() {
		DTOIntExchangeRateFilter dtoExchangeRateFilter = new DTOIntExchangeRateFilter();
		dtoExchangeRateFilter.setCurrencyId("USD");
		dtoExchangeRateFilter.setCustomerId("1026049283");
		dtoExchangeRateFilter.setPurchaseAmount(new BigDecimal(100000));

		DTOIntExchangeRate dtoExchangeRate = exchangeRateDAO.getExchangeRate(dtoExchangeRateFilter);

		Assert.assertNotNull(dtoExchangeRate);

	}

	@Test
	public void testGetExchangeRateSaleOK() {
		DTOIntExchangeRateFilter dtoExchangeRateFilter = new DTOIntExchangeRateFilter();
		dtoExchangeRateFilter.setCurrencyId("USD");
		dtoExchangeRateFilter.setCustomerId("1026049283");
		dtoExchangeRateFilter.setSaleAmount(new BigDecimal(100000));

		DTOIntExchangeRate dtoExchangeRate = exchangeRateDAO.getExchangeRate(dtoExchangeRateFilter);

		Assert.assertNotNull(dtoExchangeRate);

	}
}

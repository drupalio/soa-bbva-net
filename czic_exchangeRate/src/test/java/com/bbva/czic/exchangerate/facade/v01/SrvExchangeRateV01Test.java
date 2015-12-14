package com.bbva.czic.exchangerate.facade.v01;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

import com.bbva.czic.dto.net.ExchangeRate;
import com.bbva.czic.exchangerate.business.ISrvIntExchangeRate;
import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRate;
import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRateFilter;
import com.bbva.czic.exchangerate.facade.v01.impl.SrvExchangeRateV01;
import com.bbva.czic.exchangerate.facade.v01.mapper.IExchangeRateMapper;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;

/**
 * Created by Entelgy on 05/02/2015.
 */
@ActiveProfiles("dev")
public class SrvExchangeRateV01Test extends SpringContextBbvaTest {

	@Mock
	private ISrvIntExchangeRate srvIntExchangeRate;

	@Mock
	private IExchangeRateMapper iExchangeRateMapper;

	@InjectMocks
	SrvExchangeRateV01 srv;

	@Before
	public void init() {
		srv = new SrvExchangeRateV01();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetExchangePurchaseRates() {
		final DTOIntExchangeRate exchange = new DTOIntExchangeRate();
		final ExchangeRate exchangeRate = new ExchangeRate();
		Mockito.when(srvIntExchangeRate.getExchangeRate(Mockito.any(DTOIntExchangeRateFilter.class))).thenReturn(
				exchange);
		Mockito.when(iExchangeRateMapper.map(exchange)).thenReturn(exchangeRate);
		final ExchangeRate prueba = srv.getExchangeRate("USD", "1026283049", new BigDecimal(100000), null);
		Assert.assertNotNull(prueba);
	}

	@Test
	public void testGetExchangeSaleRates() {
		final DTOIntExchangeRate exchange = new DTOIntExchangeRate();
		final ExchangeRate exchangeRate = new ExchangeRate();
		Mockito.when(srvIntExchangeRate.getExchangeRate(Mockito.any(DTOIntExchangeRateFilter.class))).thenReturn(
				exchange);
		Mockito.when(iExchangeRateMapper.map(exchange)).thenReturn(exchangeRate);
		final ExchangeRate prueba = srv.getExchangeRate("USD", "1026283049", null, new BigDecimal(100000));
		Assert.assertNotNull(prueba);
	}
}

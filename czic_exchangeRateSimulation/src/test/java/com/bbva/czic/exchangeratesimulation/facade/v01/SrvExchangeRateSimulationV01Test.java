package com.bbva.czic.exchangeratesimulation.facade.v01;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

import com.bbva.czic.dto.net.ExchangeRateSimulation;
import com.bbva.czic.exchangeratesimulation.business.ISrvIntExchangeRateSimulation;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntExchangeRate;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntExchangeRateSimulation;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntExchangeRateValues;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntMoney;
import com.bbva.czic.exchangeratesimulation.facade.v01.impl.SrvExchangeRateSimulationV01;
import com.bbva.czic.exchangeratesimulation.facade.v01.mapper.IExchangeRateSimulationMapper;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;

/**
 * Created by Entelgy on 05/02/2015.
 */
@ActiveProfiles("dev")
public class SrvExchangeRateSimulationV01Test extends SpringContextBbvaTest {

	@Mock
	private ISrvIntExchangeRateSimulation srvIntExchangeRate;

	@Mock
	private IExchangeRateSimulationMapper exchangeRateMapper;

	@InjectMocks
	SrvExchangeRateSimulationV01 srv;

	@Before
	public void init() {
		srv = new SrvExchangeRateSimulationV01();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetExchangePurchaseRates() {
		final DTOIntExchangeRateSimulation dtoExchangeRateSimulation = new DTOIntExchangeRateSimulation();
		List<DTOIntExchangeRate> exchangeRates = new ArrayList<DTOIntExchangeRate>();
		DTOIntExchangeRate dtoExchangeRate = new DTOIntExchangeRate();
		DTOIntExchangeRateValues exchangeRateValues = new DTOIntExchangeRateValues();
		DTOIntMoney dtoIntMoney = new DTOIntMoney();
		dtoIntMoney.setCurrency("USD");
		dtoIntMoney.setAmount(new BigDecimal(10000));
		exchangeRateValues.setPurchaseValue(dtoIntMoney);
		dtoExchangeRate.setExchangeRateValues(exchangeRateValues);
		exchangeRates.add(dtoExchangeRate);
		dtoExchangeRateSimulation.setExchangeRates(exchangeRates);
		final ExchangeRateSimulation exchangeRateSimulation = new ExchangeRateSimulation();

		Mockito.when(exchangeRateMapper.map(exchangeRateSimulation)).thenReturn(dtoExchangeRateSimulation);

		Mockito.when(srvIntExchangeRate.getExchangeRateSimulation(Mockito.any(DTOIntExchangeRateSimulation.class)))
				.thenReturn(dtoExchangeRateSimulation);
		Mockito.when(exchangeRateMapper.map(Mockito.any(DTOIntExchangeRateSimulation.class))).thenReturn(
				exchangeRateSimulation);
		final ExchangeRateSimulation prueba = srv.getExchangeRateSimulation("1234", exchangeRateSimulation);
		Assert.assertNotNull(prueba);
	}

	@Test
	public void testGetExchangeSaleRates() {
		final DTOIntExchangeRateSimulation dtoExchangeRateSimulation = new DTOIntExchangeRateSimulation();
		List<DTOIntExchangeRate> exchangeRates = new ArrayList<DTOIntExchangeRate>();
		DTOIntExchangeRate dtoExchangeRate = new DTOIntExchangeRate();
		DTOIntExchangeRateValues exchangeRateValues = new DTOIntExchangeRateValues();
		DTOIntMoney dtoIntMoney = new DTOIntMoney();
		dtoIntMoney.setCurrency("USD");
		dtoIntMoney.setAmount(new BigDecimal(10000));
		exchangeRateValues.setSaleValue(dtoIntMoney);
		dtoExchangeRate.setExchangeRateValues(exchangeRateValues);
		exchangeRates.add(dtoExchangeRate);
		dtoExchangeRateSimulation.setExchangeRates(exchangeRates);
		final ExchangeRateSimulation exchangeRateSimulation = new ExchangeRateSimulation();

		Mockito.when(exchangeRateMapper.map(exchangeRateSimulation)).thenReturn(dtoExchangeRateSimulation);

		Mockito.when(srvIntExchangeRate.getExchangeRateSimulation(Mockito.any(DTOIntExchangeRateSimulation.class)))
				.thenReturn(dtoExchangeRateSimulation);
		Mockito.when(exchangeRateMapper.map(Mockito.any(DTOIntExchangeRateSimulation.class))).thenReturn(
				exchangeRateSimulation);
		final ExchangeRateSimulation prueba = srv.getExchangeRateSimulation("1234", exchangeRateSimulation);
		Assert.assertNotNull(prueba);
	}
}

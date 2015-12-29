package com.bbva.czic.exchangeratesimulation.business.impl;

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

import com.bbva.czic.exchangeratesimulation.business.ISrvIntExchangeRateSimulation;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntExchangeRate;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntExchangeRateAssessments;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntExchangeRateSimulation;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntExchangeRateValues;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntMoney;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntOptionsList;
import com.bbva.czic.exchangeratesimulation.dao.ExchangeRateSimulationDAO;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;

@ActiveProfiles("dev")
public class SrvIntExchangeRateSimulationTest extends SpringContextBbvaTest {

	@InjectMocks
	private ISrvIntExchangeRateSimulation srv;

	@Mock
	ExchangeRateSimulationDAO exchangeRateSimulationDAO;

	@Before
	public void init() {
		srv = new SrvIntExchangeRateSimulation();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetExchangeRateSimulationPurchase() {
		DTOIntExchangeRateSimulation dtoIntExchangeRateSimulation = new DTOIntExchangeRateSimulation();
		DTOIntOptionsList optionType = new DTOIntOptionsList();
		optionType.setId("123");
		dtoIntExchangeRateSimulation.setType(optionType);
		List<DTOIntExchangeRate> exchangeRates = new ArrayList<DTOIntExchangeRate>();
		DTOIntExchangeRate dtoExchangeRate = new DTOIntExchangeRate();
		DTOIntExchangeRateValues exchangeRateValues = new DTOIntExchangeRateValues();
		DTOIntMoney dtoIntMoney = new DTOIntMoney();
		dtoIntMoney.setCurrency("USD");
		dtoIntMoney.setAmount(new BigDecimal(10000));
		exchangeRateValues.setPurchaseValue(dtoIntMoney);
		dtoExchangeRate.setExchangeRateValues(exchangeRateValues);
		exchangeRates.add(dtoExchangeRate);
		dtoIntExchangeRateSimulation.setExchangeRates(exchangeRates);

		DTOIntExchangeRateSimulation dtoExchangeRateSimulation = new DTOIntExchangeRateSimulation();
		exchangeRates = new ArrayList<DTOIntExchangeRate>();
		dtoExchangeRate = new DTOIntExchangeRate();
		DTOIntExchangeRateAssessments exchangeRateAssessments = new DTOIntExchangeRateAssessments();
		exchangeRateAssessments.setType("TasaDivisaUSD");
		exchangeRateAssessments.setValue(new BigDecimal(1234));
		dtoExchangeRate.setExchangeRateAssessments(exchangeRateAssessments);
		exchangeRates.add(dtoExchangeRate);

		dtoExchangeRateSimulation.setExchangeRates(exchangeRates);
		Mockito.when(
				exchangeRateSimulationDAO.getExchangeRateSimulation(Mockito.any(DTOIntExchangeRateSimulation.class)))
				.thenReturn(dtoExchangeRateSimulation);

		DTOIntExchangeRateSimulation resultado = srv.getExchangeRateSimulation(dtoIntExchangeRateSimulation);
		Assert.assertNotNull(resultado);

	}

	@Test
	public void testGetExchangeRateSimulationSAle() {
		DTOIntExchangeRateSimulation dtoIntExchangeRateSimulation = new DTOIntExchangeRateSimulation();
		DTOIntOptionsList optionType = new DTOIntOptionsList();
		optionType.setId("123");
		dtoIntExchangeRateSimulation.setType(optionType);
		List<DTOIntExchangeRate> exchangeRates = new ArrayList<DTOIntExchangeRate>();
		DTOIntExchangeRate dtoExchangeRate = new DTOIntExchangeRate();
		DTOIntExchangeRateValues exchangeRateValues = new DTOIntExchangeRateValues();
		DTOIntMoney dtoIntMoney = new DTOIntMoney();
		dtoIntMoney.setCurrency("USD");
		dtoIntMoney.setAmount(new BigDecimal(10000));
		exchangeRateValues.setSaleValue(dtoIntMoney);
		dtoExchangeRate.setExchangeRateValues(exchangeRateValues);
		exchangeRates.add(dtoExchangeRate);
		dtoIntExchangeRateSimulation.setExchangeRates(exchangeRates);

		DTOIntExchangeRateSimulation dtoExchangeRateSimulation = new DTOIntExchangeRateSimulation();
		exchangeRates = new ArrayList<DTOIntExchangeRate>();
		dtoExchangeRate = new DTOIntExchangeRate();
		DTOIntExchangeRateAssessments exchangeRateAssessments = new DTOIntExchangeRateAssessments();
		exchangeRateAssessments.setType("TasaDivisaUSD");
		exchangeRateAssessments.setValue(new BigDecimal(1234));
		dtoExchangeRate.setExchangeRateAssessments(exchangeRateAssessments);
		exchangeRates.add(dtoExchangeRate);

		dtoExchangeRateSimulation.setExchangeRates(exchangeRates);
		Mockito.when(
				exchangeRateSimulationDAO.getExchangeRateSimulation(Mockito.any(DTOIntExchangeRateSimulation.class)))
				.thenReturn(dtoExchangeRateSimulation);

		DTOIntExchangeRateSimulation resultado = srv.getExchangeRateSimulation(dtoIntExchangeRateSimulation);
		Assert.assertNotNull(resultado);

	}
}

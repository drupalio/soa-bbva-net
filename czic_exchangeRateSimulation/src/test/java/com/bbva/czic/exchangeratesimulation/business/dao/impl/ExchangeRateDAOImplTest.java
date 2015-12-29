package com.bbva.czic.exchangeratesimulation.business.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntExchangeRate;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntExchangeRateSimulation;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntExchangeRateValues;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntMoney;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntOptionsList;
import com.bbva.czic.exchangeratesimulation.dao.ExchangeRateSimulationDAO;
import com.bbva.czic.exchangeratesimulation.dao.impl.ExchangeRateSimulationDAOImpl;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;

@ActiveProfiles("dev")
public class ExchangeRateDAOImplTest extends SpringContextBbvaTest {

	@InjectMocks
	ExchangeRateSimulationDAO exchangeRateDAO;

	@Before
	public void init() {
		exchangeRateDAO = new ExchangeRateSimulationDAOImpl();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetExchangeRatePurchaseOK() {

		DTOIntExchangeRateSimulation dtoIntExchangeRateSimulation = new DTOIntExchangeRateSimulation();
		DTOIntOptionsList optionType = new DTOIntOptionsList();
		optionType.setId("102627384");
		dtoIntExchangeRateSimulation.setType(optionType);

		List<DTOIntExchangeRate> listdtoExchangeRate = new ArrayList<DTOIntExchangeRate>();
		DTOIntExchangeRate dtoExchangeRate = new DTOIntExchangeRate();
		DTOIntExchangeRateValues dtoExchangeRateValues = new DTOIntExchangeRateValues();
		DTOIntMoney dtoMoney = new DTOIntMoney();
		dtoMoney.setCurrency("USD");
		dtoMoney.setAmount(new BigDecimal(10000));
		dtoExchangeRateValues.setPurchaseValue(dtoMoney);
		dtoExchangeRate.setExchangeRateValues(dtoExchangeRateValues);
		listdtoExchangeRate.add(dtoExchangeRate);

		DTOIntExchangeRateSimulation dtoExchangeRateOut = exchangeRateDAO
				.getExchangeRateSimulation(dtoIntExchangeRateSimulation);

		Assert.assertNotNull(dtoExchangeRateOut);

	}

	@Test
	public void testGetExchangeRateSaleOK() {

		DTOIntExchangeRateSimulation dtoIntExchangeRateSimulation = new DTOIntExchangeRateSimulation();
		DTOIntOptionsList optionType = new DTOIntOptionsList();
		optionType.setId("102627384");
		dtoIntExchangeRateSimulation.setType(optionType);

		List<DTOIntExchangeRate> listdtoExchangeRate = new ArrayList<DTOIntExchangeRate>();
		DTOIntExchangeRate dtoExchangeRate = new DTOIntExchangeRate();
		DTOIntExchangeRateValues dtoExchangeRateValues = new DTOIntExchangeRateValues();
		DTOIntMoney dtoMoney = new DTOIntMoney();
		dtoMoney.setCurrency("USD");
		dtoMoney.setAmount(new BigDecimal(10000));
		dtoExchangeRateValues.setSaleValue(dtoMoney);
		dtoExchangeRate.setExchangeRateValues(dtoExchangeRateValues);
		listdtoExchangeRate.add(dtoExchangeRate);

		DTOIntExchangeRateSimulation dtoExchangeRateOut = exchangeRateDAO
				.getExchangeRateSimulation(dtoIntExchangeRateSimulation);

		Assert.assertNotNull(dtoExchangeRateOut);

	}
}

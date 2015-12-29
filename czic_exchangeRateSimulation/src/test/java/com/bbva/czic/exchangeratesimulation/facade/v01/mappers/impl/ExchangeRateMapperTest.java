package com.bbva.czic.exchangeratesimulation.facade.v01.mappers.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bbva.czic.dto.net.ExchangeRate;
import com.bbva.czic.dto.net.ExchangeRateSimulation;
import com.bbva.czic.dto.net.ExchangeRateValues;
import com.bbva.czic.dto.net.OptionsList;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntExchangeRate;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntExchangeRateAssessments;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntExchangeRateSimulation;
import com.bbva.czic.exchangeratesimulation.facade.v01.mapper.impl.ExchangeRateSimulationMapperImpl;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

/**
 * Created by Entelgy on 13/01/2015.
 */
public class ExchangeRateMapperTest extends SpringContextBbvaTest {

	ExchangeRateSimulationMapperImpl exchangeRateMapper;

	@Before
	public void init() {
		exchangeRateMapper = new ExchangeRateSimulationMapperImpl();
	}

	@Test
	public void testExchangeRateMapper() {
		final DTOIntExchangeRateSimulation dtoExchangeRateSimulation = new DTOIntExchangeRateSimulation();
		final List<DTOIntExchangeRate> listDtoExchangeRate = new ArrayList<DTOIntExchangeRate>();
		DTOIntExchangeRate dtoExchangeRate = new DTOIntExchangeRate();
		DTOIntExchangeRateAssessments dtoExchangeRateAssessments = new DTOIntExchangeRateAssessments();

		dtoExchangeRateAssessments.setType("TasaDivisaUSD");
		dtoExchangeRateAssessments.setValue(new BigDecimal(123));
		dtoExchangeRate.setExchangeRateAssessments(dtoExchangeRateAssessments);
		listDtoExchangeRate.add(dtoExchangeRate);

		dtoExchangeRate = new DTOIntExchangeRate();
		dtoExchangeRateAssessments = new DTOIntExchangeRateAssessments();
		dtoExchangeRateAssessments.setType("TasaUSDMoneda");
		dtoExchangeRateAssessments.setValue(new BigDecimal(1234));
		dtoExchangeRate.setExchangeRateAssessments(dtoExchangeRateAssessments);
		listDtoExchangeRate.add(dtoExchangeRate);

		dtoExchangeRate = new DTOIntExchangeRate();
		dtoExchangeRateAssessments = new DTOIntExchangeRateAssessments();
		dtoExchangeRateAssessments.setType("TasaDivisaMoneda");
		dtoExchangeRateAssessments.setValue(new BigDecimal(12345));
		dtoExchangeRate.setExchangeRateAssessments(dtoExchangeRateAssessments);
		listDtoExchangeRate.add(dtoExchangeRate);

		dtoExchangeRate = new DTOIntExchangeRate();
		dtoExchangeRateAssessments = new DTOIntExchangeRateAssessments();
		dtoExchangeRateAssessments.setType("TotalPesos");
		dtoExchangeRateAssessments.setValue(new BigDecimal(123456));
		dtoExchangeRate.setExchangeRateAssessments(dtoExchangeRateAssessments);
		listDtoExchangeRate.add(dtoExchangeRate);

		dtoExchangeRateSimulation.setExchangeRates(listDtoExchangeRate);

		ExchangeRateSimulation exchangeRateSimulation = exchangeRateMapper.map(dtoExchangeRateSimulation);
		Assert.assertNotNull(exchangeRateSimulation);

	}

	@Test
	public void testExchangeRateMapperInPurchase() {
		ExchangeRateSimulation exchangeRateSimulation = new ExchangeRateSimulation();
		OptionsList optionType = new OptionsList();
		optionType.setId("1028320496");
		exchangeRateSimulation.setType(optionType);

		final ExchangeRateValues exchangeRateValues = new ExchangeRateValues();
		final ExchangeRate exchangeRate = new ExchangeRate();
		final List<ExchangeRate> listExchangeRate = new ArrayList<ExchangeRate>();
		Money money = new Money();
		money.setCurrency("USD");
		money.setAmount(new BigDecimal(10000));
		exchangeRateValues.setPurchaseValue(money);
		exchangeRate.setExchangeRateValues(exchangeRateValues);
		listExchangeRate.add(exchangeRate);
		exchangeRateSimulation.setExchangeRates(listExchangeRate);
		DTOIntExchangeRateSimulation dtoIntExchangeRateSimulation = exchangeRateMapper.map(exchangeRateSimulation);
		Assert.assertNotNull(dtoIntExchangeRateSimulation);
	}

	@Test
	public void testExchangeRateMapperInSale() {
		ExchangeRateSimulation exchangeRateSimulation = new ExchangeRateSimulation();
		OptionsList optionType = new OptionsList();
		optionType.setId("1028320496");
		exchangeRateSimulation.setType(optionType);

		final ExchangeRateValues exchangeRateValues = new ExchangeRateValues();
		final ExchangeRate exchangeRate = new ExchangeRate();
		final List<ExchangeRate> listExchangeRate = new ArrayList<ExchangeRate>();
		Money money = new Money();
		money.setCurrency("USD");
		money.setAmount(new BigDecimal(10000));
		exchangeRateValues.setSaleValue(money);
		exchangeRate.setExchangeRateValues(exchangeRateValues);
		listExchangeRate.add(exchangeRate);
		exchangeRateSimulation.setExchangeRates(listExchangeRate);
		DTOIntExchangeRateSimulation dtoIntExchangeRateSimulation = exchangeRateMapper.map(exchangeRateSimulation);
		Assert.assertNotNull(dtoIntExchangeRateSimulation);
	}

	@Test
	public void testExchangeRateMapperOut() {
		final DTOIntExchangeRateSimulation dtoExchangeRateSimulation = new DTOIntExchangeRateSimulation();
		final List<DTOIntExchangeRate> listDtoExchangeRate = new ArrayList<DTOIntExchangeRate>();
		DTOIntExchangeRate dtoExchangeRate = new DTOIntExchangeRate();
		DTOIntExchangeRateAssessments dtoExchangeRateAssessments = new DTOIntExchangeRateAssessments();

		dtoExchangeRateAssessments.setType("TasaDivisaUSD");
		dtoExchangeRateAssessments.setValue(new BigDecimal(123));
		dtoExchangeRate.setExchangeRateAssessments(dtoExchangeRateAssessments);
		listDtoExchangeRate.add(dtoExchangeRate);

		dtoExchangeRate = new DTOIntExchangeRate();
		dtoExchangeRateAssessments = new DTOIntExchangeRateAssessments();
		dtoExchangeRateAssessments.setType("TasaUSDMoneda");
		dtoExchangeRateAssessments.setValue(new BigDecimal(1234));
		dtoExchangeRate.setExchangeRateAssessments(dtoExchangeRateAssessments);
		listDtoExchangeRate.add(dtoExchangeRate);

		dtoExchangeRate = new DTOIntExchangeRate();
		dtoExchangeRateAssessments = new DTOIntExchangeRateAssessments();
		dtoExchangeRateAssessments.setType("TasaDivisaMoneda");
		dtoExchangeRateAssessments.setValue(new BigDecimal(12345));
		dtoExchangeRate.setExchangeRateAssessments(dtoExchangeRateAssessments);
		listDtoExchangeRate.add(dtoExchangeRate);

		dtoExchangeRate = new DTOIntExchangeRate();
		dtoExchangeRateAssessments = new DTOIntExchangeRateAssessments();
		dtoExchangeRateAssessments.setType("TotalPesos");
		dtoExchangeRateAssessments.setValue(new BigDecimal(123456));
		dtoExchangeRate.setExchangeRateAssessments(dtoExchangeRateAssessments);
		listDtoExchangeRate.add(dtoExchangeRate);

		dtoExchangeRateSimulation.setExchangeRates(listDtoExchangeRate);

		ExchangeRateSimulation exchangeRateSimulation = exchangeRateMapper.map(dtoExchangeRateSimulation);
		Assert.assertNotNull(exchangeRateSimulation);

	}
}

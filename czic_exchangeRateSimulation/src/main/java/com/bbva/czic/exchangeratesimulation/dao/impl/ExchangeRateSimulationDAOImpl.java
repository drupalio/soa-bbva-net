package com.bbva.czic.exchangeratesimulation.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntExchangeRate;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntExchangeRateAssessments;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntExchangeRateSimulation;
import com.bbva.czic.exchangeratesimulation.dao.ExchangeRateSimulationDAO;

@Component(value = "exchangeRateSimulation-dao")
public class ExchangeRateSimulationDAOImpl implements ExchangeRateSimulationDAO {

	@Override
	public DTOIntExchangeRateSimulation getExchangeRateSimulation(DTOIntExchangeRateSimulation dtoExchangeRateSimulation) {
		DTOIntExchangeRateSimulation intExchangeRateSimulation = new DTOIntExchangeRateSimulation();

		DTOIntExchangeRate dtoIntExchangeRate = new DTOIntExchangeRate();
		List<DTOIntExchangeRate> listExchangeRates = new ArrayList<DTOIntExchangeRate>();

		DTOIntExchangeRateAssessments rates = new DTOIntExchangeRateAssessments();
		rates.setType("TasaDivisaUSD");
		rates.setValue(new BigDecimal(123));
		dtoIntExchangeRate.setExchangeRateAssessments(rates);
		listExchangeRates.add(dtoIntExchangeRate);

		rates = new DTOIntExchangeRateAssessments();
		rates.setType("TasaUSDMoneda");
		rates.setValue(new BigDecimal(1234));
		dtoIntExchangeRate = new DTOIntExchangeRate();
		dtoIntExchangeRate.setExchangeRateAssessments(rates);
		listExchangeRates.add(dtoIntExchangeRate);

		rates = new DTOIntExchangeRateAssessments();
		rates.setType("TasaDivisaMoneda");
		rates.setValue(new BigDecimal(12345));
		dtoIntExchangeRate = new DTOIntExchangeRate();
		dtoIntExchangeRate.setExchangeRateAssessments(rates);
		listExchangeRates.add(dtoIntExchangeRate);

		rates = new DTOIntExchangeRateAssessments();
		rates.setType("TotalPesos");
		rates.setValue(new BigDecimal(12345));
		dtoIntExchangeRate = new DTOIntExchangeRate();
		dtoIntExchangeRate.setExchangeRateAssessments(rates);
		listExchangeRates.add(dtoIntExchangeRate);

		intExchangeRateSimulation.setExchangeRates(listExchangeRates);
		return intExchangeRateSimulation;
	}
}

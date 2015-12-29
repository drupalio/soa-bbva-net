package com.bbva.czic.exchangeratesimulation.dao;

import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntExchangeRateSimulation;

public interface ExchangeRateSimulationDAO {

	public DTOIntExchangeRateSimulation getExchangeRateSimulation(DTOIntExchangeRateSimulation dtoExchangeRateSimulation);

}

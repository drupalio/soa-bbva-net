package com.bbva.czic.exchangeratesimulation.facade.v01;

import com.bbva.czic.dto.net.ExchangeRateSimulation;

public interface ISrvExchangeRateSimulationV01 {

	public ExchangeRateSimulation getExchangeRateSimulation(String simulateId,
			ExchangeRateSimulation exchangeRateSimulation);

}
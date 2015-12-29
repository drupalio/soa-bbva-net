package com.bbva.czic.exchangeratesimulation.business;

import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntExchangeRateSimulation;

public interface ISrvIntExchangeRateSimulation {

	public DTOIntExchangeRateSimulation getExchangeRateSimulation(
			DTOIntExchangeRateSimulation infoExchangeRateSimulation);

}
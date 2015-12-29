package com.bbva.czic.exchangeratesimulation.facade.v01.mapper;

import com.bbva.czic.dto.net.ExchangeRateSimulation;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntExchangeRateSimulation;

public interface IExchangeRateSimulationMapper {

	public DTOIntExchangeRateSimulation map(ExchangeRateSimulation exchangeRateSimulation);

	public ExchangeRateSimulation map(DTOIntExchangeRateSimulation dtoIntExchangeRateSimulation);

}

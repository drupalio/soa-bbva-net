package com.bbva.czic.exchangeratesimulation.business.dto;

import java.util.List;

public class DTOIntExchangeRateSimulation extends DTOIntSimulation {

	public final static long serialVersionUID = 1L;

	private DTOIntOptionsList type;

	private List<DTOIntExchangeRate> exchangeRates;

	public DTOIntExchangeRateSimulation() {
		// default constructor
	}

	public DTOIntOptionsList getType() {
		return type;
	}

	public void setType(DTOIntOptionsList type) {
		this.type = type;
	}

	public List<DTOIntExchangeRate> getExchangeRates() {
		return exchangeRates;
	}

	public void setExchangeRates(List<DTOIntExchangeRate> exchangeRates) {
		this.exchangeRates = exchangeRates;
	}

}

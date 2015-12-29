package com.bbva.czic.exchangeratesimulation.business.dto;


public class DTOIntExchangeRate {

	public final static long serialVersionUID = 1L;

	private DTOIntExchangeRateAssessments exchangeRateAssessments;

	private DTOIntExchangeRateValues exchangeRateValues;

	public DTOIntExchangeRate() {
		// default constructor
	}

	public DTOIntExchangeRateAssessments getExchangeRateAssessments() {
		return exchangeRateAssessments;
	}

	public void setExchangeRateAssessments(DTOIntExchangeRateAssessments exchangeRateAssessments) {
		this.exchangeRateAssessments = exchangeRateAssessments;
	}

	public DTOIntExchangeRateValues getExchangeRateValues() {
		return exchangeRateValues;
	}

	public void setExchangeRateValues(DTOIntExchangeRateValues exchangeRateValues) {
		this.exchangeRateValues = exchangeRateValues;
	}

}

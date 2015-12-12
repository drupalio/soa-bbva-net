package com.bbva.czic.exchangerate.business.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

public class DTOIntExchangeRate {

	public final static long serialVersionUID = 1L;

	private DTOIntCurrency exchangeRateCurrency;

	@NotNull
	private List<DTOIntExchangeRateAssessments> exchangeRateAssessments;

	private DTOIntExchangeRateValues exchangeRateValues;

	public DTOIntExchangeRate() {
		// default constructor
	}

	public DTOIntCurrency getExchangeRateCurrency() {
		return exchangeRateCurrency;
	}

	public void setExchangeRateCurrency(DTOIntCurrency exchangeRateCurrency) {
		this.exchangeRateCurrency = exchangeRateCurrency;
	}

	public List<DTOIntExchangeRateAssessments> getExchangeRateAssessments() {
		return exchangeRateAssessments;
	}

	public void setExchangeRateAssessments(List<DTOIntExchangeRateAssessments> exchangeRateAssessments) {
		this.exchangeRateAssessments = exchangeRateAssessments;
	}

	public DTOIntExchangeRateValues getExchangeRateValues() {
		return exchangeRateValues;
	}

	public void setExchangeRateValues(DTOIntExchangeRateValues exchangeRateValues) {
		this.exchangeRateValues = exchangeRateValues;
	}

}

package com.bbva.czic.internationalcontracttransfer.business.dto;

public class DTOIntExchangeRate {

	public final static long serialVersionUID = 1L;

	private DTOIntExchangeRateAssessments exchangeRateAssesments;

	public DTOIntExchangeRate() {

	}

	public DTOIntExchangeRateAssessments getExchangeRateAssesments() {
		return exchangeRateAssesments;
	}

	public void setExchangeRateAssesments(DTOIntExchangeRateAssessments exchangeRateAssesments) {
		this.exchangeRateAssesments = exchangeRateAssesments;
	}

}

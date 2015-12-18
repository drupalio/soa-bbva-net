package com.bbva.czic.internationalcontracttransfer.business.dto;

import java.util.List;

public class DTOIntExchangeRate {

	public final static long serialVersionUID = 1L;

	private List<DTOIntExchangeRateAssessments> exchangeRateAssesments;
	
	public DTOIntExchangeRate(){
		
	}

	public List<DTOIntExchangeRateAssessments> getExchangeRateAssesments() {
		return exchangeRateAssesments;
	}

	public void setExchangeRateAssesments(
			List<DTOIntExchangeRateAssessments> exchangeRateAssesments) {
		this.exchangeRateAssesments = exchangeRateAssesments;
	}


}

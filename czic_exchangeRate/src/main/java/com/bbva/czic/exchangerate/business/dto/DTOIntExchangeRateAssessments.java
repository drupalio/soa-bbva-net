package com.bbva.czic.exchangerate.business.dto;

import java.math.BigDecimal;

public class DTOIntExchangeRateAssessments {

	public final static long serialVersionUID = 1L;

	private String type;

	private BigDecimal value;

	public DTOIntExchangeRateAssessments() {
		// default constructor
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}

package com.bbva.czic.exchangeratesimulation.business.dto;

import java.math.BigDecimal;

public class DTOIntMoney {

	public final static long serialVersionUID = 1L;

	protected String currency;

	protected BigDecimal amount;

	public DTOIntMoney() {
		// default constructor
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}

package com.bbva.czic.internationalcontracttransfer.business.dto;

import java.math.BigDecimal;

public class DTOIntMoney {

	public final static long serialVersionUID = 1L;

	private BigDecimal amount;

	private String currency;

	public DTOIntMoney() {

	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}

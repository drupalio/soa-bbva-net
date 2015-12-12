package com.bbva.czic.exchangerate.business.dto;

import java.math.BigDecimal;

public class DTOIntMoney {

	public final static long serialVersionUID = 1L;

	private BigDecimal amount;

	public DTOIntMoney() {

	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}

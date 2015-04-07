package com.bbva.zic.accounts.business.dto;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;

import javax.validation.constraints.NotNull;


public class DTOIntMonthlyBalances {

	public final static long serialVersionUID = 1L;

	@NotNull
	private Money balance;

	@NotNull
	private String month;

	public DTOIntMonthlyBalances() {
		// default constructor
	}

	public Money getBalance() {
		return balance;
	}

	public void setBalance(Money balance) {
		this.balance = balance;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
}

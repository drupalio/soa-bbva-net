package com.bbva.czic.accounts.business.dto;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;

public class DTOIntMonthlyBalances {

	public final static long serialVersionUID = 1L;
	private Money balance;
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

package com.bbva.czic.accounts.business.dto;

public class DTOIntMonthlyBalances<Money> {

	public final static long serialVersionUID = 1L;
	private Money balance;
	private DTOIntEnumMonth month;

	public DTOIntMonthlyBalances() {
		// default constructor
	}

	public Money getBalance() {
		return balance;
	}

	public void setBalance(Money balance) {
		this.balance = balance;
	}

	public DTOIntEnumMonth getMonth() {
		return month;
	}

	public void setMonth(DTOIntEnumMonth month) {
		this.month = month;
	}

}

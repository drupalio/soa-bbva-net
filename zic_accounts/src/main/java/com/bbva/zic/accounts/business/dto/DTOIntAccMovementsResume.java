package com.bbva.zic.accounts.business.dto;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;

import javax.validation.constraints.NotNull;

public class DTOIntAccMovementsResume {

	public final static long serialVersionUID = 1L;
	private Money income;
	private Money outcome;
	@NotNull
	private Money balance;
	@NotNull
	private String month;

	public DTOIntAccMovementsResume() {
		// default constructor
	}

	public Money getIncome() {
		return income;
	}

	public void setIncome(Money income) {
		this.income = income;
	}

	public Money getOutcome() {
		return outcome;
	}

	public void setOutcome(Money outcome) {
		this.outcome = outcome;
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

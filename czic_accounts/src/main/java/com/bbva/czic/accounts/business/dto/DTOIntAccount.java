package com.bbva.czic.accounts.business.dto;

import java.util.Date;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;

public class DTOIntAccount {

	public final static long serialVersionUID = 1L;
	private Money tradeBalance;
	private Date startMonth;
	private Date endMonth;
	private String searchMonth;

	public DTOIntAccount() {
		// default constructor
	}

	public Money getTradeBalance() {
		return tradeBalance;
	}

	public void setTradeBalance(Money tradeBalance) {
		this.tradeBalance = tradeBalance;
	}

	// Se agregan los campos startMonth, de acuerdo a la plantilla ASO para el
	// SMC getAccountMonthlyBalance

	public Date getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(Date startMonth) {
		this.startMonth = startMonth;
	}

	public Date getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(Date endMonth) {
		this.endMonth = endMonth;
	}

	public String getSearchMonth() {
		return searchMonth;
	}

	public void setSearchMonth(String searchMonth) {
		this.searchMonth = searchMonth;
	}

}

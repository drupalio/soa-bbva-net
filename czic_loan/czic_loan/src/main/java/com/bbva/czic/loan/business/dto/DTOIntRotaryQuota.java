package com.bbva.czic.loan.business.dto;

import com.bbva.czic.dto.net.Balance;
import com.bbva.czic.dto.net.EnumLoanStatus;
import com.bbva.czic.dto.net.Payment;

public class DTOIntRotaryQuota {

	public final static long serialVersionUID = 1L;

	private Balance balance;

	private Payment payment;

	private EnumLoanStatus status;

	public DTOIntRotaryQuota() {
		// default constructor
	}

	public Balance getBalance() {
		return balance;
	}

	public void setBalance(Balance balance) {
		this.balance = balance;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public EnumLoanStatus getStatus() {
		return status;
	}

	public void setStatus(EnumLoanStatus status) {
		this.status = status;
	}

}

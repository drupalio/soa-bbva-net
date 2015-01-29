package com.bbva.czic.loan.business.dto;

import com.bbva.czic.dto.net.Balance;
import com.bbva.czic.dto.net.EnumLoanStatus;
import com.bbva.czic.dto.net.Payment;
import com.bbva.czic.dto.net.Product;

public class DTOIntLoan extends Product {

	public final static long serialVersionUID = 1L;

	private Balance debt;

	private Payment payment;

	private String status;

	public DTOIntLoan() {
		// default constructor
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Balance getDebt() {
		return debt;
	}

	public void setDebt(Balance debt) {
		this.debt = debt;
	}

}

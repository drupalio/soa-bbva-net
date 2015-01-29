package com.bbva.czic.loan.business.dto;

import com.bbva.czic.dto.net.Balance;
import com.bbva.czic.dto.net.EnumLoanStatus;
import com.bbva.czic.dto.net.Payment;
import com.bbva.czic.dto.net.Product;

public class DTOIntLoan  {

	public final static long serialVersionUID = 1L;

	private String id;

	private String type;

	private String name;

	private Balance balance;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Balance getBalance() {
		return balance;
	}

	public void setBalance(Balance balance) {
		this.balance = balance;
	}
}

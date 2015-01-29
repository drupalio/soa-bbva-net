package com.bbva.czic.dto.net;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import java.util.Calendar;

public class RotaryQuotaMove {
	public final static long serialVersionUID = 1L;

	private String id;

	private Operation operation;

	private String concept;

	private Calendar transactionDate;

	private String status;

	private Money value;

	private Balance balance;


	public RotaryQuotaMove() {
		//default constructor
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public Calendar getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Calendar transactionDate) {
		this.transactionDate = transactionDate;
	}


	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Money getValue() {
		return value;
	}

	public void setValue(Money value) {
		this.value = value;
	}

	public Balance getBalance() {
		return balance;
	}

	public void setBalance(Balance balance) {
		this.balance = balance;
	}


}


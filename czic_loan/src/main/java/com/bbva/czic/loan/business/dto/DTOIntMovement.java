package com.bbva.czic.loan.business.dto;

import java.util.Calendar;


import com.bbva.czic.dto.net.*;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

public class DTOIntMovement {

	private String id;

	private String concept;

	private Calendar transactionDate;

	private Operation operation;

	private EnumMovementStatus status;

	private Money value;

	private Money balance;

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

	public EnumMovementStatus getStatus() {
		return status;
	}


	public void setStatus(EnumMovementStatus status) {
		this.status = status;
	}


	public Money getValue() {
		return value;
	}


	public void setValue(Money value) {
		this.value = value;
	}

	public Money getBalance() {
		return balance;
	}

	public void setBalance(Money balance) {
		this.balance = balance;
	}
}

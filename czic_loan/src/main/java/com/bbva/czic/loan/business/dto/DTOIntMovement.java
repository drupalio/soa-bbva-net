package com.bbva.czic.loan.business.dto;

import java.util.Calendar;


import com.bbva.czic.dto.net.*;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class DTOIntMovement {

	@NotNull
	private String id;

	@NotNull
	private String concept;

	@NotNull
	private Calendar transactionDate;

	@NotNull
	private Operation operation;

	@NotNull
	private Money value;

	@NotNull
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

package com.bbva.czic.loan.business.dto;

import java.util.Calendar;
import java.util.Date;

import com.bbva.czic.dto.net.*;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

public class DTOIntMovement {

	public final static long serialVersionUID = 1L;

	private String id;

	private String concept;

	private Date transactionDate;

	private Calendar operationDate;

	private String sourceReference;

	private String destinationReference;

	private Operation operation;

	private Office office;

	private EnumMovementStatus status;

	private Money value;

	private Balance balance;

	public DTOIntMovement() {
		// default constructor
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

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Calendar getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Calendar operationDate) {
		this.operationDate = operationDate;
	}

	public String getSourceReference() {
		return sourceReference;
	}

	public void setSourceReference(String sourceReference) {
		this.sourceReference = sourceReference;
	}

	public String getDestinationReference() {
		return destinationReference;
	}

	public void setDestinationReference(String destinationReference) {
		this.destinationReference = destinationReference;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
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

	public Balance getBalance() {
		return balance;
	}

	public void setBalance(Balance balance) {
		this.balance = balance;
	}

}

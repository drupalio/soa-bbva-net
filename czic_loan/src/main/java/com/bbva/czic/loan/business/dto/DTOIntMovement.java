package com.bbva.czic.loan.business.dto;

import java.util.Date;

import com.bbva.czic.dto.net.EnumAccountState;
import com.bbva.czic.dto.net.Office;
import com.bbva.czic.dto.net.Operation;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

public class DTOIntMovement {

	public final static long serialVersionUID = 1L;

	private String id;

	private String concept;

	private Date transactionDate;

	private Date operationDate;

	private String sourceReference;

	private String destinationReference;

	private Operation operation;

	private Office office;

	private EnumAccountState status;

	private Money value;

	private Money balance;

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

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
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

	public EnumAccountState getStatus() {
		return status;
	}

	public void setStatus(EnumAccountState status) {
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

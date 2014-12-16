
package com.bbva.czic.globalposition.business.dto;

import java.util.Date;


import com.bbva.jee.arq.spring.core.servicing.utils.Money;

public class DTOIntMovement {

    public final static long serialVersionUID = 1L;
    private String movementId;
    private String concept;
    private Date transactionDate;
    private String sourceReference;
    private String destinationReference;
    private DTOIntOperation operation;
    private Money value;
    private Money balance;

    public DTOIntMovement() {
        //default constructor
    }

    public String getMovementId() {
        return movementId;
    }

    public void setMovementId(String movementId) {
        this.movementId = movementId;
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

    public DTOIntOperation getOperation() {
        return operation;
    }

    public void setOperation(DTOIntOperation operation) {
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

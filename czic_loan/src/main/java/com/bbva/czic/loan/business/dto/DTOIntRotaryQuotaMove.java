package com.bbva.czic.loan.business.dto;

import com.bbva.czic.dto.net.Balance;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.dto.net.Operation;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

import java.util.Calendar;


/**
 * Created by Entelgy on 17/01/2015.
 */
public class DTOIntRotaryQuotaMove {

    private String id;

    private String concept;

    private Calendar transactionDate;

    private Operation operation;

    private String status;

    private Money value;

    private Balance balance;

    private Integer numbersOfQuota;

    private Integer remainingQuotas;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
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

    public Integer getNumbersOfQuota() {
        return numbersOfQuota;
    }

    public void setNumbersOfQuota(Integer numbersOfQuota) {
        this.numbersOfQuota = numbersOfQuota;
    }

    public Integer getRemainingQuotas() {
        return remainingQuotas;
    }

    public void setRemainingQuotas(Integer remainingQuotas) {
        this.remainingQuotas = remainingQuotas;
    }
}

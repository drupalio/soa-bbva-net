
package com.bbva.czic.products.business.dto;

import java.util.Date;


import com.bbva.jee.arq.spring.core.servicing.utils.Money;

public class DTOIntMovement {

    public final static long serialVersionUID = 1L;
    private String id;
    private Date transactionDate;
    private Date operationDate;
    private String concept;
    private Money value;
    private Money balance;
    private DTOIntOperation operation;
    private DTOIntOffice office;
    private DTOIntEnumAccountState status;
    private String productId;
    private DTOIntEnumProductType productType;

    public DTOIntMovement() {
        //default constructor
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
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

    public DTOIntOperation getOperation() {
        return operation;
    }

    public void setOperation(DTOIntOperation operation) {
        this.operation = operation;
    }

    public DTOIntOffice getOffice() {
        return office;
    }

    public void setOffice(DTOIntOffice office) {
        this.office = office;
    }

    public DTOIntEnumAccountState getStatus() {
        return status;
    }

    public void setStatus(DTOIntEnumAccountState status) {
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public DTOIntEnumProductType getProductType() {
        return productType;
    }

    public void setProductType(DTOIntEnumProductType productType) {
        this.productType = productType;
    }

}

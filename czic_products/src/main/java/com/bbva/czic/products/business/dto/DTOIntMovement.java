
package com.bbva.czic.products.business.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;

public class DTOIntMovement {

    public final static long serialVersionUID = 1L;
    @NotNull
    private String id;

    private String customerId;
    @NotNull
    private String productId;

    private String productType;
    @NotNull
    private String concept;
    @NotNull
    private Money value;
    @NotNull
    private Money balance;
    @NotNull
    private DTOIntOperation operation;
    @NotNull
    private Date transactionDate;
    @NotNull
    private Date operationDate;
    @NotNull
    private DTOIntOffice office;

    private String status;

    private Money originValue;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

	public Money getOriginValue() {
		return originValue;
	}

	public void setOriginValue(Money originValue) {
		this.originValue = originValue;
	}


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}

package com.bbva.czic.products.business.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Entelgy on 29/01/2015.
 */
public class DTOIntFilterMovements {
    private String productType;
    @NotNull
    @NotEmpty
    @Size(min=8,max=8)
    private String customerId;
    private String movementId;
    @NotNull
    @NotEmpty
    @Size(min=20,max=20)
    private String productId;
    private Integer paginationKey;
    private Integer pageSize;
    private String transactionDateStart ;
    private String transactionDateEnd ;
    private String valueStart;
    private String valueEnd;

    public String getMovementId() {
        return movementId;
    }

    public void setMovementId(String movementId) {
        this.movementId = movementId;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getPaginationKey() {
        return paginationKey;
    }

    public void setPaginationKey(Integer paginationKey) {
        this.paginationKey = paginationKey;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getTransactionDateStart() {
        return transactionDateStart;
    }

    public void setTransactionDateStart(String transactionDateStart) {
        this.transactionDateStart = transactionDateStart;
    }

    public String getTransactionDateEnd() {
        return transactionDateEnd;
    }

    public void setTransactionDateEnd(String transactionDateEnd) {
        this.transactionDateEnd = transactionDateEnd;
    }

    public String getValueStart() {
        return valueStart;
    }

    public void setValueStart(String valueStart) {
        this.valueStart = valueStart;
    }

    public String getValueEnd() {
        return valueEnd;
    }

    public void setValueEnd(String valueEnd) {
        this.valueEnd = valueEnd;
    }
}

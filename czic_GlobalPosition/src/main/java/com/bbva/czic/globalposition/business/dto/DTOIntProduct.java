
package com.bbva.czic.globalposition.business.dto;

import java.util.List;


import com.bbva.czic.dto.net.Balance;

public class DTOIntProduct {

    public final static long serialVersionUID = 1L;
    private String id;
    private String productType;
    private String name;
    private String alias;
    private DTOIntEnumFinancialStatusType financialState;
    private Boolean visible;
    private Boolean operable;
    private Balance balance;
    private DTOIntContactInfo contactInfo;

    public DTOIntProduct() {
        //default constructor
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public DTOIntEnumFinancialStatusType getFinancialState() {
        return financialState;
    }

    public void setFinancialState(DTOIntEnumFinancialStatusType financialState) {
        this.financialState = financialState;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getOperable() {
        return operable;
    }

    public void setOperable(Boolean operable) {
        this.operable = operable;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public DTOIntContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(DTOIntContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }
}


package com.bbva.zic.globalposition.business.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class DTOIntProduct {

    public final static long serialVersionUID = 1L;
    @NotEmpty
    @Pattern(regexp = "^(\\d{20}|\\d{16})$")
    private String id;
    @NotEmpty
    @Pattern(regexp = "^[A-Z]{2}$")
    private String productType;
    @NotEmpty
    private String name;
    private String alias;
    private String financialState;
    @NotNull
    private Boolean visible;
    @NotNull
    private Boolean operable;
    private DTOIntBalance balance;
    private DTOIntContactInfo contactInfo;
    private DTOIntContract contract;

    public DTOIntProduct() {
        balance = new DTOIntBalance();
        contactInfo = new DTOIntContactInfo();
        contract = new DTOIntContract();
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

    public String getFinancialState() {
        return financialState;
    }

    public void setFinancialState(String financialState) {
        this.financialState = financialState;
    }

    public Boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean isOperable() {
        return operable;
    }

    public void setOperable(Boolean operable) {
        this.operable = operable;
    }

    public DTOIntBalance getBalance() {
        return balance;
    }

    public void setBalance(DTOIntBalance balance) {
        this.balance = balance;
    }

    public DTOIntContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(DTOIntContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public DTOIntContract getContract() {
        return contract;
    }

    public void setContract(DTOIntContract contract) {
        this.contract = contract;
    }

}

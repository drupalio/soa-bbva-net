
package com.bbva.czic.globalposition.business.dto;

import java.util.List;


import com.bbva.jee.arq.spring.core.servicing.utils.Money;

public class DTOIntProduct {

    public final static long serialVersionUID = 1L;
    private String productId;
    private String productType;
    private String name;
    private String alias;
    private DTOIntEnumFinancialStatusType financialState;
    private Boolean visible;
    private Boolean operable;
    private Money assets;
    private Money liabilities;
    private Money ownersEquity;
    private DTOIntContactInformation contactInfo;
    private List<DTOIntMovement> movements;

    public DTOIntProduct() {
        //default constructor
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

    public Money getAssets() {
        return assets;
    }

    public void setAssets(Money assets) {
        this.assets = assets;
    }

    public Money getLiabilities() {
        return liabilities;
    }

    public void setLiabilities(Money liabilities) {
        this.liabilities = liabilities;
    }

    public Money getOwnersEquity() {
        return ownersEquity;
    }

    public void setOwnersEquity(Money ownersEquity) {
        this.ownersEquity = ownersEquity;
    }

    public DTOIntContactInformation getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(DTOIntContactInformation contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<DTOIntMovement> getMovements() {
        return movements;
    }

    public void setMovements(List<DTOIntMovement> movements) {
        this.movements = movements;
    }

}

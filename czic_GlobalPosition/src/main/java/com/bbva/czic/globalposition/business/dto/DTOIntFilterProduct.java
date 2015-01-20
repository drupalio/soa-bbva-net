package com.bbva.czic.globalposition.business.dto;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Entelgy Colombia.
 */
public class DTOIntFilterProduct {

    @NotEmpty
    private String idCustomer;

    private String productType;

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}

package com.bbva.czic.globalposition.business.dto;

import com.bbva.czic.dto.net.EnumProductType;

/**
 * Created by Administrador on 05/01/2015.
 */
public class DTOIntFilterProduct {

    private String idCustomer;

    private EnumProductType productType;

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public EnumProductType getProductType() {
        return productType;
    }

    public void setProductType(EnumProductType productType) {
        this.productType = productType;
    }
}

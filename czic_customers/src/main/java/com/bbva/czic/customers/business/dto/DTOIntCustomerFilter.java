package com.bbva.czic.customers.business.dto;

import javax.validation.constraints.Pattern;

/**
 * @author Entelgy Colombia.
 */
public class DTOIntCustomerFilter {

//    @Pattern(regexp = "[0-9]{8}")
    private String idDocument;

    public String getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(String id) {
        this.idDocument = id;
    }
}

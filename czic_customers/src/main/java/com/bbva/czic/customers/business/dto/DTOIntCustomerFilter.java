package com.bbva.czic.customers.business.dto;

import javax.validation.constraints.Pattern;

/**
 * @author Entelgy Colombia.
 */
public class DTOIntCustomerFilter {

//    @Pattern(regexp = "[0-9]{8}")
    private String idDocument;

    public String getId() {
        return idDocument;
    }

    public void setId(String id) {
        this.idDocument = id;
    }
}

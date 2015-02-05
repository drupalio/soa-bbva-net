package com.bbva.czic.customers.business.dto;

import javax.validation.constraints.Pattern;

/**
 * @author Entelgy Colombia.
 */
public class DTOIntCustomerFilter {

    @Pattern(regexp = "[0-9]{8}")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

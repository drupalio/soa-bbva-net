package com.bbva.czic.customers.facade.v01.impl;

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

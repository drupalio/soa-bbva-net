package com.bbva.czic.customers.business.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Created by Entelgy on 30/01/2015.
 */
public class DTOIntAddChannel {

    @NotNull
    @Length(min = 8, max = 8)
    private String customerId;

    public DTOIntAddChannel(){    }

    public DTOIntAddChannel(String customerId){
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}

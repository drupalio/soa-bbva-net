
package com.bbva.zic.customers.business.dto;




public class DTOIntUser {

    public final static long serialVersionUID = 1L;
    private String customerId;

    public DTOIntUser() {
        //default constructor
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

}

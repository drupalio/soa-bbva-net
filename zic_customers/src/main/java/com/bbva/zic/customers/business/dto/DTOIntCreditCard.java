
package com.bbva.zic.customers.business.dto;




public class DTOIntCreditCard {

    public final static long serialVersionUID = 1L;
    private String number;

    public DTOIntCreditCard() {
        //default constructor
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}

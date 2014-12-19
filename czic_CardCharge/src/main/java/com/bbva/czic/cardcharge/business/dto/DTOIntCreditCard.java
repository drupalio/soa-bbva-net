
package com.bbva.czic.cardcharge.business.dto;




public class DTOIntCreditCard {

    public final static long serialVersionUID = 1L;
    private String excecutiveId;

    public DTOIntCreditCard() {
        //default constructor
    }

    public String getExcecutiveId() {
        return excecutiveId;
    }

    public void setExcecutiveId(String excecutiveId) {
        this.excecutiveId = excecutiveId;
    }

}


package com.bbva.czic.internationalcontracttransfer.business.dto;




public class DTOIntBank {

    public final static long serialVersionUID = 1L;
    private String name;
    private String bicCode;

    public DTOIntBank() {
        //default constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBicCode() {
        return bicCode;
    }

    public void setBicCode(String bicCode) {
        this.bicCode = bicCode;
    }

}


package com.bbva.czic.internationalcontracttransfer.business.dto;




public class DTOIntExternalReference {

    public final static long serialVersionUID = 1L;
    private String id;
    private String value;

    public DTOIntExternalReference() {
        //default constructor
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

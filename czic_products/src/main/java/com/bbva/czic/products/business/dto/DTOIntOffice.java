
package com.bbva.czic.products.business.dto;


import javax.validation.constraints.NotNull;

public class DTOIntOffice {

    public final static long serialVersionUID = 1L;
    @NotNull
    private String name;
    @NotNull
    private String code;

    private String postalAddress;

    private DTOIntLocation location;


    public DTOIntOffice() {
        //default constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public DTOIntLocation getLocation() {
        return location;
    }

    public void setLocation(DTOIntLocation location) {
        this.location = location;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}


package com.bbva.zic.products.business.dto;




public class DTOIntOffice {

    public final static long serialVersionUID = 1L;
    private String name;
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

}

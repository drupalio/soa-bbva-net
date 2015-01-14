
package com.bbva.czic.products.business.dto;




public class DTOIntLocation {

    public final static long serialVersionUID = 1L;
    private DTOIntCity city;
    private DTOIntCountry country;

    public DTOIntLocation() {
        //default constructor
    }

    public DTOIntCity getCity() {
        return city;
    }

    public void setCity(DTOIntCity city) {
        this.city = city;
    }

    public DTOIntCountry getCountry() {
        return country;
    }

    public void setCountry(DTOIntCountry country) {
        this.country = country;
    }

}


package com.bbva.zic.products.business.dto;




public class DTOIntLocation {

    public final static long serialVersionUID = 1L;
    private DTOIntCity city;
    private DTOIntCountry country;
    private DTOIntState dtoIntState;

    public DTOIntLocation() {
        //default constructor
    }

    public DTOIntState getDtoIntState() {
        return dtoIntState;
    }

    public void setDtoIntState(DTOIntState dtoIntState) {
        this.dtoIntState = dtoIntState;
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

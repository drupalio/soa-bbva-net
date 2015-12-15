
package com.bbva.czic.internationalcontracttransfer.business.dto;

import java.util.List;



public class DTOIntContract {

    public final static long serialVersionUID = 1L;
    private DTOIntBank bank;
    private DTOIntCountry country;
    private DTOIntAddress address;
    private DTOIntProduct product;
    private List<DTOIntPerson> participants;

    public DTOIntContract() {
        //default constructor
    }

    public DTOIntBank getBank() {
        return bank;
    }

    public void setBank(DTOIntBank bank) {
        this.bank = bank;
    }

    public DTOIntCountry getCountry() {
        return country;
    }

    public void setCountry(DTOIntCountry country) {
        this.country = country;
    }

    public DTOIntAddress getAddress() {
        return address;
    }

    public void setAddress(DTOIntAddress address) {
        this.address = address;
    }

    public DTOIntProduct getProduct() {
        return product;
    }

    public void setProduct(DTOIntProduct product) {
        this.product = product;
    }

    public List<DTOIntPerson> getParticipants() {
        return participants;
    }

    public void setParticipants(List<DTOIntPerson> participants) {
        this.participants = participants;
    }

}

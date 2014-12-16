
package com.bbva.czic.globalposition.business.dto;

import java.util.List;



public class DTOIntContactInformation {

    public final static long serialVersionUID = 1L;
    private List<DTOIntPhoneNumber> phoneNumbers;
    private List<DTOIntEmail> emails;

    public DTOIntContactInformation() {
        //default constructor
    }

    public List<DTOIntPhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<DTOIntPhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<DTOIntEmail> getEmails() {
        return emails;
    }

    public void setEmails(List<DTOIntEmail> emails) {
        this.emails = emails;
    }

}

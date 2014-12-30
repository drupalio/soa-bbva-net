
package com.bbva.czic.globalposition.business.dto;




public class DTOIntPhoneNumber {

    public final static long serialVersionUID = 1L;
    private String number;
    private String countryCode;
    private String regionalCode;
    private DTOIntEnumPhoneNumberType type;
    private Boolean primary;
    private Boolean active;
    private DTOIntEnumContactSourceType contactSource;

    public DTOIntPhoneNumber() {
        //default constructor
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getRegionalCode() {
        return regionalCode;
    }

    public void setRegionalCode(String regionalCode) {
        this.regionalCode = regionalCode;
    }

    public DTOIntEnumPhoneNumberType getType() {
        return type;
    }

    public void setType(DTOIntEnumPhoneNumberType type) {
        this.type = type;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public DTOIntEnumContactSourceType getContactSource() {
        return contactSource;
    }

    public void setContactSource(DTOIntEnumContactSourceType contactSource) {
        this.contactSource = contactSource;
    }

}

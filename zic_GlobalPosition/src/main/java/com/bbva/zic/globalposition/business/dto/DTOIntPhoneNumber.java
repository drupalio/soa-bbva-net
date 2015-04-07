
package com.bbva.zic.globalposition.business.dto;


import com.bbva.zic.dto.net.EnumContactSourceType;
import com.bbva.zic.dto.net.EnumPhoneNumberType;

public class DTOIntPhoneNumber {

    public final static long serialVersionUID = 1L;
    private String number;
    private String countryCode;
    private String regionalCode;
    private EnumPhoneNumberType type;
    private Boolean primary;
    private Boolean active;
    private EnumContactSourceType contactSource;

    public DTOIntPhoneNumber() {
    }

    public DTOIntPhoneNumber(String number) {
        this.number = number;
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

    public EnumPhoneNumberType getType() {
        return type;
    }

    public void setType(EnumPhoneNumberType type) {
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

    public EnumContactSourceType getContactSource() {
        return contactSource;
    }

    public void setContactSource(EnumContactSourceType contactSource) {
        this.contactSource = contactSource;
    }
}

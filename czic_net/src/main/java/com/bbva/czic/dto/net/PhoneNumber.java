
package com.bbva.czic.dto.net;

import com.wordnik.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name = "phoneNumber", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "phoneNumber", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneNumber
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty("")
    private String number;
    @ApiModelProperty("")
    private String countryCode;
    @ApiModelProperty("")
    private String regionalCode;
    @ApiModelProperty("")
    private EnumPhoneNumberType type;
    @ApiModelProperty("")
    private Boolean primary;
    @ApiModelProperty("")
    private Boolean active;
    @ApiModelProperty("")
    private EnumContactSourceType contactSource;

    public PhoneNumber() {
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

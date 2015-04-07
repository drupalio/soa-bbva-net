
package com.bbva.zic.dto.net;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.validator.constraints.NotBlank;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "PhoneNumber", namespace = "urn:com:bbva:zic:dto:net")
@XmlType(name = "PhoneNumber", namespace = "urn:com:bbva:zic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneNumber
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty("Fuente de los contactos")
    private String contactSource;
    @ApiModelProperty("Codigo del pais")
    private String countryCode;
    @ApiModelProperty(" Codigo de la region")
    private String regionalCode;
    @ApiModelProperty("Numero de telefono")
    private String number;
    @ApiModelProperty("Fuente de tipo de numero")
    private String type;
    @ApiModelProperty("Numero por defecto")
    private Boolean primary;
    @ApiModelProperty("Numero activo")
    private Boolean active;

    public PhoneNumber() {
        //default constructor
    }

    public String getContactSource() {
        return contactSource;
    }

    public void setContactSource(String contactSource) {
        this.contactSource = contactSource;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

}

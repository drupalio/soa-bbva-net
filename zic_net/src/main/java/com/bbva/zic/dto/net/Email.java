
package com.bbva.zic.dto.net;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.validator.constraints.NotBlank;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Email", namespace = "urn:com:bbva:zic:dto:net")
@XmlType(name = "Email", namespace = "urn:com:bbva:zic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Email
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty("Fuente de los contactos")
    private String source;
    @ApiModelProperty("Direccion de correo electronico")
	@org.hibernate.validator.constraints.Email
    private String address;
    @ApiModelProperty(" Correo por defecto")
    private Boolean primary;
    @ApiModelProperty("Correo activo")
    private Boolean active;

    public Email() {
        //default constructor
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

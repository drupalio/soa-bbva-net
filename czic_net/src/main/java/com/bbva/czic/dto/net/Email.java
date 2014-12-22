
package com.bbva.czic.dto.net;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Email", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Email", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Email
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty("Fuente de los contactos")
    private EnumContactSourceType source;
    @ApiModelProperty("Direccion de correo electronico")
    private String addres;
    @ApiModelProperty(" Correo por defecto")
    private Boolean primary;
    @ApiModelProperty("Correo activo")
    private Boolean active;

    public Email() {
        //default constructor
    }

    public EnumContactSourceType getSource() {
        return source;
    }

    public void setSource(EnumContactSourceType source) {
        this.source = source;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
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

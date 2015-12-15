
package com.bbva.czic.dto.net;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "bank", namespace = "urn:com:bbva:czic:internationalcontracttransfer:facade:v01:dto")
@XmlType(name = "bank", namespace = "urn:com:bbva:czic:internationalcontracttransfer:facade:v01:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Bank
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty("Descripcion del banco")
    private String name;
    @ApiModelProperty("Codigo del banco necesario para hacer transferencias entre bancos fuera de la Union Europea")
    private String bicCode;

    public Bank() {
        //default constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBicCode() {
        return bicCode;
    }

    public void setBicCode(String bicCode) {
        this.bicCode = bicCode;
    }

}

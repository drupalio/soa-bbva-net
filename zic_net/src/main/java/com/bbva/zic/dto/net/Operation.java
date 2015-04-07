
package com.bbva.zic.dto.net;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Operation", namespace = "urn:com:bbva:zic:dto:net")
@XmlType(name = "Operation", namespace = "urn:com:bbva:zic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Operation
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty(value = "C\u00f3digo del tipo de operaci\u00f3n", required = true)
    private String code;
    @ApiModelProperty(value = "Descripcion de la operacion", required = true)
    private String description;

    public Operation() {
        //default constructor
    }

    public Operation(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

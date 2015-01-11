
package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.validator.constraints.NotBlank;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Operation", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Operation", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Operation
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty(value = "C\u00f3digo del tipo de operaci\u00f3n", required = true)
    @NotBlank
    private String code;
    @ApiModelProperty(value = "Descripcion de la operacion", required = true)
    @NotBlank
    private String description;

    public Operation() {
        //default constructor
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

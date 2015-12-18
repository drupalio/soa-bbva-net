
package com.bbva.czic.dto.net;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "externalReference", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "externalReference", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExternalReference
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty("Identificador de la referencia externa")
    private String id;
    @ApiModelProperty("Valor de la referencia externa")
    private String value;

    public ExternalReference() {
        //default constructor
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

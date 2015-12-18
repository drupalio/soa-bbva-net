
package com.bbva.czic.dto.net;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.wordnik.swagger.annotations.ApiModelProperty;



@XmlRootElement(name = "identityDocument", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "identityDocument", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class IdentityDocument
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty("Documento utilizado para identificar una persona")
    private String number;

    public IdentityDocument() {
        //default constructor
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}

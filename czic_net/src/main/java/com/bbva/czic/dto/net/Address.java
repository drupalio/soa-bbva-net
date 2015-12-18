
package com.bbva.czic.dto.net;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.wordnik.swagger.annotations.ApiModelProperty;



@XmlRootElement(name = "address", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "address", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Address
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty("Ciudad de la direccion")
    private String city;

    public Address() {
        //default constructor
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}

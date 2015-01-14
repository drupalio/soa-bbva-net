
package com.bbva.czic.products.facade.v01.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Location", namespace = "urn:com:bbva:czic:products:facade:v01:dto")
@XmlType(name = "Location", namespace = "urn:com:bbva:czic:products:facade:v01:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Location
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty(value = "Id del pais", required = true)
    private City city;
    @ApiModelProperty(value = "Nombre del pais", required = true)
    private Country country;

    public Location() {
        //default constructor
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}

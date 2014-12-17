
package com.bbva.czic.dto.net;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Location", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Location", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Location
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty("Ciudad d\u00f3nde se origin\u00f3")
    private City city;
    @ApiModelProperty("Categor\u00eda sobre la cual se evaluan los costos de operaciones en dicha ubicacion")
    private String category;

    public Location() {
        //default constructor
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}

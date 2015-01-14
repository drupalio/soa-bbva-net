
package com.bbva.czic.products.facade.v01.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "City", namespace = "urn:com:bbva:czic:products:facade:v01:dto")
@XmlType(name = "City", namespace = "urn:com:bbva:czic:products:facade:v01:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class City
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty(value = "Id de la ciudad", required = true)
    private String id;
    @ApiModelProperty(value = "Nombre de la ciudad", required = true)
    private String name;

    public City() {
        //default constructor
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}


package com.bbva.czic.products.facade.v01.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Country", namespace = "urn:com:bbva:czic:products:facade:v01:dto")
@XmlType(name = "Country", namespace = "urn:com:bbva:czic:products:facade:v01:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Country
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty(value = "Id del pais", required = true)
    private String id;
    @ApiModelProperty(value = "Nombre del pais", required = true)
    private String name;

    public Country() {
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

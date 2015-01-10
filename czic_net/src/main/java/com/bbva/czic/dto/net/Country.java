
package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Country", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Country", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Country
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty(value = " Identificador del pais", required = true)
    private String id;
    @ApiModelProperty("Nombre del pais")
    private String name;
    @ApiModelProperty("Estados pertenecientes al pais")
    private List<State> states;

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

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

    
}


package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;





import org.hibernate.validator.constraints.NotBlank;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "State", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "State", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class State
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty(value = " Identificador del estado", required = true)
    private String id;
    @ApiModelProperty(value = "Nombre", required = true)
    private String name;
    @ApiModelProperty("ciudades pertenecientes al estado o departamento")
    private List<City> cities;

    public State() {
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

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

    
}

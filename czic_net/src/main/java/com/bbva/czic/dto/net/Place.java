
package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Place", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Place", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Place
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty("Ciudad d\u00f3nde se origin\u00f3")
    private String cityName;
    @ApiModelProperty("Pais d\u00f3nde se origin\u00f3")
    private Country countryName;
    @ApiModelProperty("estado o departamento d\u00f3nde se origin\u00f3")
    private State stateName;
    @ApiModelProperty("direccion d\u00f3nde se origin\u00f3")
    private String postalAddress;

    public Place() {
        //default constructor
    }

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Country getCountryName() {
		return countryName;
	}

	public void setCountryName(Country countryName) {
		this.countryName = countryName;
	}

	public State getStateName() {
		return stateName;
	}

	public void setStateName(State stateName) {
		this.stateName = stateName;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}
    
}

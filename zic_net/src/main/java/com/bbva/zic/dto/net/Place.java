
package com.bbva.zic.dto.net;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Place", namespace = "urn:com:bbva:zic:dto:net")
@XmlType(name = "Place", namespace = "urn:com:bbva:zic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Place
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty("Ciudad d\u00f3nde se origin\u00f3")
    private String cityName;
    @ApiModelProperty("Pais d\u00f3nde se origin\u00f3")
    private String countryName;
    @ApiModelProperty("estado o departamento d\u00f3nde se origin\u00f3")
    private String stateName;
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

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}  
}

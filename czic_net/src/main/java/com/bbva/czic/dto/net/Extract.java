
package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.validator.constraints.NotEmpty;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Extracto", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Extracto", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Extract
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty("Mes del extracto")
    @NotNull
    private String month;
    @ApiModelProperty("Año del extracto")
    @NotEmpty
    private String year;
    @ApiModelProperty("Fecha de generación del extracto")
    private String generationDate;
    @ApiModelProperty("URL de ubicación del extracto")
    private String url;

    public Extract() {
        //default constructor
    }

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getGenerationDate() {
		return generationDate;
	}

	public void setGenerationDate(String generationDate) {
		this.generationDate = generationDate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}


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
    private EnumMonth month;
    @ApiModelProperty("Año del extracto")
    @NotEmpty
    private String year;
    @ApiModelProperty("Fecha de generación del extracto")
    private Calendar generationDate;

    public Extract() {
        //default constructor
    }

	public EnumMonth getMonth() {
		return month;
	}

	public void setMonth(EnumMonth month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Calendar getGenerationDate() {
		return generationDate;
	}

	public void setGenerationDate(Calendar generationDate) {
		this.generationDate = generationDate;
	}
    
    
}

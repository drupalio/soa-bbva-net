package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "exchangeRateAssessments", namespace = "urn:com:bbva:czic:exchangerate:facade:v01:dto")
@XmlType(name = "exchangeRateAssessments", namespace = "urn:com:bbva:czic:exchangerate:facade:v01:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExchangeRateAssessments implements Serializable {

	public final static long serialVersionUID = 1L;

	@ApiModelProperty("Tipo de tasa")
	private String type;

	@ApiModelProperty("Valor de la tasa")
	private BigDecimal value;

	public ExchangeRateAssessments() {
		// default constructor
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}

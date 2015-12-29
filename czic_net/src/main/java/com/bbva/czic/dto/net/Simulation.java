package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Simulation", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Simulation", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Simulation implements Serializable {

	public final static long serialVersionUID = 1L;

	@ApiModelProperty(value = "Identificador del simulador", required = true)
	private String id;

	@ApiModelProperty("Descripción del simulador")
	private String algorithm;

	public Simulation() {
		// default constructor
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

}

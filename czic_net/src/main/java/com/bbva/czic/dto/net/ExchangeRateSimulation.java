package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "ExchangeRateSimulation", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "ExchangeRateSimulation", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExchangeRateSimulation extends Simulation implements Serializable {

	public final static long serialVersionUID = 1L;

	@ApiModelProperty("Dato del tipo de la tasa")
	private OptionsList type;

	@ApiModelProperty("Listado de las tasas calculadas")
	private List<ExchangeRate> exchangeRates;

	public ExchangeRateSimulation() {
		// default constructor
	}

	public OptionsList getType() {
		return type;
	}

	public void setType(OptionsList type) {
		this.type = type;
	}

	public List<ExchangeRate> getExchangeRates() {
		return exchangeRates;
	}

	public void setExchangeRates(List<ExchangeRate> exchangeRates) {
		this.exchangeRates = exchangeRates;
	}

}

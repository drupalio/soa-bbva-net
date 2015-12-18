package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "exchangeRate", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "exchangeRate", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExchangeRate implements Serializable {

	public final static long serialVersionUID = 1L;

	@ApiModelProperty("Moneda del tipo de cambio")
	private Currency exchangeRateCurrency;

	@ApiModelProperty("Valoración asociada al cálculo o tasación del tipo de cambio")
	private List<ExchangeRateAssessments> exchangeRateAssessments;

	@ApiModelProperty("Detalle del tipo de cambio")
	private ExchangeRateValues exchangeRateValues;

	public ExchangeRate() {
		// default constructor
	}

	public Currency getExchangeRateCurrency() {
		return exchangeRateCurrency;
	}

	public void setExchangeRateCurrency(Currency exchangeRateCurrency) {
		this.exchangeRateCurrency = exchangeRateCurrency;
	}

	public List<ExchangeRateAssessments> getExchangeRateAssessments() {
		return exchangeRateAssessments;
	}

	public void setExchangeRateAssessments(List<ExchangeRateAssessments> exchangeRateAssessments) {
		this.exchangeRateAssessments = exchangeRateAssessments;
	}

	public ExchangeRateValues getExchangeRateValues() {
		return exchangeRateValues;
	}

	public void setExchangeRateValues(ExchangeRateValues exchangeRateValues) {
		this.exchangeRateValues = exchangeRateValues;
	}

}

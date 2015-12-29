package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "ExchangeRate", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "ExchangeRate", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExchangeRate implements Serializable {

	public final static long serialVersionUID = 1L;

	@ApiModelProperty("Moneda del tipo de cambio")
	private Currency baseRateCurrency;

	@ApiModelProperty("Moneda del tipo de cambio")
	private Currency exchangeRateCurrency;

	@ApiModelProperty("Fecha del tipo de cambio")
	private Date exchangeRateDate;

	@ApiModelProperty("Valoracion asociada al calculo o tasacion del tipo de cambio")
	private ExchangeRateAssessments exchangeRateAssessments;

	@ApiModelProperty("Detalle del tipo de cambio")
	private ExchangeRateValues exchangeRateValues;

	public ExchangeRate() {
		// default constructor
	}

	public Currency getBaseRateCurrency() {
		return baseRateCurrency;
	}

	public void setBaseRateCurrency(Currency baseRateCurrency) {
		this.baseRateCurrency = baseRateCurrency;
	}

	public Currency getExchangeRateCurrency() {
		return exchangeRateCurrency;
	}

	public void setExchangeRateCurrency(Currency exchangeRateCurrency) {
		this.exchangeRateCurrency = exchangeRateCurrency;
	}

	public Date getExchangeRateDate() {
		return exchangeRateDate;
	}

	public void setExchangeRateDate(Date exchangeRateDate) {
		this.exchangeRateDate = exchangeRateDate;
	}

	public ExchangeRateAssessments getExchangeRateAssessments() {
		return exchangeRateAssessments;
	}

	public void setExchangeRateAssessments(ExchangeRateAssessments exchangeRateAssessments) {
		this.exchangeRateAssessments = exchangeRateAssessments;
	}

	public ExchangeRateValues getExchangeRateValues() {
		return exchangeRateValues;
	}

	public void setExchangeRateValues(ExchangeRateValues exchangeRateValues) {
		this.exchangeRateValues = exchangeRateValues;
	}

}

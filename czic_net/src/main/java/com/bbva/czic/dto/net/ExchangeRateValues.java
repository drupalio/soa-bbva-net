package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "ExchangeRateValues", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "ExchangeRateValues", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExchangeRateValues implements Serializable {

	public final static long serialVersionUID = 1L;

	// @XmlJavaTypeAdapter(MoneyAdapter.class)
	@XmlElement(type = Money.class)
	@ApiModelProperty("Valor del tipo de cambio para la compra")
	private Money purchaseValue;

	// @XmlJavaTypeAdapter(MoneyAdapter.class)
	@XmlElement(type = Money.class)
	@ApiModelProperty("Valor del tipo de cambio para la venta")
	private Money saleValue;

	public ExchangeRateValues() {
		// default constructor
	}

	public Money getPurchaseValue() {
		return purchaseValue;
	}

	public void setPurchaseValue(Money purchaseValue) {
		this.purchaseValue = purchaseValue;
	}

	public Money getSaleValue() {
		return saleValue;
	}

	public void setSaleValue(Money saleValue) {
		this.saleValue = saleValue;
	}

}
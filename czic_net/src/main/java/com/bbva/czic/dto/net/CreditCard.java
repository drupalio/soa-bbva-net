package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "CreditCard", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "CreditCard", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreditCard extends Card implements Serializable {

	public final static long serialVersionUID = 1L;
	@ApiModelProperty("Entidad que posee toda un resumen de pagos de la tarjeta de cr\u00e9dito")
	@NotNull
	private Payment payment;
	@ApiModelProperty("Entidad que posee toda la informaci\u00f3n acerca de las cuotas de la tarjeta de cr\u00e9dito")
	@NotNull
	private Balance quota;

	public CreditCard() {
		// default constructor
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Balance getQuota() {
		return quota;
	}

	public void setQuota(Balance quota) {
		this.quota = quota;
	}

}

package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Transfer", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Transfer", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Transfer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Identificador de la transferencia")
	private String id;

	@ApiModelProperty(value = "Tipo de transferencia")
	private OptionsList type;

	@ApiModelProperty(value = "Fecha y hora de la transferencia")
	private String date;

	@ApiModelProperty(value = "Importe de la transferencia")
	private Money amount;

	@ApiModelProperty(value = "Estado de la transferencia")
	private OptionsList state;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public OptionsList getType() {
		return type;
	}

	public void setType(OptionsList type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Money getAmount() {
		return amount;
	}

	public void setAmount(Money amount) {
		this.amount = amount;
	}

	public OptionsList getState() {
		return state;
	}

	public void setState(OptionsList state) {
		this.state = state;
	}

}

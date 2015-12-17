package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "ContractTransfer", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "ContractTransfer", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContractTransfer extends Transfer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Datos del emisor de la transferencia")
	private ContractTransferSender sender;

	@ApiModelProperty(value = "Datos del receptor de la transferencia")
	private ContractTransferReceiver receiver;

	@ApiModelProperty(value = "Descripción de la transferencia")
	private String concept;

	public ContractTransferSender getSender() {
		return sender;
	}

	public void setSender(ContractTransferSender sender) {
		this.sender = sender;
	}

	public ContractTransferReceiver getReceiver() {
		return receiver;
	}

	public void setReceiver(ContractTransferReceiver receiver) {
		this.receiver = receiver;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

}

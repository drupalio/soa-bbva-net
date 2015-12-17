package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "ContractTransferSender", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "ContractTransfersender", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContractTransferSender implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Contrato desde el cual se hace el cargo sobre cierto importe que se transfiere hacia algún destinatario")
	private Contract contract;

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

}

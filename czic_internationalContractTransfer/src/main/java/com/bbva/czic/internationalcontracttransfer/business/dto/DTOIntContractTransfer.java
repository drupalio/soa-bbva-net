package com.bbva.czic.internationalcontracttransfer.business.dto;

public class DTOIntContractTransfer extends DTOIntTransfer {

	public final static long serialVersionUID = 1L;

	private DTOIntContractTransferSender sender;

	private DTOIntContractTransferReceiver receiver;

	private String concept;

	public DTOIntContractTransferSender getSender() {
		return sender;
	}

	public void setSender(DTOIntContractTransferSender sender) {
		this.sender = sender;
	}

	public DTOIntContractTransferReceiver getReceiver() {
		return receiver;
	}

	public void setReceiver(DTOIntContractTransferReceiver receiver) {
		this.receiver = receiver;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

}

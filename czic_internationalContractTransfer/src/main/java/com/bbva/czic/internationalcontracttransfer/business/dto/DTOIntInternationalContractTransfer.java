package com.bbva.czic.internationalcontracttransfer.business.dto;

import java.util.List;

public class DTOIntInternationalContractTransfer extends DTOIntContractTransfer {

	public final static long serialVersionUID = 1L;

	private DTOIntContract intermediaryBankAccount;

	private DTOIntExchangeRate exchangeRate;

	private DTOIntDocument formularyTransfer;

	private List<DTOIntExternalReference> references;

	public DTOIntInternationalContractTransfer() {
		// default constructor
	}

	public DTOIntContract getIntermediaryBankAccount() {
		return intermediaryBankAccount;
	}

	public void setIntermediaryBankAccount(DTOIntContract intermediaryBankAccount) {
		this.intermediaryBankAccount = intermediaryBankAccount;
	}

	public DTOIntExchangeRate getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(DTOIntExchangeRate exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public DTOIntDocument getFormularyTransfer() {
		return formularyTransfer;
	}

	public void setFormularyTransfer(DTOIntDocument formularyTransfer) {
		this.formularyTransfer = formularyTransfer;
	}

	public List<DTOIntExternalReference> getReferences() {
		return references;
	}

	public void setReferences(List<DTOIntExternalReference> references) {
		this.references = references;
	}

}

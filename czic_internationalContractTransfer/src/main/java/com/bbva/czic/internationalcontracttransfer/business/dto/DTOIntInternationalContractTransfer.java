package com.bbva.czic.internationalcontracttransfer.business.dto;

import java.util.List;

public class DTOIntInternationalContractTransfer extends DTOIntContractTransfer {

	public final static long serialVersionUID = 1L;

	private DTOIntContract intermediaryBankAccount;

	private List<DTOIntExchangeRate> exchangeRates;

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

	public List<DTOIntExchangeRate> getExchangeRates() {
		return exchangeRates;
	}

	public void setExchangeRates(List<DTOIntExchangeRate> exchangeRates) {
		this.exchangeRates = exchangeRates;
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

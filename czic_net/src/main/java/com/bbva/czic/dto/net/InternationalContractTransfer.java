package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "internationalContractTransfer", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "internationalContractTransfer", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class InternationalContractTransfer extends ContractTransfer implements Serializable {

	public final static long serialVersionUID = 1L;

	@ApiModelProperty("Cuenta que sirve como intermediario cuando el banco origen no tiene conexi\u00c3\u00b3n real con el banco destino")
	private Contract intermediaryBankAccount;

	@ApiModelProperty("Datos de las tasas correspondientes a la transaccion internacional")
	private List<ExchangeRate> exchangeRates;

	@ApiModelProperty("Documento del formulario cambiario")
	private Document formularyTransfer;

	@ApiModelProperty("Referencias de la transaccion internacional")
	private List<ExternalReference> references;

	public InternationalContractTransfer() {
		// default constructor
	}

	public Contract getIntermediaryBankAccount() {
		return intermediaryBankAccount;
	}

	public void setIntermediaryBankAccount(Contract intermediaryBankAccount) {
		this.intermediaryBankAccount = intermediaryBankAccount;
	}

	public List<ExchangeRate> getExchangeRates() {
		return exchangeRates;
	}

	public void setExchangeRates(List<ExchangeRate> exchangeRates) {
		this.exchangeRates = exchangeRates;
	}

	public Document getFormularyTransfer() {
		return formularyTransfer;
	}

	public void setFormularyTransfer(Document formularyTransfer) {
		this.formularyTransfer = formularyTransfer;
	}

	public List<ExternalReference> getReferences() {
		return references;
	}

	public void setReferences(List<ExternalReference> references) {
		this.references = references;
	}

}

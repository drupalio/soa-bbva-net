package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Loan", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Loan", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Loan extends Product implements Serializable {

	public final static long serialVersionUID = 1L;

	@ApiModelProperty("Entidad con toda la informaci\u00f3n del balance del pr\u00e9stamo")
	@NotNull
	private Balance balance;

	@ApiModelProperty("Entidad que posee toda un resumen de pagos del pr\u00e9stamo")
	@NotNull
	private Payment payment;

	@ApiModelProperty(value = "Estado del prestamo", required = true)
	@NotNull
	private EnumLoanStatus status;

	public Loan() {
		// default constructor
	}

	@Override
	public Balance getBalance() {
		return balance;
	}

	@Override
	public void setBalance(Balance balance) {
		this.balance = balance;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public EnumLoanStatus getStatus() {
		return status;
	}

	public void setStatus(EnumLoanStatus status) {
		this.status = status;
	}

}

package com.bbva.zic.dto.net;

import com.bbva.jee.arq.spring.core.servicing.utils.CalendarAdapter;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import com.wordnik.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Calendar;

@XmlRootElement(name = "RotaryQuotaMove", namespace = "urn:com:bbva:zic:dto:net")
@XmlType(name = "RotaryQuotaMove", namespace = "urn:com:bbva:zic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class RotaryQuotaMove implements Serializable {
	public final static long serialVersionUID = 1L;

	private String id;

	private Operation operation;

	private String concept;

	@XmlJavaTypeAdapter(CalendarAdapter.class)
	@ApiModelProperty(value = " fecha de la transaccion", required = true)
	@Past
	private Calendar transactionDate;

	private String status;

	@XmlElement(type = Money.class)
	@ApiModelProperty("Valor del movimiento.")
	private Money value;

	private Balance deb;

	private Integer numberOfQuotas;

	private Integer remainingQuotas;


	public RotaryQuotaMove() {
		//default constructor
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public Calendar getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Calendar transactionDate) {
		this.transactionDate = transactionDate;
	}


	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Money getValue() {
		return value;
	}

	public void setValue(Money value) {
		this.value = value;
	}

	public Balance getBalance() {
		return deb;
	}

	public void setBalance(Balance deb) {
		this.deb = deb;
	}


	public Integer getNumbersOfQuota() {
		return numberOfQuotas;
	}

	public void setNumbersOfQuota(Integer numberOfQuotas) {
		this.numberOfQuotas = numberOfQuotas;
	}

	public Integer getRemainingQuotas() {
		return remainingQuotas;
	}

	public void setRemainingQuotas(Integer remainingQuotas) {
		this.remainingQuotas = remainingQuotas;
	}
}


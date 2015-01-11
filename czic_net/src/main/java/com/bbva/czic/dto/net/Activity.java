package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.Calendar;

import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.validator.constraints.NotBlank;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Activity", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Activity", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Activity implements Serializable {

	public final static long serialVersionUID = 1L;
	@XmlSchemaType(name = "dateTime")
	@ApiModelProperty(value = "Fecha en que la operación se ejecutó", required = true)
	@NotNull
	@Past
	private Calendar operationDate;
	@XmlSchemaType(name = "dateTime")
	@ApiModelProperty("Fecha en que la operación se efectuó en el banco")
	@NotNull
	@Past
	private Calendar executionDate;
	@ApiModelProperty("Entidad que encapsula la función de la operación")
	@NotNull
	private Function function;
	@ApiModelProperty("Valor de la operación")
	@NotNull
	private Money amount;
	@ApiModelProperty("Valor de la operación")
	@NotBlank
	private String reference;

	public Activity() {
		// default constructor
	}

	public Calendar getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Calendar operationDate) {
		this.operationDate = operationDate;
	}

	public Calendar getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(Calendar executionDate) {
		this.executionDate = executionDate;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public Money getAmount() {
		return amount;
	}

	public void setAmount(Money amount) {
		this.amount = amount;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

}
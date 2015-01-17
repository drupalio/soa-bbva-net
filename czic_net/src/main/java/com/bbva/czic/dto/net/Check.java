package com.bbva.czic.dto.net;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import com.wordnik.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Calendar;

@XmlRootElement(name = "Check", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Check", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Check implements Serializable {

	public final static long serialVersionUID = 1L;
	@ApiModelProperty(value = "Identificador del cheque", required = true)
	@NotBlank
	private String id;
	@XmlSchemaType(name = "dateTime")
	@ApiModelProperty(value = "description", required = true)
	@NotNull
	@Past
	private Calendar issueDate;
	@XmlElement(type = Money.class)
	@ApiModelProperty(value = "Valor del cheque", required = true)
	@NotNull
	private Money value;
	@ApiModelProperty(value = "Estado actual del cheque", required = true)
	@NotNull
	private EnumCheckStatus status;
	@XmlSchemaType(name = "dateTime")
	@ApiModelProperty(value = "Fecha de modificacion", required = true)
	@NotNull
	@Past
	private Calendar modifiedDate;

	public Check() {
		// default constructor
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Calendar getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Calendar issueDate) {
		this.issueDate = issueDate;
	}

	public Money getValue() {
		return value;
	}

	public void setValue(Money value) {
		this.value = value;
	}

	public EnumCheckStatus getStatus() {
		return status;
	}

	public void setStatus(EnumCheckStatus status) {
		this.status = status;
	}

	public Calendar getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Calendar modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}

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
	private String id;
	@ApiModelProperty(value = "description", required = true)
	private String issueDate;
	@XmlElement(type = Money.class)
	@ApiModelProperty(value = "Valor del cheque", required = true)
	private Money value;
	@ApiModelProperty(value = "Estado actual del cheque", required = true)
	private String status;
	@ApiModelProperty(value = "Fecha de modificacion", required = true)
	private String modifiedDate;

	public Check() {
		// default constructor
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Money getValue() {
		return value;
	}

	public void setValue(Money value) {
		this.value = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}

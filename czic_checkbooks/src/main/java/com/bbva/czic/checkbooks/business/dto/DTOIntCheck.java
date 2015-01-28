package com.bbva.czic.checkbooks.business.dto;

import com.bbva.czic.dto.net.EnumCheckStatus;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class DTOIntCheck {

	public final static long serialVersionUID = 1L;

	@NotNull
	@NotEmpty
	private String id;
	@NotNull
	private Date issueDate;
	@NotNull
	private Money value;
	@NotNull
	@NotEmpty
	private String status;
	@NotNull
	private Date modifiedDate;

	public DTOIntCheck() {
		// default constructor
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
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

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}

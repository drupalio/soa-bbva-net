package com.bbva.czic.checkbooks.business.dto;

import com.bbva.czic.dto.net.EnumCheckStatus;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

import java.util.Date;

public class DTOIntCheck {

	public final static long serialVersionUID = 1L;

	private String id;

	private Date issueDate;

	private Money value;

	private String status;

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

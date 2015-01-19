package com.bbva.czic.accounts.business.dto;

import java.util.Date;

import com.bbva.czic.dto.net.EnumCheckStatus;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

public class DTOIntCheck extends DTOIntFilterAccount {

	public final static long serialVersionUID = 1L;

	private String id;

	private Date issueDate;

	private Money value;

	private EnumCheckStatus status;

	private Date modifiedDate;

	private int paginationKey;

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

	public EnumCheckStatus getStatus() {
		return status;
	}

	public void setStatus(EnumCheckStatus status) {
		this.status = status;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getpaginationKey() {
		return paginationKey;
	}

}

package com.bbva.zic.accounts.business.dto;

import org.hibernate.validator.constraints.Length;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class DTOIntCheckbook {

	public final static long serialVersionUID = 1L;

	private String id;

	private String firstCheck;

	private String lastCheck;

	private Integer totalCheck;

	private Date requestDate;

	private Date deliveryDate;

	private String actualState;

	public DTOIntCheckbook() {
		// default constructor
	}

	public DTOIntCheckbook(String id) {
		this.id = id;
	}

	public String getFirstCheck() {
		return firstCheck;
	}

	public void setFirstCheck(String firstCheck) {
		this.firstCheck = firstCheck;
	}

	public String getLastCheck() {
		return lastCheck;
	}

	public void setLastCheck(String lastCheck) {
		this.lastCheck = lastCheck;
	}

	public Integer getTotalCheck() {
		return totalCheck;
	}

	public void setTotalCheck(Integer totalCheck) {
		this.totalCheck = totalCheck;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getActualState() {
		return actualState;
	}

	public void setActualState(String actualState) {
		this.actualState = actualState;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}

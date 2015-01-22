package com.bbva.czic.accounts.business.dto;

import java.util.Date;

public class DTOIntCheckbook {

	public final static long serialVersionUID = 1L;

	private String id;

	private Integer firstCheck;

	private Integer lastCheck;

	private Integer totalCheck;

	private Date requestDate;

	private Date deliveryDate;

	private DTOIntEnumCheckbookStatus actualState;

	private String numeroCuenta;

	public DTOIntCheckbook() {
		// default constructor
	}

	public DTOIntCheckbook(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getFirstCheck() {
		return firstCheck;
	}

	public void setFirstCheck(Integer firstCheck) {
		this.firstCheck = firstCheck;
	}

	public Integer getLastCheck() {
		return lastCheck;
	}

	public void setLastCheck(Integer lastCheck) {
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

	public DTOIntEnumCheckbookStatus getActualState() {
		return actualState;
	}

	public void setActualState(DTOIntEnumCheckbookStatus actualState) {
		this.actualState = actualState;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
}

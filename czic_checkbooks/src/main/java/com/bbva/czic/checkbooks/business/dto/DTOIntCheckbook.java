package com.bbva.czic.checkbooks.business.dto;

import java.util.Date;
import java.util.List;

public class DTOIntCheckbook {

	public final static long serialVersionUID = 1L;

	private String id;

	private Integer firstCheck;

	private Integer lastCheckl;

	private Integer totalCheck;

	private Date requestDate;

	private Date deliveryDate;

	private DTOIntEnumCheckbookStatus actualState;

	private List<DTOIntCheck> checks;

	public DTOIntCheckbook() {
		// default constructor
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

	public Integer getLastCheckl() {
		return lastCheckl;
	}

	public void setLastCheckl(Integer lastCheckl) {
		this.lastCheckl = lastCheckl;
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

	public List<DTOIntCheck> getChecks() {
		return checks;
	}

	public void setChecks(List<DTOIntCheck> checks) {
		this.checks = checks;
	}

}

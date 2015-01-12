package com.bbva.czic.checkbooks.business.dto;

import com.bbva.czic.dto.net.EnumCheckbookStatus;

import java.util.Date;
import java.util.List;

public class DTOIntCheckbook {

	public final static long serialVersionUID = 1L;

	private String id;

	private Integer firstCheck;

	private Integer lastCheck;

	private Integer totalCheck;

	private Date requestDate;

	private Date deliveryDate;

	private EnumCheckbookStatus actualState;

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

	public EnumCheckbookStatus getActualState() {
		return actualState;
	}

	public void setActualState(EnumCheckbookStatus actualState) {
		this.actualState = actualState;
	}

	public List<DTOIntCheck> getChecks() {
		return checks;
	}

	public void setChecks(List<DTOIntCheck> checks) {
		this.checks = checks;
	}

}

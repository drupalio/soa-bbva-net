package com.bbva.zic.loan.business.dto;

import com.bbva.zic.dto.net.EnumRotaryMoveStatus;

public class DTOIntRotaryQuotaMovement {

	public final static long serialVersionUID = 1L;

	private Integer remainingQuotas;

	private Integer totalQuotal;

	private EnumRotaryMoveStatus status;

	public DTOIntRotaryQuotaMovement() {
		// default constructor
	}

	public Integer getRemainingQuotas() {
		return remainingQuotas;
	}

	public void setRemainingQuotas(Integer remainingQuotas) {
		this.remainingQuotas = remainingQuotas;
	}

	public Integer getTotalQuotal() {
		return totalQuotal;
	}

	public void setTotalQuotal(Integer totalQuotal) {
		this.totalQuotal = totalQuotal;
	}

	public EnumRotaryMoveStatus getStatus() {
		return status;
	}

	public void setStatus(EnumRotaryMoveStatus status) {
		this.status = status;
	}

}

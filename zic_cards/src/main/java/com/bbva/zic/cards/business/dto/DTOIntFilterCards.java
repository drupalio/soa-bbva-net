package com.bbva.zic.cards.business.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class DTOIntFilterCards {

	@NotNull
	@Length(max = 16, min = 16)
	private String productId;
	@NotNull
	private String startDate;
	private String endDate;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}

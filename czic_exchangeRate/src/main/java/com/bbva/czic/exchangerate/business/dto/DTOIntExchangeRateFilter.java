package com.bbva.czic.exchangerate.business.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class DTOIntExchangeRateFilter {

	@NotNull
	private String currencyId;

	@NotNull
	private String customerId;

	private BigDecimal purchaseAmount;

	private BigDecimal saleAmount;

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public BigDecimal getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(BigDecimal purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public BigDecimal getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(BigDecimal saleAmount) {
		this.saleAmount = saleAmount;
	}

}

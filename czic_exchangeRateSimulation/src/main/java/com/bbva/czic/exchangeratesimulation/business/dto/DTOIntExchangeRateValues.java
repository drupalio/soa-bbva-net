package com.bbva.czic.exchangeratesimulation.business.dto;

public class DTOIntExchangeRateValues {

	public final static long serialVersionUID = 1L;

	private DTOIntMoney purchaseValue;

	private DTOIntMoney saleValue;

	public DTOIntExchangeRateValues() {
		// default constructor
	}

	public DTOIntMoney getPurchaseValue() {
		return purchaseValue;
	}

	public void setPurchaseValue(DTOIntMoney purchaseValue) {
		this.purchaseValue = purchaseValue;
	}

	public DTOIntMoney getSaleValue() {
		return saleValue;
	}

	public void setSaleValue(DTOIntMoney saleValue) {
		this.saleValue = saleValue;
	}

}

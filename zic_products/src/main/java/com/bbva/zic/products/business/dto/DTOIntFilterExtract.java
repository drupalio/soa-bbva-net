package com.bbva.zic.products.business.dto;

import javax.validation.constraints.NotNull;

public class DTOIntFilterExtract {

	@NotNull
	private String productId;
	private String extractId;
	private String month;
	private String year;
	
	
	
	@Override
	public String toString() {
		return "DTOIntFilterExtract [productId=" + productId + ", extractId="
				+ extractId + ", month=" + month + ", year=" + year + "]";
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getExtractId() {
		return extractId;
	}
	public void setExtractId(String extractId) {
		this.extractId = extractId;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
}

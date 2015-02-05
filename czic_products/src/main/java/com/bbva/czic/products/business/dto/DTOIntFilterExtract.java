package com.bbva.czic.products.business.dto;

import javax.validation.constraints.NotNull;

public class DTOIntFilterExtract {

	@NotNull
	private String productId;
	private String extractId;
	private String startMonth;
	private String endMonth;
	private String startYear;
	private String endYear;
	@NotNull
	private Integer paginationKey;
	@NotNull
	private Integer pageSize;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}

	public String getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getEndYear() {
		return endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}

	public Integer getPaginationKey() {
		return paginationKey;
	}

	public void setPaginationKey(Integer paginationKey) {
		this.paginationKey = paginationKey;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getExtractId() {
		return extractId;
	}

	public void setExtractId(String extractId) {
		this.extractId = extractId;
	}

}

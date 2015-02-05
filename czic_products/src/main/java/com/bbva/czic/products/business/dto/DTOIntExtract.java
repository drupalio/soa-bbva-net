package com.bbva.czic.products.business.dto;

import javax.validation.constraints.NotNull;

public class DTOIntExtract {

	@NotNull
	private String month;
	@NotNull
	private String year;
	private String extCode;
	@NotNull
	private String url;
	private String generationDate;

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

	public String getExtCode() {
		return extCode;
	}

	public void setExtCode(String codigoExterno) {
		this.extCode = codigoExterno;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getGenerationDate() {
		return generationDate;
	}

	public void setGenerationDate(String generationDate) {
		this.generationDate = generationDate;
	}
}

package com.bbva.czic.products.business.dto;

import java.util.Calendar;

import javax.validation.constraints.NotNull;

public class DTOIntExtract {
	
	@NotNull
	private String month;
	@NotNull
	private String year;
	@NotNull
	String url;
	private Calendar generationDate;
	
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Calendar getGenerationDate() {
		return generationDate;
	}
	public void setGenerationDate(Calendar generationDate) {
		this.generationDate = generationDate;
	}

}

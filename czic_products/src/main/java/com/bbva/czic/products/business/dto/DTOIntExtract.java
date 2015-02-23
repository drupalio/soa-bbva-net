package com.bbva.czic.products.business.dto;

import javax.validation.constraints.NotNull;

public class DTOIntExtract {

	@NotNull
	private String month;
	@NotNull
	private String year;
	//Supuesto identificador del extracto
	private String extCode;
	//Codigo auxiliar desconocido
	private String auxCode;
	@NotNull
	private String url;
	private String generationDate;

	
	
	@Override
	public String toString() {
		return "DTOIntExtract [month=" + month + ", year=" + year
				+ ", extCode=" + extCode + ", auxCode=" + auxCode + ", url="
				+ url + ", generationDate=" + generationDate + "]";
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

	public String getAuxCode() {
		return auxCode;
	}

	public void setAuxCode(String auxCode) {
		this.auxCode = auxCode;
	}
	
}

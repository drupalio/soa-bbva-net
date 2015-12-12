package com.bbva.czic.exchangerate.business.dto;

public class DTOIntCurrency {

	public final static long serialVersionUID = 1L;

	private String id;

	private String code;

	private String name;

	public DTOIntCurrency() {
		// default constructor
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

package com.bbva.zic.customers.business.dto;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.bbva.zic.dto.net.EnumDocumentType;

public class DTOIntDocument {
	
	@Pattern(regexp = "[0-9]")
	private String number;
	@NotEmpty
	private String type;
	
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}

package com.bbva.zic.customers.business.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;




/**
 * @author Entelgy Colombia.
 */
public class DTOIntCustomerFilter {

	@NotNull
	private DTOIntDocument document;
	@NotEmpty
    private String username;
    @NotEmpty
    private String concat;
    
	public String getConcat() {
		return concat;
	}
	public void setConcat(String concat) {
		this.concat = concat;
	}
	public DTOIntDocument getDocument() {
		return document;
	}
	public void setDocument(DTOIntDocument document) {
		this.document = document;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}

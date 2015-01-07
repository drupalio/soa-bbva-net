package com.bbva.czic.executives.business.dto;

import com.bbva.czic.dto.net.Office;

public class DTOIntExecutive {

	public final static long serialVersionUID = 1L;
	private String executiveId;
	private String name;
	private String phone;
	private Office office;
	private String email;

	public DTOIntExecutive() {
		// default constructor
	}

	public String getExecutiveId() {
		return executiveId;
	}

	public void setExecutiveId(String executiveId) {
		this.executiveId = executiveId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

package com.bbva.czic.executives.business.dto;

import com.bbva.czic.dto.net.Office;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class DTOIntExecutive {

	public final static long serialVersionUID = 1L;
	@NotNull
	@NotEmpty
	private String executiveId;
	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	@NotEmpty
	private String phone;
	private DTOIntOffice office;
	@NotNull
	@NotEmpty
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public DTOIntOffice getOffice() {
		return office;
	}

	public void setOffice(DTOIntOffice office) {
		this.office = office;
	}
}

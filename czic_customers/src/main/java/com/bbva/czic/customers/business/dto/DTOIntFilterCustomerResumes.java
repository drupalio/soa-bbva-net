package com.bbva.czic.customers.business.dto;

import java.util.Date;

/**
 *  Filtro para la consulta de los resumenes de un clienta
 * @author Sebastian Gamba - Entelgy Col. 
 * @since 11/01/2015
 */
public class DTOIntFilterCustomerResumes {

	private String customerId;
	private Date startDate;
	private Date endDate;
	
	public DTOIntFilterCustomerResumes(){
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "DTOIntFilterCustomerResumes{" +
				"customerId='" + customerId + '\'' +
				", startDate=" + startDate +
				", endDate=" + endDate +
				'}';
	}
}

package com.bbva.czic.customers.business.dto;

import com.bbva.czic.routine.commons.rm.utils.validator.IsCustomerId;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 *  Filtro para la consulta de los resumenes de un clienta
 * @author Sebastian Gamba - Entelgy Col. 
 * @since 11/01/2015
 */
public class DTOIntAccMovementsResumesFilter {

	@NotNull
	@IsCustomerId
	private String customerId;
	private String startDate;
	private String endDate;
	
	public DTOIntAccMovementsResumesFilter(){
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
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

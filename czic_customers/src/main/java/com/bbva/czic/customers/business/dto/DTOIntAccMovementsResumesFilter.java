package com.bbva.czic.customers.business.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.Length;

/**
 * Filtro para la consulta de los resumenes de un clienta
 * 
 * @author Sebastian Gamba - Entelgy Col.
 * @since 11/01/2015
 */
public class DTOIntAccMovementsResumesFilter {

	private String startDate;

	private String endDate;

	public DTOIntAccMovementsResumesFilter() {
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
		return "DTOIntFilterCustomerResumes{startDate=" + startDate
				+ ", endDate=" + endDate + '}';
	}
}

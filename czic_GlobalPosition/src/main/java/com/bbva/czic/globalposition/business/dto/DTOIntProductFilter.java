package com.bbva.czic.globalposition.business.dto;

import com.bbva.czic.routine.commons.rm.utils.validator.IsCustomerId;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**
 * @author Entelgy Colombia.
 */
public class DTOIntProductFilter {

	@NotEmpty
	@IsCustomerId
	private String idCustomer;

	@Length(min = 2, max = 2)
	private String productType;

	public String getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}
}

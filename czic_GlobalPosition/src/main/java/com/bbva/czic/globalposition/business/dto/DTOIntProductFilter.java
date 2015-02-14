package com.bbva.czic.globalposition.business.dto;

import com.bbva.czic.routine.commons.rm.utils.validator.IsCustomerId;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**
 * @author Entelgy Colombia.
 */
public class DTOIntProductFilter {
	@Pattern(regexp = "^[A-Z]{2}$")
	private String productType;

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}
}

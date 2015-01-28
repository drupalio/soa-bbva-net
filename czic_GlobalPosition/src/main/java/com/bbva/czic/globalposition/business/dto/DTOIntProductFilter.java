package com.bbva.czic.globalposition.business.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Entelgy Colombia.
 */
public class DTOIntProductFilter {

	@NotEmpty
	@Length(min = 8, max = 8)
	private String idCustomer;

	// @Length(min = 2, max = 2)
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

package com.bbva.czic.products.business;

import com.bbva.czic.products.business.dto.DTOIntConditions;



public interface ISrvIntProducts {
	public DTOIntConditions getConditions(String productId);


}
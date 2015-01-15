package com.bbva.czic.products.business;

import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntProduct;


public interface ISrvIntProducts {
	public DTOIntConditions getConditions(DTOIntProduct productId);


}
package com.bbva.czic.products.dao;

import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntProduct;

public interface IProductsDAO {

	DTOIntConditions getConditions(DTOIntProduct productId);
	
}


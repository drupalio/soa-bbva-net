package com.bbva.czic.products.dao;

import com.bbva.czic.products.business.dto.DTOIntConditions;

public interface ProductsDAO {

	DTOIntConditions getConditions(DTOIntConditions dtoIntConditions);
	
}


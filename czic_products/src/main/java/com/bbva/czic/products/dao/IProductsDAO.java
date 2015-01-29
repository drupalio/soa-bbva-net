package com.bbva.czic.products.dao;

import java.util.List;

import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntExtract;
import com.bbva.czic.products.business.dto.DTOIntProduct;

public interface IProductsDAO {

	DTOIntConditions getConditions(DTOIntProduct productId);

	List<DTOIntExtract> listExtracts(DTOIntExtract dtoIntFilterExtract);
	
}


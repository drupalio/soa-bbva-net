package com.bbva.czic.products.dao;

import java.util.List;

import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntExtractOutput;
import com.bbva.czic.products.business.dto.DTOIntFilterExtract;
import com.bbva.czic.products.business.dto.DTOIntFilterMovements;
import com.bbva.czic.products.business.dto.DTOIntMovement;
import com.bbva.czic.products.business.dto.DTOIntProduct;

public interface IProductsDAO {

	DTOIntConditions getConditions(DTOIntProduct productId);

	DTOIntExtractOutput listExtracts(DTOIntFilterExtract dtoIntFilterExtract);

	public DTOIntMovement getMovement(DTOIntFilterMovements dtoIntFilterMovements);
	public List<DTOIntMovement> listMovements(DTOIntFilterMovements dtoIntFilterMovements) ;
}


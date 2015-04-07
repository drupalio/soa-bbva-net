package com.bbva.zic.products.dao;

import java.util.List;

import com.bbva.zic.products.business.dto.DTOIntConditions;
import com.bbva.zic.products.business.dto.DTOIntExtractOutput;
import com.bbva.zic.products.business.dto.DTOIntFilterExtract;
import com.bbva.zic.products.business.dto.DTOIntFilterMovements;
import com.bbva.zic.products.business.dto.DTOIntMovement;
import com.bbva.zic.products.business.dto.DTOIntProduct;

public interface IProductsDAO {

	DTOIntConditions getConditions(DTOIntProduct productId);

	DTOIntExtractOutput listExtracts(DTOIntFilterExtract dtoIntFilterExtract);

	public DTOIntMovement getMovement(DTOIntFilterMovements dtoIntFilterMovements);
	public List<DTOIntMovement> listMovements(DTOIntFilterMovements dtoIntFilterMovements) ;
}


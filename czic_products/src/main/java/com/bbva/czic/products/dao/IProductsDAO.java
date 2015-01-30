package com.bbva.czic.products.dao;

import java.util.List;

import com.bbva.czic.products.business.dto.*;

public interface IProductsDAO {

	DTOIntConditions getConditions(DTOIntProduct productId);

	List<DTOIntExtract> listExtracts(DTOIntFilterExtract dtoIntFilterExtract);

	public DTOIntMovement getMovement(DTOIntFilterMovements dtoIntFilterMovements);
	public List<DTOIntMovement> listMovements(DTOIntFilterMovements dtoIntFilterMovements) ;
}


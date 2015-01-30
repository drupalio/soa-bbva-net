package com.bbva.czic.products.business;

import com.bbva.czic.products.business.dto.*;

import java.util.List;


public interface ISrvIntProducts {
	public DTOIntConditions getConditions(DTOIntProduct productId);

	public DTOIntExtract listExtracts(DTOIntExtract dtoIntFilterExtract);


	public DTOIntMovement getMovement(DTOIntFilterMovements dtoIntMovementsFilter);

	public List<DTOIntMovement> listMovements(DTOIntFilterMovements filter);

}
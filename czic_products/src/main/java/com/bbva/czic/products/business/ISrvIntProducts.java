package com.bbva.czic.products.business;

import java.util.List;

import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntExtract;
import com.bbva.czic.products.business.dto.DTOIntFilterExtract;
import com.bbva.czic.products.business.dto.DTOIntFilterMovements;
import com.bbva.czic.products.business.dto.DTOIntMovement;
import com.bbva.czic.products.business.dto.DTOIntProduct;

public interface ISrvIntProducts {
	public DTOIntConditions getConditions(DTOIntProduct productId);

	public List<DTOIntExtract> listExtracts(DTOIntFilterExtract dtoIntFilterExtract);


	public DTOIntMovement getMovement(DTOIntFilterMovements dtoIntMovementsFilter);

	public List<DTOIntMovement> listMovements(DTOIntFilterMovements filter);

}
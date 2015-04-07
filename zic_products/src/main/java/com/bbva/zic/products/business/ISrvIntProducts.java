package com.bbva.zic.products.business;

import java.util.List;

import com.bbva.zic.products.business.dto.DTOIntConditions;
import com.bbva.zic.products.business.dto.DTOIntExtract;
import com.bbva.zic.products.business.dto.DTOIntFilterExtract;
import com.bbva.zic.products.business.dto.DTOIntFilterMovements;
import com.bbva.zic.products.business.dto.DTOIntMovement;
import com.bbva.zic.products.business.dto.DTOIntProduct;

public interface ISrvIntProducts {
	public DTOIntConditions getConditions(DTOIntProduct productId);

	public List<DTOIntExtract> listExtracts(DTOIntFilterExtract dtoIntFilterExtract);


	public DTOIntMovement getMovement(DTOIntFilterMovements dtoIntMovementsFilter);

	public List<DTOIntMovement> listMovements(DTOIntFilterMovements filter);

}
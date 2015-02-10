package com.bbva.czic.products.facade.v01.mapper;

import java.util.List;

import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.dto.net.Extract;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntExtract;
import com.bbva.czic.products.business.dto.DTOIntFilterExtract;
import com.bbva.czic.products.business.dto.DTOIntFilterMovements;
import com.bbva.czic.products.business.dto.DTOIntMovement;
import com.bbva.czic.products.business.dto.DTOIntProduct;

public interface IProductsMapper {

	Conditions map(DTOIntConditions intConditions);

	DTOIntProduct getDtoIntConditions(String productId);

	DTOIntFilterExtract getDtoIntFilterExtract(String productId, String filter,
			String extractId);

	List<Extract> mapExtracts(List<DTOIntExtract> list);

	public DTOIntFilterMovements getDTOIntFilterGetMovement(String productId,String movementId, String filter);

	public Movement mapMovement(DTOIntMovement dtoIntMovement);

	public List<Movement> mapMovements(List<DTOIntMovement> listaDTOIntMovements);

	public DTOIntFilterMovements getDTOIntFilterGetListMovements(String productId,String filter,Integer paginationKey,  Integer pageSize);
}
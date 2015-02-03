package com.bbva.czic.products.facade.v01.mapper;

import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.dto.net.Extract;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.products.business.dto.*;

import java.util.List;

public interface IProductsMapper {

	Conditions map(DTOIntConditions intConditions);

	DTOIntProduct getDtoIntConditions(String productId);

//	DTOIntExtract getDtoIntFilterExtract(String productId, String filter,
//										 Integer paginationKey, Integer pageSize);
	DTOIntFilterExtract getDtoIntFilterExtract(String productId, String filter,
			Integer paginationKey, Integer pageSize);

	List<Extract> mapExtracts(List<DTOIntExtract> list);

	public DTOIntFilterMovements getDTOIntFilterGetMovement(String productId,String movementId, String filter);

	public Movement mapMovement(DTOIntMovement dtoIntMovement);

	public List<Movement> mapMovements(List<DTOIntMovement> listaDTOIntMovements);

	public DTOIntFilterMovements getDTOIntFilterGetListMovements(String productId,String filter,Integer paginationKey,  Integer pageSize);
}
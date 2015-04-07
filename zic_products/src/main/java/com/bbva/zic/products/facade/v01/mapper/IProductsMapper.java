package com.bbva.zic.products.facade.v01.mapper;

import java.util.List;

import com.bbva.zic.dto.net.AccMoveDetail;
import com.bbva.zic.dto.net.Conditions;
import com.bbva.zic.dto.net.Extract;
import com.bbva.zic.dto.net.Movement;
import com.bbva.zic.products.business.dto.DTOIntConditions;
import com.bbva.zic.products.business.dto.DTOIntExtract;
import com.bbva.zic.products.business.dto.DTOIntFilterExtract;
import com.bbva.zic.products.business.dto.DTOIntFilterMovements;
import com.bbva.zic.products.business.dto.DTOIntMovement;
import com.bbva.zic.products.business.dto.DTOIntProduct;

public interface IProductsMapper {

	Conditions map(DTOIntConditions intConditions);

	DTOIntProduct getDtoIntConditions(String productId);

	DTOIntFilterExtract getDtoIntFilterExtract(String productId, String filter);

	List<Extract> mapExtracts(List<DTOIntExtract> list);

	public DTOIntFilterMovements getDTOIntFilterGetMovement(String productId,String movementId, String filter);

	public AccMoveDetail mapMovement(DTOIntMovement dtoIntMovement);

	public List<Movement> mapMovements(List<DTOIntMovement> listaDTOIntMovements);

	public DTOIntFilterMovements getDTOIntFilterGetListMovements(String productId,String filter,Integer paginationKey,  Integer pageSize);
}
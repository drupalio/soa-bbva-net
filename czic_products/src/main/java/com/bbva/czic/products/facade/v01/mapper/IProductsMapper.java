package com.bbva.czic.products.facade.v01.mapper;

import com.bbva.czic.dto.net.*;
import com.bbva.czic.products.business.dto.*;

import java.util.List;

public interface IProductsMapper {

	Conditions map(DTOIntConditions intConditions);

	DTOIntProduct getDtoIntConditions(String productId);

	DTOIntExtract getDtoIntFilterExtract(String productId, String filter,
			Integer paginationKey, Integer pageSize);

	List<Extract> mapExtracts(List<DTOIntExtract> list);

}
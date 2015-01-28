package com.bbva.czic.products.dao.mapper;

import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntProduct;
import com.bbva.czic.products.dao.model.oznt.FormatoOZECNTE0;
import com.bbva.czic.products.dao.model.oznt.FormatoOZECNTS0;


public interface TxProductMapper {
	
	FormatoOZECNTE0 mapInOznt(DTOIntProduct dtoIn);

	DTOIntConditions mapOutOznt(FormatoOZECNTS0 formatOutput);

}

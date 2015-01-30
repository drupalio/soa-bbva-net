package com.bbva.czic.products.dao.mapper;

import com.bbva.czic.products.business.dto.DTOIntExtract;
import com.bbva.czic.products.business.dto.DTOIntFilterExtract;
import com.bbva.czic.products.dao.model.ozn2.FormatoOZECN2E0;
import com.bbva.czic.products.dao.model.ozn2.FormatoOZECN2S0;

public interface TxExtractMapper {

	FormatoOZECN2E0 mapInOznt(DTOIntFilterExtract dtoIn);

	DTOIntExtract mapOutOznt(FormatoOZECN2S0 formatOutput);
	
}

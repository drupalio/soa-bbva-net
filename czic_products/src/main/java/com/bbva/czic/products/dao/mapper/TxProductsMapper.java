package com.bbva.czic.products.dao.mapper;

import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntExtract;
import com.bbva.czic.products.business.dto.DTOIntFilterExtract;
import com.bbva.czic.products.business.dto.DTOIntProduct;
import com.bbva.czic.products.dao.model.ozn2.FormatoOZECN2E0;
import com.bbva.czic.products.dao.model.ozn2.FormatoOZECN2S0;
import com.bbva.czic.products.dao.model.oznt.FormatoOZECNTE0;
import com.bbva.czic.products.dao.model.oznt.FormatoOZECNTS0;

public interface TxProductsMapper {

	public static final String headGet = "";
	
	public static final String tailGet = "";

	public static final String headList = "<indraExtXStreamParser><operation>5</operation><solicitarExtractosXCodigoXStreamParser><stringOrigen>1</stringOrigen><listaExtSolVO>";

	public static final String tailList = "</listaExtSolVO></solicitarExtractosXCodigoXStreamParser></indraExtXStreamParser>";

	FormatoOZECNTE0 mapInOznt(DTOIntProduct dtoIn);

	DTOIntConditions mapOutOznt(FormatoOZECNTS0 formatOutput);

	FormatoOZECN2E0 mapInOznt(DTOIntFilterExtract dtoIn);

	DTOIntExtract mapOutOznt(FormatoOZECN2S0 formatOutput);

}

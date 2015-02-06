package com.bbva.czic.products.dao.mapper;

import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntExtractOutput;
import com.bbva.czic.products.business.dto.DTOIntFilterExtract;
import com.bbva.czic.products.business.dto.DTOIntFilterMovements;
import com.bbva.czic.products.business.dto.DTOIntMovement;
import com.bbva.czic.products.business.dto.DTOIntProduct;
import com.bbva.czic.products.dao.model.ozn2.FormatoOZECN2E0;
import com.bbva.czic.products.dao.model.ozn2.FormatoOZECN2S0;
import com.bbva.czic.products.dao.model.oznl.FormatoOZECNLE0;
import com.bbva.czic.products.dao.model.oznl.FormatoOZECNLS0;
import com.bbva.czic.products.dao.model.oznm.FormatoOZNCENM0;
import com.bbva.czic.products.dao.model.oznm.FormatoOZNCSNM0;
import com.bbva.czic.products.dao.model.oznt.FormatoOZECNTE0;
import com.bbva.czic.products.dao.model.oznt.FormatoOZECNTS0;

public interface TxProductsMapper {

	public static final int PLOT_LENGTH=99;
	
	public static final String headGet = "<indraExtXStreamParser><operation>4</operation><getExtractosDisponiblesXNoContratoXStreamParser><extRefpro>";
	
	public static final String tailGet = "</extRefpro></getExtractosDisponiblesXNoContratoXStreamParser></indraExtXStreamParser>";

	public static final String headGenerate = "<indraExtXStreamParser><operation>5</operation><solicitarExtractosXCodigoXStreamParser><stringOrigen>1</stringOrigen><listaExtSolVO>";

	public static final String tailGenerate = "</listaExtSolVO></solicitarExtractosXCodigoXStreamParser></indraExtXStreamParser>";

	public static final String IDPRODUCT="<stringRefPro>$</stringRefPro>";
	
	public static final String MONTH="<stringMes>$</stringMes>";
	
	public static final String YEAR="<stringAnio>$</stringAnio>";
	
	public static final String EXTERNAL_CODE="<stringCodigoExt>$</stringCodigoExt>";
	
	public static final String REQUEST_EXTRACT="<ExtractoSolicitadoVO>$</ExtractoSolicitadoVO>";
	
	public static final String WORD="http";
	
	public FormatoOZECNTE0 mapInOznt(DTOIntProduct dtoIn);

	public DTOIntConditions mapOutOznt(FormatoOZECNTS0 formatOutput);

	public FormatoOZECN2E0 mapInOzn2(DTOIntFilterExtract dtoIn);

	public DTOIntExtractOutput mapOutOzn2(FormatoOZECN2S0 formatOutput);

	public FormatoOZNCENM0 mapInOznm(DTOIntFilterMovements dtoIn) ;

	public DTOIntMovement mapOutOznm(FormatoOZNCSNM0 formatOutput) ;

	public FormatoOZECNLE0 mapInOznl(DTOIntFilterMovements dtoIn);

	public DTOIntMovement mapOutOznl(FormatoOZECNLS0 formatOutput);

}

package com.bbva.czic.products.dao.mapper;

import com.bbva.czic.products.business.dto.*;
import com.bbva.czic.products.dao.model.ozn2.FormatoOZECN2E0;
import com.bbva.czic.products.dao.model.ozn2.FormatoOZECN2S0;
import com.bbva.czic.products.dao.model.oznl.FormatoOZECNLE0;
import com.bbva.czic.products.dao.model.oznl.FormatoOZECNLS0;
import com.bbva.czic.products.dao.model.oznm.FormatoOZNCENM0;
import com.bbva.czic.products.dao.model.oznm.FormatoOZNCSNM0;
import com.bbva.czic.products.dao.model.oznt.FormatoOZECNTE0;
import com.bbva.czic.products.dao.model.oznt.FormatoOZECNTS0;


public interface TxProductsMapper {
	
	FormatoOZECNTE0 mapInOznt(DTOIntProduct dtoIn);

	DTOIntConditions mapOutOznt(FormatoOZECNTS0 formatOutput);
	
	FormatoOZECN2E0 mapInOznt(DTOIntFilterExtract dtoIn);

	DTOIntExtract mapOutOznt(FormatoOZECN2S0 formatOutput);

	public FormatoOZNCENM0 mapInOznm(DTOIntFilterMovements dtoIn) ;

	public DTOIntMovement mapOutOznm(FormatoOZNCSNM0 formatOutput) ;

	public FormatoOZECNLE0 mapInOznl(DTOIntFilterMovements dtoIn);

	public DTOIntMovement mapOutOznl(FormatoOZECNLS0 formatOutput);

}

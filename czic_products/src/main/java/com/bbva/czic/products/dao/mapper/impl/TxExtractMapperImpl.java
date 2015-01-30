package com.bbva.czic.products.dao.mapper.impl;

import com.bbva.czic.products.business.dto.DTOIntExtract;
import com.bbva.czic.products.business.dto.DTOIntFilterExtract;
import com.bbva.czic.products.dao.mapper.TxExtractMapper;
import com.bbva.czic.products.dao.model.ozn2.FormatoOZECN2E0;
import com.bbva.czic.products.dao.model.ozn2.FormatoOZECN2S0;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaTxConfigurableMapper;
import com.bbva.czic.routine.commons.rm.utils.mappers.Mapper;

@Mapper(value = "txExtractMapper")
public class TxExtractMapperImpl extends AbstractBbvaTxConfigurableMapper  implements TxExtractMapper{

	@Override
	public FormatoOZECN2E0 mapInOznt(DTOIntFilterExtract dtoIn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DTOIntExtract mapOutOznt(FormatoOZECN2S0 formatOutput) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.bbva.czic.products.dao.tx;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bbva.czic.products.business.dto.DTOIntExtract;
import com.bbva.czic.products.business.dto.DTOIntFilterExtract;
import com.bbva.czic.products.dao.mapper.TxProductsMapper;
import com.bbva.czic.products.dao.model.ozn2.FormatoOZECN2E0;
import com.bbva.czic.products.dao.model.ozn2.FormatoOZECN2S0;
import com.bbva.czic.products.dao.model.ozn2.PeticionTransaccionOzn2;
import com.bbva.czic.products.dao.model.ozn2.RespuestaTransaccionOzn2;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.MultiBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

@Component("tx-list-extracts")
public class TxListExtracts
		extends
		MultiBbvaTransaction<DTOIntFilterExtract, FormatoOZECN2E0, DTOIntExtract, FormatoOZECN2S0> {
	
	@Resource(name = "transaccionOzn2")
	private transient InvocadorTransaccion<PeticionTransaccionOzn2,RespuestaTransaccionOzn2> transaccionOzn2;

	@Resource(name = "txProductMapper")
	private TxProductsMapper txProductsMapper;

	@Override
	protected FormatoOZECN2E0 mapDtoInToRequestFormat(DTOIntFilterExtract dtoIn) {
		return txProductsMapper.mapInOznt(dtoIn);
	}

	@Override
	protected DTOIntExtract mapResponseFormatToDtoOut(
			FormatoOZECN2S0 formatOutput, DTOIntFilterExtract dtoIn) {
		return txProductsMapper.mapOutOznt(formatOutput);
	}

	@Override
	protected InvocadorTransaccion<?, ?> getTransaction() {
		return transaccionOzn2;
	}
	
	

}

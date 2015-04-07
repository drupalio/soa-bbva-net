package com.bbva.zic.products.dao.tx;

import javax.annotation.Resource;

import com.bbva.zic.products.business.dto.DTOIntExtractOutput;
import com.bbva.zic.products.business.dto.DTOIntFilterExtract;
import com.bbva.zic.products.dao.mapper.TxProductsMapper;
import com.bbva.zic.products.dao.model.ozn2.PeticionTransaccionOzn2;
import com.bbva.zic.products.dao.model.ozn2.RespuestaTransaccionOzn2;
import org.springframework.stereotype.Component;

import com.bbva.zic.products.dao.model.ozn2.FormatoOZECN2E0;
import com.bbva.zic.products.dao.model.ozn2.FormatoOZECN2S0;
import com.bbva.zic.routine.commons.rm.utils.tx.impl.SimpleBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

@Component("tx-list-extracts")
public class TxListExtracts
		extends
		SimpleBbvaTransaction<DTOIntFilterExtract, FormatoOZECN2E0, DTOIntExtractOutput, FormatoOZECN2S0> {
	
	@Resource(name = "transaccionOzn2")
	private transient InvocadorTransaccion<PeticionTransaccionOzn2,RespuestaTransaccionOzn2> transaccionOzn2;

	@Resource(name = "txProductMapper")
	private TxProductsMapper txProductsMapper;

	@Override
	protected FormatoOZECN2E0 mapDtoInToRequestFormat(DTOIntFilterExtract dtoIn) {
		return txProductsMapper.mapInOzn2(dtoIn);
	}

	@Override
	protected DTOIntExtractOutput mapResponseFormatToDtoOut(
			FormatoOZECN2S0 formatOutput, DTOIntFilterExtract dtoIn) {
		return txProductsMapper.mapOutOzn2(formatOutput);
	}

	@Override
	protected InvocadorTransaccion<?, ?> getTransaction() {
		return transaccionOzn2;
	}
	
	

}

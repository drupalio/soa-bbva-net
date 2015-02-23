package com.bbva.czic.products.dao.tx;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntProduct;
import com.bbva.czic.products.dao.mapper.TxProductsMapper;
import com.bbva.czic.products.dao.model.oznt.FormatoOZECNTE0;
import com.bbva.czic.products.dao.model.oznt.FormatoOZECNTS0;
import com.bbva.czic.products.dao.model.oznt.PeticionTransaccionOznt;
import com.bbva.czic.products.dao.model.oznt.RespuestaTransaccionOznt;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Created by Administrador on 05/01/2015.
 */
@Component("tx-get-conditions")
public class TxGetConditions extends SimpleBbvaTransaction<DTOIntProduct, FormatoOZECNTE0, DTOIntConditions, FormatoOZECNTS0> {

	@Resource(name="transaccionOznt")
	private transient InvocadorTransaccion<PeticionTransaccionOznt, RespuestaTransaccionOznt> transaccionOznt;
	
	@Resource(name = "txProductMapper")
	private TxProductsMapper txProductMapper;

	@Override
	protected FormatoOZECNTE0 mapDtoInToRequestFormat(DTOIntProduct dtoIn) {
		return txProductMapper.mapInOznt(dtoIn);
	}

	@Override
	protected DTOIntConditions mapResponseFormatToDtoOut(FormatoOZECNTS0 formatOutput, DTOIntProduct dtoIn) {
		return txProductMapper.mapOutOznt(formatOutput);
	}

	@Override
	protected InvocadorTransaccion<?, ?> getTransaction() {
		return transaccionOznt;
	}

}

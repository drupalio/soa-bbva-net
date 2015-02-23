package com.bbva.czic.globalposition.dao.tx;

import javax.annotation.Resource;

import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProductFilter;
import com.bbva.czic.globalposition.dao.mappers.ITxGlobalPositionMapper;
import com.bbva.czic.globalposition.dao.model.ozn1.*;
import com.bbva.czic.routine.commons.rm.utils.tx.Tx;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.DoubleBbvaTransaction;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.MultiBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * @author Entelgy Colombia.
 */
@Tx("tx-get-extract-global-balance")
public class TxGetExtractGlobalBalance extends
		DoubleBbvaTransaction<DTOIntProductFilter, FormatoOZECN1E0, DTOIntProduct, FormatoOZECN1S1, FormatoOZECN1S0> {

	@Resource(name = "transaccionOzn1")
	private transient InvocadorTransaccion<PeticionTransaccionOzn1, RespuestaTransaccionOzn1> transaccionOzn1;

	@Resource(name = "txGlobalPositionMapper")
	private transient ITxGlobalPositionMapper txGlobalPositionMapper;

	@Override
	protected FormatoOZECN1E0 mapDtoInToRequestFormat(DTOIntProductFilter dtoIn) {
		return txGlobalPositionMapper.mapInOzn1(dtoIn);
	}

	@Override
	protected DTOIntProduct mapResponseFormatToDtoOut(FormatoOZECN1S1 formatOutput, DTOIntProductFilter dtoIn) {
		return txGlobalPositionMapper.mapOutOzn1S1(formatOutput);
	}

	@Override
	protected DTOIntProduct mapResponseFormatToDtoOut2(FormatoOZECN1S0 formatOutput, DTOIntProductFilter dtoIn) {
		return txGlobalPositionMapper.mapOutOzn1S0(formatOutput);
	}

	@Override
	protected InvocadorTransaccion<?, ?> getTransaction() {
		return transaccionOzn1;
	}
}

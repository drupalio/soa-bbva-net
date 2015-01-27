package com.bbva.czic.accounts.dao.tx;

import com.bbva.czic.accounts.business.dto.DTOIntCheck;
import com.bbva.czic.accounts.business.dto.DTOIntFilterChecks;
import com.bbva.czic.accounts.dao.mappers.TxCheckMapper;
import com.bbva.czic.accounts.dao.model.oznx.*;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.MultiBbvaTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

import javax.annotation.Resource;

/**
 * Created by Entelgy on 14/01/2015.
 */
@Component("tx-list-Check-mapperc")
public class TxListChecks extends
		MultiBbvaTransaction<DTOIntFilterChecks, FormatoOZECNXE0, DTOIntCheck, FormatoOZECNXS0> {

	@Resource(name = "transaccionOznx")
	private transient InvocadorTransaccion<PeticionTransaccionOznx,RespuestaTransaccionOznx> transaccionOznx;

	@Resource(name = "txCheckMapper")
	private TxCheckMapper txCheckMapper;

	@Override
	protected FormatoOZECNXE0 mapDtoInToRequestFormat(DTOIntFilterChecks dtoIn) {
		return txCheckMapper.mapInOznx(dtoIn);
	}

	@Override
	protected DTOIntCheck mapResponseFormatToDtoOut(FormatoOZECNXS0 formatOutput, DTOIntFilterChecks dtoIn) {
		return txCheckMapper.mapOutOznx(formatOutput);
	}

	@Override
	protected InvocadorTransaccion<?, ?> getTransaction() {
		return transaccionOznx;
	}

}
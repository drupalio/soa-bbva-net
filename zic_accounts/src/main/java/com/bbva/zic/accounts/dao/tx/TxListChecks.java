package com.bbva.zic.accounts.dao.tx;

import com.bbva.zic.accounts.business.dto.DTOIntCheck;
import com.bbva.zic.accounts.business.dto.DTOIntFilterChecks;
import com.bbva.zic.accounts.dao.mappers.TxCheckMapper;
import com.bbva.zic.routine.commons.rm.utils.tx.impl.MultiBbvaTransaction;
import com.bbva.zic.accounts.dao.model.oznx.FormatoOZECNXE0;
import com.bbva.zic.accounts.dao.model.oznx.FormatoOZECNXS0;
import com.bbva.zic.accounts.dao.model.oznx.PeticionTransaccionOznx;
import com.bbva.zic.accounts.dao.model.oznx.RespuestaTransaccionOznx;
import org.springframework.stereotype.Component;

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
package com.bbva.zic.accounts.dao.tx;

import javax.annotation.Resource;

import com.bbva.zic.accounts.business.dto.DTOIntAccount;
import com.bbva.zic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.zic.accounts.dao.mappers.TxAccountMapper;
import com.bbva.zic.routine.commons.rm.utils.tx.Tx;
import com.bbva.zic.routine.commons.rm.utils.tx.impl.SimpleBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.zic.accounts.dao.model.ozna.FormatoOZNCENA0;
import com.bbva.zic.accounts.dao.model.ozna.FormatoOZNCSNA0;
import com.bbva.zic.accounts.dao.model.ozna.PeticionTransaccionOzna;
import com.bbva.zic.accounts.dao.model.ozna.RespuestaTransaccionOzna;

@Tx("tx-get-account")
public class TxGetAccount extends
		SimpleBbvaTransaction<DTOIntFilterAccount, FormatoOZNCENA0, DTOIntAccount, FormatoOZNCSNA0> {

	@Resource(name = "transaccionOzna")
	private InvocadorTransaccion<PeticionTransaccionOzna, RespuestaTransaccionOzna> transaccionOzna;

	@Resource(name = "txAccountMapper")
	private TxAccountMapper txAccountMapper;

	@Override
	protected FormatoOZNCENA0 mapDtoInToRequestFormat(DTOIntFilterAccount dtoIn) {
		return txAccountMapper.mapInOzna(dtoIn);
	}

	@Override
	protected DTOIntAccount mapResponseFormatToDtoOut(FormatoOZNCSNA0 outFormat, DTOIntFilterAccount dtoIn) {
		return txAccountMapper.mapOutOzna(outFormat);
	}

	@Override
	protected InvocadorTransaccion<?, ?> getTransaction() {
		return transaccionOzna;
	}

}

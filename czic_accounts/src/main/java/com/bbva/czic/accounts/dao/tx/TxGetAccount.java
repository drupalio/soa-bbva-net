package com.bbva.czic.accounts.dao.tx;

import javax.annotation.Resource;

import com.bbva.czic.accounts.business.dto.DTOIntAccount;
import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.czic.accounts.dao.mappers.TxAccountMapper;
import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCENA0;
import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCSNA0;
import com.bbva.czic.accounts.dao.model.ozna.TransaccionOzna;
import com.bbva.czic.routine.commons.rm.utils.tx.Tx;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

@Tx("tx-get-account")
public class TxGetAccount extends
		SimpleBbvaTransaction<DTOIntFilterAccount, FormatoOZNCENA0, DTOIntAccount, FormatoOZNCSNA0> {

	@Resource(name = "transaccionOzna")
	private TransaccionOzna transaccionOzna;

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

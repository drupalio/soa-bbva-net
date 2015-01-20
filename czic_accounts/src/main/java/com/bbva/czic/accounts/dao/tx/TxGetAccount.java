package com.bbva.czic.accounts.dao.tx;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.czic.accounts.business.dto.DTOIntAccount;
import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.czic.accounts.dao.mappers.TxAccountMapper;
import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCENA0;
import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCSNA0;
import com.bbva.czic.accounts.dao.model.ozna.TransaccionOzna;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

@Component("tx-get-account")
public class TxGetAccount extends
		SimpleBbvaTransaction<DTOIntFilterAccount, FormatoOZNCENA0, DTOIntAccount, FormatoOZNCSNA0> {

	@Autowired
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

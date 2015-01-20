package com.bbva.czic.accounts.dao.tx;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.czic.accounts.business.dto.DTOIntMonthlyBalances;
import com.bbva.czic.accounts.dao.mappers.TxAccountMapper;
import com.bbva.czic.accounts.dao.model.oznv.FormatoOZECNVE0;
import com.bbva.czic.accounts.dao.model.oznv.FormatoOZECNVS0;
import com.bbva.czic.accounts.dao.model.oznv.TransaccionOznv;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.ListBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Created by Entelgy on 12/01/2015.
 */
@Component("tx-get-account-monthly-balance")
public class TxGetAccountMonthlyBalance extends
		ListBbvaTransaction<DTOIntFilterAccount, FormatoOZECNVE0, DTOIntMonthlyBalances, FormatoOZECNVS0> {

	@Autowired
	private transient TransaccionOznv transaccionOznv;

	@Resource(name = "txAccountMapper")
	private TxAccountMapper txAccountMapper;

	@Override
	protected FormatoOZECNVE0 mapDtoInToRequestFormat(DTOIntFilterAccount dtoIn) {
		return txAccountMapper.mapInOznv(dtoIn);
	}

	@Override
	protected DTOIntMonthlyBalances mapResponseFormatToDtoOut(FormatoOZECNVS0 formatOutput, DTOIntFilterAccount dtoIn) {
		return txAccountMapper.mapOutOznv(formatOutput);
	}

	@Override
	protected InvocadorTransaccion<?, ?> getTransaction() {
		return transaccionOznv;
	}
}

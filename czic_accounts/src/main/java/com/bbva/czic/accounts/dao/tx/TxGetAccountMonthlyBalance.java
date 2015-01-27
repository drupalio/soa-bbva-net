package com.bbva.czic.accounts.dao.tx;

import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.czic.accounts.business.dto.DTOIntMonthlyBalances;
import com.bbva.czic.accounts.dao.mappers.TxAccountMapper;
import com.bbva.czic.accounts.dao.model.oznv.FormatoOZECNVE0;
import com.bbva.czic.accounts.dao.model.oznv.FormatoOZECNVS0;
import com.bbva.czic.accounts.dao.model.oznv.PeticionTransaccionOznv;
import com.bbva.czic.accounts.dao.model.oznv.RespuestaTransaccionOznv;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.ListBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Entelgy on 12/01/2015.
 */
@Component("tx-get-account-monthly-balance")
public class TxGetAccountMonthlyBalance extends
		ListBbvaTransaction<DTOIntFilterAccount, FormatoOZECNVE0, DTOIntMonthlyBalances, FormatoOZECNVS0> {

	@Resource(name = "transaccionOznv")
	private InvocadorTransaccion<PeticionTransaccionOznv, RespuestaTransaccionOznv> transaccionOznv;

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

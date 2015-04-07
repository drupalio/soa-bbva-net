package com.bbva.zic.accounts.dao.tx;

import javax.annotation.Resource;

import com.bbva.zic.accounts.dao.mappers.TxAccountMapper;
import com.bbva.zic.accounts.dao.model.oznv.FormatoOZECNVE0;
import com.bbva.zic.accounts.dao.model.oznv.FormatoOZECNVS0;
import com.bbva.zic.accounts.dao.model.oznv.PeticionTransaccionOznv;
import com.bbva.zic.accounts.dao.model.oznv.RespuestaTransaccionOznv;
import org.springframework.stereotype.Component;
import com.bbva.zic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.zic.accounts.business.dto.DTOIntMonthlyBalances;
import com.bbva.zic.routine.commons.rm.utils.tx.impl.MultiBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Created by Entelgy on 12/01/2015.
 */
@Component("tx-get-account-monthly-balance")
public class TxGetAccountMonthlyBalance extends
		MultiBbvaTransaction<DTOIntFilterAccount, FormatoOZECNVE0, DTOIntMonthlyBalances, FormatoOZECNVS0> {

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

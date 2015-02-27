package com.bbva.czic.accounts.dao.tx;

import javax.annotation.Resource;

import com.bbva.czic.accounts.business.dto.DTOIntFilterCheckbooks;
import org.springframework.stereotype.Component;

import com.bbva.czic.accounts.business.dto.DTOIntCheckbook;
import com.bbva.czic.accounts.dao.mappers.TxAccountMapper;
import com.bbva.czic.accounts.dao.model.ozns.FormatoOZECNSE0;
import com.bbva.czic.accounts.dao.model.ozns.FormatoOZECNSS0;
import com.bbva.czic.accounts.dao.model.ozns.PeticionTransaccionOzns;
import com.bbva.czic.accounts.dao.model.ozns.RespuestaTransaccionOzns;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.MultiBbvaTransaction;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * @author Entelgy Colombia.
 */
@Component(value = "tx-get-checkbook")
public class TxGetCheckbook extends SimpleBbvaTransaction<DTOIntFilterCheckbooks, FormatoOZECNSE0, DTOIntCheckbook, FormatoOZECNSS0> {

	@Resource(name="transaccionOzns")
	private transient InvocadorTransaccion<PeticionTransaccionOzns, RespuestaTransaccionOzns> transaccionOzns;
	
	@Resource(name = "txAccountMapper")
	private TxAccountMapper txAccountMapper;
	
	@Override
	protected FormatoOZECNSE0 mapDtoInToRequestFormat(DTOIntFilterCheckbooks dtoIn) {
		return txAccountMapper.mapInOzns(dtoIn);
	}

	@Override
	protected DTOIntCheckbook mapResponseFormatToDtoOut(FormatoOZECNSS0 formatOutput, DTOIntFilterCheckbooks dtoIn) {
		DTOIntCheckbook dto = txAccountMapper.mapOutOzns(formatOutput);
		dto.setId(dtoIn.getId());
		return dto;
	}

	@Override
	protected InvocadorTransaccion<?, ?> getTransaction() {
		return transaccionOzns;
	}
}

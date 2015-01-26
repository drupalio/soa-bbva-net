package com.bbva.czic.accounts.dao.tx;

import javax.annotation.Resource;

import com.bbva.czic.accounts.business.dto.DTOIntFilterMovResumes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.czic.accounts.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.czic.accounts.dao.mappers.TxAccountMapper;
import com.bbva.czic.accounts.dao.model.oznu.FormatoOZECNUE0;
import com.bbva.czic.accounts.dao.model.oznu.FormatoOZECNUS0;
import com.bbva.czic.accounts.dao.model.oznu.TransaccionOznu;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.ListBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Created by Entelgy on 12/01/2015.
 */

@Component("tx-get-account-movement-resume")
public class TxGetAccountMovementResume extends
		ListBbvaTransaction<DTOIntFilterMovResumes, FormatoOZECNUE0, DTOIntAccMovementsResume, FormatoOZECNUS0> {

	@Autowired
	private transient TransaccionOznu transaccionOznu;

	@Resource(name = "txAccountMapper")
	private TxAccountMapper txAccountMapper;

	@Override
	protected FormatoOZECNUE0 mapDtoInToRequestFormat(DTOIntFilterMovResumes dtoIn) {
		return txAccountMapper.mapInOznu(dtoIn);
	}

	@Override
	protected DTOIntAccMovementsResume mapResponseFormatToDtoOut(FormatoOZECNUS0 formatOutput, DTOIntFilterMovResumes dtoIn) {
		return txAccountMapper.mapOutOznu(formatOutput);
	}

	@Override
	protected InvocadorTransaccion<?, ?> getTransaction() {
		return transaccionOznu;
	}

}

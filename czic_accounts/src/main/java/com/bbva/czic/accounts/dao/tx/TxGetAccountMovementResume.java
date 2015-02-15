package com.bbva.czic.accounts.dao.tx;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bbva.czic.accounts.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.accounts.business.dto.DTOIntFilterMovResumes;
import com.bbva.czic.accounts.dao.mappers.TxAccountMapper;
import com.bbva.czic.accounts.dao.model.oznu.FormatoOZECNUE0;
import com.bbva.czic.accounts.dao.model.oznu.FormatoOZECNUS0;
import com.bbva.czic.accounts.dao.model.oznu.PeticionTransaccionOznu;
import com.bbva.czic.accounts.dao.model.oznu.RespuestaTransaccionOznu;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.MultiBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Created by Entelgy on 12/01/2015.
 */

@Component("tx-get-account-movement-resume")
public class TxGetAccountMovementResume extends
		MultiBbvaTransaction<DTOIntFilterMovResumes, FormatoOZECNUE0, DTOIntAccMovementsResume, FormatoOZECNUS0> {

	@Resource(name = "transaccionOznu")
	private transient InvocadorTransaccion<PeticionTransaccionOznu, RespuestaTransaccionOznu> transaccionOznu;

	@Resource(name = "txAccountMapper")
	private TxAccountMapper txAccountMapper;

	@Override
	protected FormatoOZECNUE0 mapDtoInToRequestFormat(DTOIntFilterMovResumes dtoIn) {
		return txAccountMapper.mapInOznu(dtoIn);
	}

	@Override
	protected DTOIntAccMovementsResume mapResponseFormatToDtoOut(FormatoOZECNUS0 formatOutput,
			DTOIntFilterMovResumes dtoIn) {
		return txAccountMapper.mapOutOznu(formatOutput);
	}

	@Override
	protected InvocadorTransaccion<?, ?> getTransaction() {
		return transaccionOznu;
	}

}

package com.bbva.czic.accounts.dao.tx.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.bbva.czic.accounts.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.czic.accounts.business.dto.DTOIntResponseAccMovementsResumes;
import com.bbva.czic.accounts.dao.model.oznu.FormatoOZECNUE0;
import com.bbva.czic.accounts.dao.model.oznu.FormatoOZECNUS0;
import com.bbva.czic.accounts.dao.model.oznu.PeticionTransaccionOznu;
import com.bbva.czic.accounts.dao.model.oznu.RespuestaTransaccionOznu;
import com.bbva.czic.accounts.dao.model.oznu.TransaccionOznu;
import com.bbva.czic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.czic.routine.commons.rm.utils.tx.IPaginatedTransactionMapper;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Created by Entelgy on 12/01/2015.
 */

@Component("tx-get-account-movement-resume")
public class TxGetAccountMovementResumeImpl extends
		SimpleTransaction<PeticionTransaccionOznu, RespuestaTransaccionOznu> {

	@Autowired
	private transient TransaccionOznu transaccionOznu;

	@Autowired
	@Qualifier("tx-get-account-movement-resume-mapper")
	private transient IPaginatedTransactionMapper<DTOIntFilterAccount, FormatoOZECNUE0, DTOIntResponseAccMovementsResumes, IFormatNotApply, DTOIntAccMovementsResume, FormatoOZECNUS0, IFormatNotApply> txGetAccountMovementResumeMapper;

	@Override
	protected InvocadorTransaccion<PeticionTransaccionOznu, RespuestaTransaccionOznu> getInvoker() {
		return transaccionOznu;
	}

	@Override
	protected IPaginatedTransactionMapper<DTOIntFilterAccount, FormatoOZECNUE0, DTOIntResponseAccMovementsResumes, IFormatNotApply, DTOIntAccMovementsResume, FormatoOZECNUS0, IFormatNotApply> getMapper() {
		return null;
	}
}

package com.bbva.czic.accounts.dao.tx.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.czic.accounts.business.dto.DTOIntAccount;
import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCENA0;
import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCSNA0;
import com.bbva.czic.accounts.dao.model.ozna.PeticionTransaccionOzna;
import com.bbva.czic.accounts.dao.model.ozna.RespuestaTransaccionOzna;
import com.bbva.czic.accounts.dao.model.ozna.TransaccionOzna;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Created by Entelgy on 09/01/2015.
 */
@Component("tx-get-account")
public class TxGetAccountImpl extends SimpleTransaction<PeticionTransaccionOzna, RespuestaTransaccionOzna> {

	@Autowired
	private transient TransaccionOzna transaccionOzna;

	@Resource(name = "tx-get-account-mapper")
	private ISimpleTransactionMapper<DTOIntAccount, FormatoOZNCENA0, DTOIntAccount, FormatoOZNCSNA0> mapper;

	@Override
	protected InvocadorTransaccion<PeticionTransaccionOzna, RespuestaTransaccionOzna> getInvoker() {
		return transaccionOzna;
	}

	@Override
	protected ISimpleTransactionMapper<DTOIntAccount, FormatoOZNCENA0, DTOIntAccount, FormatoOZNCSNA0> getMapper() {
		return mapper;
	}

}

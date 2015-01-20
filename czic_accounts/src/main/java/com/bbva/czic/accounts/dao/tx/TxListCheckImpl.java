package com.bbva.czic.accounts.dao.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.czic.accounts.dao.model.oznx.PeticionTransaccionOznx;
import com.bbva.czic.accounts.dao.model.oznx.RespuestaTransaccionOznx;
import com.bbva.czic.accounts.dao.model.oznx.TransaccionOznx;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Created by Entelgy on 14/01/2015.
 */
@Component("tx-list-Check-mapperc")
public class TxListCheckImpl extends SimpleTransaction<PeticionTransaccionOznx, RespuestaTransaccionOznx> {

	@Autowired
	private transient TransaccionOznx transaccionOznx;

	@Override
	protected InvocadorTransaccion<PeticionTransaccionOznx, RespuestaTransaccionOznx> getInvoker() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected <I, IF, O, OF> ISimpleTransactionMapper<I, IF, O, OF> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

}
package com.bbva.czic.accounts.dao.tx;

import com.bbva.czic.accounts.dao.model.ozna.PeticionTransaccionOzna;
import com.bbva.czic.accounts.dao.model.ozna.RespuestaTransaccionOzna;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.stereotype.Component;

/**
 * Created by Entelgy on 09/01/2015.
 */
@Component("tx-get-account")
public class TxGetAccount extends SimpleTransaction<PeticionTransaccionOzna,RespuestaTransaccionOzna> {


    @Override
    protected InvocadorTransaccion<PeticionTransaccionOzna, RespuestaTransaccionOzna> getInvoker() {
        return null;
    }

    @Override
    protected <I, IF, O, OF> ISimpleTransactionMapper<I, IF, O, OF> getMapper() {
        return null;
    }
}

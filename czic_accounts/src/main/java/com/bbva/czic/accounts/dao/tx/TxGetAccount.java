package com.bbva.czic.accounts.dao.tx;

import com.bbva.czic.accounts.business.dto.DTOIntAccount;
import com.bbva.czic.accounts.dao.model.ozna.*;
import com.bbva.czic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.czic.routine.commons.rm.utils.tx.IPaginatedTransactionMapper;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.PaginatedTransaction;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Entelgy on 09/01/2015.
 */
@Component("tx-get-account")
public class TxGetAccount extends SimpleTransaction<PeticionTransaccionOzna,RespuestaTransaccionOzna> {

    @Autowired
    private transient TransaccionOzna transaccionOzna;
    @Autowired
    @Qualifier("tx-get-account-mapper")
    private ISimpleTransactionMapper<DTOIntAccount,FormatoOZNCENA0,DTOIntAccount,FormatoOZNCSNA0> txGetAccountMapper;


    @Override
    protected InvocadorTransaccion<PeticionTransaccionOzna, RespuestaTransaccionOzna> getInvoker() {
        return transaccionOzna;
    }

    @Override
    protected ISimpleTransactionMapper<DTOIntAccount,FormatoOZNCENA0,DTOIntAccount,FormatoOZNCSNA0> getMapper() {
        return txGetAccountMapper;
    }

}


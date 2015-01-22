package com.bbva.czic.accounts.dao.tx;

import com.bbva.czic.accounts.business.dto.DTOIntCheckbook;
import com.bbva.czic.accounts.dao.model.ozns.*;
import com.bbva.czic.accounts.dao.model.ozns.FormatoOZECNSE0;
import com.bbva.czic.accounts.dao.model.ozns.PeticionTransaccionOzns;
import com.bbva.czic.accounts.dao.model.ozns.RespuestaTransaccionOzns;
import com.bbva.czic.accounts.dao.model.ozns.TransaccionOzns;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Entelgy Colombia.
 */
@Component(value = "tx-get-checkbook")
public class TxGetCheckbook extends SimpleTransaction<PeticionTransaccionOzns, RespuestaTransaccionOzns> {

    @Autowired
    private transient TransaccionOzns transaccionOzns;

    @Resource(name = "tx-get-checkbooks-mapper")
    private ISimpleTransactionMapper txGetCheckbookMapper;

    @Override
    protected InvocadorTransaccion<PeticionTransaccionOzns, RespuestaTransaccionOzns> getInvoker() {
        return transaccionOzns;
    }

    @Override
    protected ISimpleTransactionMapper<DTOIntCheckbook, FormatoOZECNSE0, DTOIntCheckbook, com.bbva.czic.accounts.dao.model.ozns.FormatoOZECNSS0> getMapper() {
        return txGetCheckbookMapper;
    }
}

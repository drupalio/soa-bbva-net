package com.bbva.czic.checkbooks.dao.tx;

import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.dao.model.ozny.*;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransaction;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author Entelgy Colombia.
 */
public class TxGetCheck extends SimpleTransaction<PeticionTransaccionOzny, RespuestaTransaccionOzny> {

    @Autowired
    private transient TransaccionOzny transaccionOzny;

    @Resource(name = "tx-get-checks-mapper")
    private ISimpleTransactionMapper<DTOIntCheck, FormatoOZECNYE0, DTOIntCheck, FormatoOZECNYS0> txGetCheckMapper;

    @Override
    protected InvocadorTransaccion<PeticionTransaccionOzny, RespuestaTransaccionOzny> getInvoker() {
        return transaccionOzny;
    }

    @Override
    protected ISimpleTransactionMapper<DTOIntCheck, FormatoOZECNYE0, DTOIntCheck, FormatoOZECNYS0> getMapper() {
        return txGetCheckMapper;
    }
}

package com.bbva.czic.products.dao.tx;

import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntProduct;
import com.bbva.czic.products.dao.model.oznt.*;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Administrador on 05/01/2015.
 */
@Component("tx-get-conditions")
public class TxGetConditions extends SimpleTransaction<PeticionTransaccionOznt, RespuestaTransaccionOznt> {

    @Autowired
    private transient TransaccionOznt transaccionOznt;
    @Autowired
    @Qualifier("tx-get-conditions-mapper")
    private ISimpleTransactionMapper<DTOIntProduct,FormatoOZECNTE0,DTOIntConditions,FormatoOZECNTS0> txGetConditionsMapper;

    @Override
    protected InvocadorTransaccion<PeticionTransaccionOznt, RespuestaTransaccionOznt> getInvoker() {
        return transaccionOznt;
    }

    @Override
    protected ISimpleTransactionMapper<DTOIntProduct,FormatoOZECNTE0,DTOIntConditions,FormatoOZECNTS0> getMapper() {
        return txGetConditionsMapper;
    }
}

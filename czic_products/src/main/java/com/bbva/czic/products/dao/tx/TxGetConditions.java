package com.bbva.czic.products.dao.tx;

import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntProducts;
import com.bbva.czic.products.dao.model.oznt.*;
import com.bbva.czic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.czic.routine.commons.rm.utils.tx.IPaginatedTransactionMapper;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import scala.unchecked;

/**
 * Created by Administrador on 05/01/2015.
 */
@Component("tx-get-conditions")
public class TxGetConditions extends SimpleTra {

    @Autowired
    private transient TransaccionOzn1 transaccionOzn1;

    @Autowired
    @Qualifier("tx-get-extract-global-balance-mapper-tc")
    private transient IPaginatedTransactionMapper<DTOIntFilterProduct, FormatoOZECN1E0, DTOIntProducts, IFormatNotApply, DTOIntProduct, FormatoOZECN1S1, IFormatNotApply> txGetExtractGlobalBalanceMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    protected InvocadorTransaccion<PeticionTransaccionOzn1, RespuestaTransaccionOzn1> getInvoker() {
        return transaccionOzn1;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    protected IPaginatedTransactionMapper<DTOIntFilterProduct, FormatoOZECN1E0, DTOIntProducts, IFormatNotApply, DTOIntProduct, FormatoOZECN1S1, IFormatNotApply> getMapper() {
        return txGetExtractGlobalBalanceMapper;
    }
}

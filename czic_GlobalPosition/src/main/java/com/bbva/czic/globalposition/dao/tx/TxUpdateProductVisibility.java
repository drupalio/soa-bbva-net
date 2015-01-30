package com.bbva.czic.globalposition.dao.tx;

import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProductVisibility;
import com.bbva.czic.globalposition.dao.model.ozn0.FormatoOZNCEOM0;
import com.bbva.czic.globalposition.dao.model.ozn0.PeticionTransaccionOzn0;
import com.bbva.czic.globalposition.dao.model.ozn0.RespuestaTransaccionOzn0;
import com.bbva.czic.globalposition.dao.model.ozn0.TransaccionOzn0;
import com.bbva.czic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Administrador on 06/01/2015.
 */
@Component("tx-update-product-visibility")
public class TxUpdateProductVisibility extends SimpleTransaction<PeticionTransaccionOzn0, RespuestaTransaccionOzn0> {

    @Autowired
    private transient TransaccionOzn0 transaccionOzn0;

    @Autowired
    @Qualifier("tx-update-product-visibility-mapper")
    private ISimpleTransactionMapper<DTOIntProductVisibility, FormatoOZNCEOM0, DTOIntProduct, IFormatNotApply> txUpdateProductVisibilityMapper;

    @Override
    protected InvocadorTransaccion<PeticionTransaccionOzn0, RespuestaTransaccionOzn0> getInvoker() {
        return transaccionOzn0;
    }

    @Override
    protected ISimpleTransactionMapper<DTOIntProductVisibility, FormatoOZNCEOM0, DTOIntProduct, IFormatNotApply> getMapper() {
        return txUpdateProductVisibilityMapper;
    }
}

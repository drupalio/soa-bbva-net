package com.bbva.czic.globalposition.dao.tx;

import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.dao.model.oznh.FormatoOZNCEOMH;
import com.bbva.czic.globalposition.dao.model.oznh.PeticionTransaccionOznh;
import com.bbva.czic.globalposition.dao.model.oznh.RespuestaTransaccionOznh;
import com.bbva.czic.globalposition.dao.model.oznh.TransaccionOznh;
import com.bbva.czic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author Entelgy Colombia
 */
@Component("tx-update-product-operability")
public class TxUpdateProductOperability extends SimpleTransaction<PeticionTransaccionOznh, RespuestaTransaccionOznh> {

    @Autowired
    private transient TransaccionOznh transaccionOznh;

    @Autowired
    @Qualifier("tx-update-product-operability-mapper")
    private ISimpleTransactionMapper<DTOIntProduct, FormatoOZNCEOMH, DTOIntProduct, IFormatNotApply> txUpdateProductOperabilityMapper;

    @Override
    protected InvocadorTransaccion<PeticionTransaccionOznh, RespuestaTransaccionOznh> getInvoker() {
        return transaccionOznh;
    }

    @Override
    protected ISimpleTransactionMapper<DTOIntProduct, FormatoOZNCEOMH, DTOIntProduct, IFormatNotApply> getMapper() {
        return txUpdateProductOperabilityMapper;
    }
}
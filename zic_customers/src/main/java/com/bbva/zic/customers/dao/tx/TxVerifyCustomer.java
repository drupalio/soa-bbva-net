package com.bbva.zic.customers.dao.tx;

import com.bbva.zic.customers.business.dto.DTOIntCustomerOperation;
import com.bbva.zic.customers.dao.model.oznz.FormatoOZECNZE0;
import com.bbva.zic.customers.dao.model.oznz.PeticionTransaccionOznz;
import com.bbva.zic.customers.dao.model.oznz.RespuestaTransaccionOznz;
import com.bbva.zic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.zic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;
import com.bbva.zic.routine.commons.rm.utils.tx.impl.SimpleTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Entelgy on 30/01/2015.
 */
@Component("tx-verify-customer")
public class TxVerifyCustomer extends SimpleTransaction<PeticionTransaccionOznz, RespuestaTransaccionOznz> {

    @Resource(name="transaccionOznz")
    private transient InvocadorTransaccion<PeticionTransaccionOznz, RespuestaTransaccionOznz> transaccionOznz;

    @Autowired
    @Qualifier("tx-verify-customer-mapper")
    private ISimpleTransactionMapper<DTOIntCustomerOperation, FormatoOZECNZE0, Object, IFormatNotApply> txVerifyCustomerMapper;

    @Override
    protected InvocadorTransaccion<PeticionTransaccionOznz, RespuestaTransaccionOznz> getInvoker() {
        return transaccionOznz;
    }

    @Override
    protected ISimpleTransactionMapper <DTOIntCustomerOperation, FormatoOZECNZE0, Object, IFormatNotApply> getMapper() {
        return txVerifyCustomerMapper;
    }
}

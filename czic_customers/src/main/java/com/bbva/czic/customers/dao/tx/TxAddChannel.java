package com.bbva.czic.customers.dao.tx;

import com.bbva.czic.customers.business.dto.DTOIntAddChannel;
import com.bbva.czic.customers.dao.mappers.ITxCustomerMapper;
import com.bbva.czic.customers.dao.model.oznw.FormatoOZECNWE0;
import com.bbva.czic.customers.dao.model.oznw.PeticionTransaccionOznw;
import com.bbva.czic.customers.dao.model.oznw.RespuestaTransaccionOznw;
import com.bbva.czic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Entelgy on 30/01/2015.
 */
@Component(value = "tx-add-channel")
public class TxAddChannel  extends SimpleBbvaTransaction<DTOIntAddChannel, FormatoOZECNWE0, DTOIntAddChannel, IFormatNotApply> {

    @Resource(name = "txCustomerMapper")
    private ITxCustomerMapper iTxCustomerMapper;

    @Resource(name="transaccionOznw")
    private transient InvocadorTransaccion<PeticionTransaccionOznw, RespuestaTransaccionOznw> transaccionOznw;

    @Override
    protected FormatoOZECNWE0 mapDtoInToRequestFormat(DTOIntAddChannel dtoIn) {
       return iTxCustomerMapper.mapInOznw(dtoIn);
    }

    @Override
    protected DTOIntAddChannel mapResponseFormatToDtoOut(IFormatNotApply formatOutput, DTOIntAddChannel dtoIn) {
        return null;
    }

    @Override
    protected InvocadorTransaccion<?, ?> getTransaction() {
        return transaccionOznw;
    }
}

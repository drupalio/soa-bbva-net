package com.bbva.czic.customers.dao.tx;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResumesFilter;
import com.bbva.czic.customers.dao.mappers.ITxCustomerMapper;
import com.bbva.czic.customers.dao.model.oznq.FormatoOZECNQE0;
import com.bbva.czic.customers.dao.model.oznq.FormatoOZECNQS0;
import com.bbva.czic.customers.dao.model.oznq.PeticionTransaccionOznq;
import com.bbva.czic.customers.dao.model.oznq.RespuestaTransaccionOznq;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.MultiBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Entelgy Colombia.
 */
@Component("txListAccountMovementsResume")
public class TxListAccountMovementsResume extends MultiBbvaTransaction
        <DTOIntAccMovementsResumesFilter, FormatoOZECNQE0, DTOIntAccMovementsResume, FormatoOZECNQS0> {

    @Resource(name = "txCustomerMapper")
    private transient ITxCustomerMapper txCustomerMapper;

    @Resource(name = "transaccionOznq")
    private transient InvocadorTransaccion<PeticionTransaccionOznq, RespuestaTransaccionOznq> transaccionOznq;

    @Override
    protected FormatoOZECNQE0 mapDtoInToRequestFormat(DTOIntAccMovementsResumesFilter dtoIn) {
        return txCustomerMapper.mapInOznq(dtoIn);
    }

    @Override
    protected DTOIntAccMovementsResume mapResponseFormatToDtoOut(FormatoOZECNQS0 formatOutput, DTOIntAccMovementsResumesFilter dtoIn) {
        return txCustomerMapper.mapOutOznq(formatOutput);
    }

    @Override
    protected InvocadorTransaccion<PeticionTransaccionOznq, RespuestaTransaccionOznq> getTransaction() {
        return transaccionOznq;
    }
}

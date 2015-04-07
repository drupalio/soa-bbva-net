package com.bbva.zic.customers.dao.tx;

import com.bbva.zic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.zic.customers.business.dto.DTOIntAccMovementsResumesFilter;
import com.bbva.zic.customers.dao.mappers.ITxCustomerMapper;
import com.bbva.zic.customers.dao.model.oznq.FormatoOZECNQE0;
import com.bbva.zic.customers.dao.model.oznq.FormatoOZECNQS0;
import com.bbva.zic.customers.dao.model.oznq.PeticionTransaccionOznq;
import com.bbva.zic.customers.dao.model.oznq.RespuestaTransaccionOznq;
import com.bbva.zic.routine.commons.rm.utils.tx.impl.MultiBbvaTransaction;
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

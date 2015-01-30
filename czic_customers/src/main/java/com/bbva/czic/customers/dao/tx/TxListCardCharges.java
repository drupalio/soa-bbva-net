package com.bbva.czic.customers.dao.tx;

import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.czic.customers.business.dto.DTOIntCardChargeFilter;
import com.bbva.czic.customers.dao.mappers.ITxCustomerMapper;
import com.bbva.czic.customers.dao.model.oznp.FormatoOZECNPE0;
import com.bbva.czic.customers.dao.model.oznp.FormatoOZECNPS0;
import com.bbva.czic.customers.dao.model.oznp.PeticionTransaccionOznp;
import com.bbva.czic.customers.dao.model.oznp.RespuestaTransaccionOznp;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Entelgy Colombia.
 */
@Component("txListCardCharges")
public class TxListCardCharges extends SimpleBbvaTransaction<DTOIntCardChargeFilter, FormatoOZECNPE0, DTOIntCardCharge, FormatoOZECNPS0> {

    @Resource(name = "transaccionOznp")
    private InvocadorTransaccion<PeticionTransaccionOznp, RespuestaTransaccionOznp> transaccionOznp;

    @Resource(name = "txCustomerMapper")
    private ITxCustomerMapper customerMapper;

    @Override
    protected FormatoOZECNPE0 mapDtoInToRequestFormat(DTOIntCardChargeFilter dtoIn) {
        return customerMapper.mapInOznp(dtoIn);
    }

    @Override
    protected DTOIntCardCharge mapResponseFormatToDtoOut(FormatoOZECNPS0 formatOutput, DTOIntCardChargeFilter dtoIn) {
        return customerMapper.mapOutOznp(formatOutput);
    }

    @Override
    protected InvocadorTransaccion<PeticionTransaccionOznp, RespuestaTransaccionOznp> getTransaction() {
        return transaccionOznp;
    }
}

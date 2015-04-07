package com.bbva.zic.customers.dao.tx;

import com.bbva.zic.customers.business.dto.DTOIntCardCharge;
import com.bbva.zic.customers.business.dto.DTOIntCardChargeFilter;
import com.bbva.zic.customers.dao.mappers.ITxCustomerMapper;
import com.bbva.zic.customers.dao.model.oznp.FormatoOZECNPE0;
import com.bbva.zic.customers.dao.model.oznp.FormatoOZECNPS0;
import com.bbva.zic.customers.dao.model.oznp.PeticionTransaccionOznp;
import com.bbva.zic.customers.dao.model.oznp.RespuestaTransaccionOznp;
import com.bbva.zic.routine.commons.rm.utils.tx.impl.MultiBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Entelgy Colombia.
 */
@Component("txListCardCharges")
public class TxListCardCharges extends MultiBbvaTransaction<DTOIntCardChargeFilter, FormatoOZECNPE0, DTOIntCardCharge, FormatoOZECNPS0> {

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

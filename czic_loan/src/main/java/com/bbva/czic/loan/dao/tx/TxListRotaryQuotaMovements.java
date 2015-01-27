package com.bbva.czic.loan.dao.tx;

import com.bbva.czic.loan.business.dto.DTOIntFilterLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.czic.loan.dao.mappers.impl.ITxMovementMapper;
import com.bbva.czic.loan.dao.model.ozni.FormatoOZNCENI0;
import com.bbva.czic.loan.dao.model.ozni.FormatoOZNCSNI0;
import com.bbva.czic.loan.dao.model.ozni.TransaccionOzni;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.ListBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Entelgy on 26/01/2015.
 */
@Component(value = "tx-list-rotary-quota-movements")
public class TxListRotaryQuotaMovements extends ListBbvaTransaction<DTOIntFilterLoan, FormatoOZNCENI0, DTOIntMovement, FormatoOZNCSNI0> {

    @Autowired
    private transient TransaccionOzni transaccionOzni;

    @Resource(name = "")
    private transient ITxMovementMapper iTxMovementMapper;

    @Override
    protected FormatoOZNCENI0 mapDtoInToRequestFormat(DTOIntFilterLoan dtoIn) {
        return iTxMovementMapper.mapInOzni(dtoIn);
    }

    @Override
    protected DTOIntMovement mapResponseFormatToDtoOut(FormatoOZNCSNI0 formatOutput, DTOIntFilterLoan dtoIn) {
        return iTxMovementMapper.mapOutOzni(formatOutput);
    }

    @Override
    protected InvocadorTransaccion<?, ?> getTransaction() {
        return transaccionOzni;
    }
}

package com.bbva.czic.loan.dao.tx;

import com.bbva.czic.loan.business.dto.*;
import com.bbva.czic.loan.dao.mappers.TxMovementMapper;
import com.bbva.czic.loan.dao.mappers.TxRotaryQuotaMovementMapperMapper;
import com.bbva.czic.loan.dao.model.ozni.FormatoOZNCENI0;
import com.bbva.czic.loan.dao.model.ozni.FormatoOZNCSNI0;
import com.bbva.czic.loan.dao.model.ozni.TransaccionOzni;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCENJ0;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCSNJ0;
import com.bbva.czic.loan.dao.model.oznj.TransaccionOznj;
import com.bbva.czic.loan.dao.model.oznk.FormatoOZNCENK0;
import com.bbva.czic.loan.dao.model.oznk.FormatoOZNCSNK0;
import com.bbva.czic.loan.dao.model.oznk.TransaccionOznk;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Entelgy on 26/01/2015.
 */
@Component(value = "tx-get-rotary-quota-movement")
public class TxGetRotaryQuotaMovement extends SimpleBbvaTransaction<DTOIntFilterLoan, FormatoOZNCENK0, DTOIntRotaryQuotaMove, FormatoOZNCSNK0> {

    @Autowired
    private transient TransaccionOznk transaccionOznk;

    @Resource(name = "tx-rotary-quota-movement-mapper")
    private TxRotaryQuotaMovementMapperMapper txRotaryQuotaMovementMapperMapper;

    @Override
    protected FormatoOZNCENK0 mapDtoInToRequestFormat(DTOIntFilterLoan dtoIn) {
        return txRotaryQuotaMovementMapperMapper.mapInOzni(dtoIn);
    }

    @Override
    protected DTOIntRotaryQuotaMove mapResponseFormatToDtoOut(FormatoOZNCSNK0 formatOutput, DTOIntFilterLoan dtoIn) {
        return txRotaryQuotaMovementMapperMapper.mapOutOzni(formatOutput);
    }

    @Override
    protected InvocadorTransaccion<?, ?> getTransaction() {
        return transaccionOznk;
    }
}

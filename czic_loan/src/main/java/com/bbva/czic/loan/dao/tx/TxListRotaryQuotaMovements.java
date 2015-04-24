package com.bbva.czic.loan.dao.tx;

import com.bbva.czic.loan.business.dto.DTOIntFilterLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.czic.loan.dao.mappers.impl.ITxLoanMapper;
import com.bbva.czic.loan.dao.model.ozni.*;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.MultiBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Entelgy on 26/01/2015.
 */
@Component(value = "tx-list-rotary-quota-movements")
public class TxListRotaryQuotaMovements extends MultiBbvaTransaction<DTOIntFilterLoan, FormatoOZNCENI0, DTOIntMovement, FormatoOZNCSNI0> {

    @Resource(name = "transaccionOzni")
    private InvocadorTransaccion<PeticionTransaccionOzni, RespuestaTransaccionOzni> transaccionOzni;

    @Resource(name = "tx-loan-mapper")
    private ITxLoanMapper iTxLoanMapper;

    @Override
    protected FormatoOZNCENI0 mapDtoInToRequestFormat(DTOIntFilterLoan dtoIn) {

        return iTxLoanMapper.mapInOzni(dtoIn);
    }

    @Override
    protected DTOIntMovement mapResponseFormatToDtoOut(FormatoOZNCSNI0 formatOutput, DTOIntFilterLoan dtoIn) {
        return iTxLoanMapper.mapOutOzni(formatOutput);
    }

    @Override
    protected InvocadorTransaccion<?, ?> getTransaction() {
        return transaccionOzni;
    }
}

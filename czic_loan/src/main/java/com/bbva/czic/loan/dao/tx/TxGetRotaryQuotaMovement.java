package com.bbva.czic.loan.dao.tx;

import com.bbva.czic.loan.business.dto.*;
import com.bbva.czic.loan.dao.mappers.impl.ITxLoanMapper;
import com.bbva.czic.loan.dao.model.oznk.*;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Entelgy on 26/01/2015.
 */
@Component(value = "tx-get-rotary-quota-movement")
public class TxGetRotaryQuotaMovement extends SimpleBbvaTransaction<DTOIntFilterLoan, FormatoOZNCENK0, DTOIntRotaryQuotaMove, FormatoOZNCSNK0> {

    @Resource(name = "transaccionOznk")
    private InvocadorTransaccion<PeticionTransaccionOznk, RespuestaTransaccionOznk> transaccionOznk;

    @Resource(name = "tx-loan-mapper")
    private ITxLoanMapper iTxLoanMapper;

    /**
     *
     * @param dtoIn
     * @return
     */
    @Override
    protected FormatoOZNCENK0 mapDtoInToRequestFormat(DTOIntFilterLoan dtoIn) {
        return iTxLoanMapper.mapInOznk(dtoIn);
    }

    /**
     *
     * @param formatOutput
     * @param dtoIn
     * @return
     */
    @Override
    protected DTOIntRotaryQuotaMove mapResponseFormatToDtoOut(FormatoOZNCSNK0 formatOutput, DTOIntFilterLoan dtoIn) {
        return iTxLoanMapper.mapOutOznk(formatOutput);
    }

    /**
     *
     * @return
     */
    @Override
    protected InvocadorTransaccion<?, ?> getTransaction() {
        return transaccionOznk;
    }
}

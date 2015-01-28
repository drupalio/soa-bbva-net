package com.bbva.czic.loan.dao.tx;

import com.bbva.czic.loan.business.dto.DTOIntFilterLoan;
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.dao.mappers.TxLoanMapper;
import com.bbva.czic.loan.dao.mappers.impl.ITxLoanMapper;
import com.bbva.czic.loan.dao.model.oznj.*;


import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Entelgy on 26/01/2015.
 */
@Component("tx-get-rotary-quota")
public class TxGetRotaryQuota extends SimpleBbvaTransaction<DTOIntFilterLoan, FormatoOZNCENJ0, DTOIntLoan, FormatoOZNCSNJ0>{

    @Resource(name = "transaccionOznj")
    private InvocadorTransaccion<PeticionTransaccionOznj, RespuestaTransaccionOznj> transaccionOznj;

    @Resource(name = "tx-loan-mapper")
    private ITxLoanMapper iTxLoanMapper;

    /**
     *
     * @param dtoIn
     * @return
     */
    @Override
    protected FormatoOZNCENJ0 mapDtoInToRequestFormat(DTOIntFilterLoan dtoIn) {
        return iTxLoanMapper.mapInOznj(dtoIn);
    }

    /**
     *
     * @param formatOutput
     * @param dtoIn
     * @return
     */
    @Override
    protected DTOIntLoan mapResponseFormatToDtoOut(FormatoOZNCSNJ0 formatOutput, DTOIntFilterLoan dtoIn) {
        return iTxLoanMapper.mapOutOznj(formatOutput);
    }

    /**
     *
     * @return
     */
    @Override
    protected InvocadorTransaccion<?, ?> getTransaction() {
        return transaccionOznj;
    }
}

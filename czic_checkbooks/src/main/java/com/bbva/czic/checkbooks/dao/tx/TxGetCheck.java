package com.bbva.czic.checkbooks.dao.tx;

import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckFilter;
import com.bbva.czic.checkbooks.dao.mappers.TxCheckMapper;
import com.bbva.czic.checkbooks.dao.model.ozny.*;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransaction;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleBbvaTransaction;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Entelgy Colombia.
 */
@Component(value = "tx-get-check")
public class TxGetCheck extends SimpleBbvaTransaction<DTOIntCheckFilter, FormatoOZECNYE0, DTOIntCheck, FormatoOZECNYS0> {

    @Resource(name = "transaccionOzny")
    private InvocadorTransaccion<PeticionTransaccionOzny, RespuestaTransaccionOzny> transaccionOzny;
    @Resource(name = "tx-get-checks-mapper")
    private TxCheckMapper txCheckMapper;


    @Override
    protected FormatoOZECNYE0 mapDtoInToRequestFormat(DTOIntCheckFilter dtoIn) {
        return txCheckMapper.mapInOzny(dtoIn);
    }

    @Override
    protected DTOIntCheck mapResponseFormatToDtoOut(FormatoOZECNYS0 formatOutput, DTOIntCheckFilter dtoIn) {
        return txCheckMapper.mapOutOzny(formatOutput);
    }

    @Override
    protected InvocadorTransaccion<?, ?> getTransaction() {
        return transaccionOzny;
    }
}

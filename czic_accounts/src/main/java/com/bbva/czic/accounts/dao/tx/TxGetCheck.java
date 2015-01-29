package com.bbva.czic.accounts.dao.tx;

import com.bbva.czic.accounts.business.dto.DTOIntCheck;
import com.bbva.czic.accounts.business.dto.DTOIntCheckFilter;
import com.bbva.czic.accounts.dao.mappers.TxAccountMapper;
import com.bbva.czic.accounts.dao.mappers.TxCheckMapper;
import com.bbva.czic.accounts.dao.model.ozny.FormatoOZECNYE0;
import com.bbva.czic.accounts.dao.model.ozny.FormatoOZECNYS0;
import com.bbva.czic.accounts.dao.model.ozny.PeticionTransaccionOzny;
import com.bbva.czic.accounts.dao.model.ozny.RespuestaTransaccionOzny;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Entelgy Colombia.
 */
@Component(value = "tx-get-check")
public class TxGetCheck extends SimpleBbvaTransaction<DTOIntCheckFilter, FormatoOZECNYE0, DTOIntCheck, FormatoOZECNYS0> {

    @Resource(name = "transaccionOzny")
    private InvocadorTransaccion<PeticionTransaccionOzny, RespuestaTransaccionOzny> transaccionOzny;
    @Resource(name = "txAccountMapper")
    private TxAccountMapper txAccountMapper;


    @Override
    protected FormatoOZECNYE0 mapDtoInToRequestFormat(DTOIntCheckFilter dtoIn) {
        return txAccountMapper.mapInOzny(dtoIn);
    }

    @Override
    protected DTOIntCheck mapResponseFormatToDtoOut(FormatoOZECNYS0 formatOutput, DTOIntCheckFilter dtoIn) {
        return txAccountMapper.mapOutOzny(formatOutput);
    }

    @Override
    protected InvocadorTransaccion<?, ?> getTransaction() {
        return transaccionOzny;
    }
}

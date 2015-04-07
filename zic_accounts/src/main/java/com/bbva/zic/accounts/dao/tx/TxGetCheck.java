package com.bbva.zic.accounts.dao.tx;

import com.bbva.zic.accounts.business.dto.DTOIntCheck;
import com.bbva.zic.accounts.business.dto.DTOIntCheckFilter;
import com.bbva.zic.accounts.dao.mappers.TxAccountMapper;
import com.bbva.zic.accounts.dao.model.ozny.FormatoOZECNYE0;
import com.bbva.zic.accounts.dao.model.ozny.FormatoOZECNYS0;
import com.bbva.zic.accounts.dao.model.ozny.PeticionTransaccionOzny;
import com.bbva.zic.accounts.dao.model.ozny.RespuestaTransaccionOzny;
import com.bbva.zic.routine.commons.rm.utils.tx.impl.SimpleBbvaTransaction;
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

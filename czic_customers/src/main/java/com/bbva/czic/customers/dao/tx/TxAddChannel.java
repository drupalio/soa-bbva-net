package com.bbva.czic.customers.dao.tx;

import com.bbva.czic.customers.business.dto.DTOIntAddChannel;
import com.bbva.czic.customers.dao.model.oznw.FormatoOZECNWE0;
import com.bbva.czic.customers.dao.model.oznw.PeticionTransaccionOznw;
import com.bbva.czic.customers.dao.model.oznw.RespuestaTransaccionOznw;
import com.bbva.czic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Entelgy on 30/01/2015.
 */
@Component(value = "tx-add-channel")
public class TxAddChannel  extends SimpleBbvaTransaction<DTOIntAddChannel, FormatoOZECNWE0, DTOIntAddChannel, IFormatNotApply> {

    @Resource(name="transaccionOznb")
    private transient InvocadorTransaccion<PeticionTransaccionOznw, RespuestaTransaccionOznw> transaccionOznw;

    @Override
    protected FormatoOZECNWE0 mapDtoInToRequestFormat(DTOIntAddChannel dtoIn) {
        FormatoOZECNWE0 formatoOZECNWE0 = new FormatoOZECNWE0();

        formatoOZECNWE0.setUsuario(dtoIn.getCustomerId());
        formatoOZECNWE0.setCanal(dtoIn.getChannelId());
        return formatoOZECNWE0;
    }

    @Override
    protected DTOIntAddChannel mapResponseFormatToDtoOut(IFormatNotApply formatOutput, DTOIntAddChannel dtoIn) {
        return new DTOIntAddChannel();
    }

    @Override
    protected InvocadorTransaccion<?, ?> getTransaction() {
        return transaccionOznw;
    }
}

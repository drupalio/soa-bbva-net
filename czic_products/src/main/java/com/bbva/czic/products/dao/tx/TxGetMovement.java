package com.bbva.czic.products.dao.tx;

import com.bbva.czic.products.business.dto.DTOIntFilterMovements;
import com.bbva.czic.products.business.dto.DTOIntMovement;
import com.bbva.czic.products.dao.mapper.TxProductMapper;
import com.bbva.czic.products.dao.model.oznm.FormatoOZNCENM0;
import com.bbva.czic.products.dao.model.oznm.FormatoOZNCSNM0;
import com.bbva.czic.products.dao.model.oznm.PeticionTransaccionOznm;
import com.bbva.czic.products.dao.model.oznm.RespuestaTransaccionOznm;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Entelgy on 29/01/2015.
 */
@Component("tx-get-movement")
public class TxGetMovement extends SimpleBbvaTransaction<DTOIntFilterMovements,FormatoOZNCENM0, DTOIntMovement, FormatoOZNCSNM0> {

    @Resource(name = "transaccionOznm")
    private InvocadorTransaccion<PeticionTransaccionOznm, RespuestaTransaccionOznm> transaccionOznm;

    @Resource(name = "txProductMapper")
    private TxProductMapper txProductMapper;

    @Override
    protected FormatoOZNCENM0 mapDtoInToRequestFormat(DTOIntFilterMovements dtoIn) {
        return null;
    }

    @Override
    protected DTOIntMovement mapResponseFormatToDtoOut(FormatoOZNCSNM0 formatOutput, DTOIntFilterMovements dtoIn) {
        return null;
    }

    @Override
    protected InvocadorTransaccion<?, ?> getTransaction() {
        return null;
    }
}

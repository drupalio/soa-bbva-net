package com.bbva.zic.products.dao.tx;

import javax.annotation.Resource;

import com.bbva.zic.products.business.dto.DTOIntFilterMovements;
import com.bbva.zic.products.business.dto.DTOIntMovement;
import com.bbva.zic.products.dao.mapper.TxProductsMapper;
import com.bbva.zic.products.dao.model.oznm.FormatoOZNCENM0;
import com.bbva.zic.products.dao.model.oznm.FormatoOZNCSNM0;
import com.bbva.zic.products.dao.model.oznm.PeticionTransaccionOznm;
import org.springframework.stereotype.Component;

import com.bbva.zic.products.dao.model.oznm.RespuestaTransaccionOznm;
import com.bbva.zic.routine.commons.rm.utils.tx.impl.SimpleBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Created by Entelgy on 29/01/2015.
 */
@Component("tx-get-movement")
public class TxGetMovement extends SimpleBbvaTransaction<DTOIntFilterMovements,FormatoOZNCENM0, DTOIntMovement, FormatoOZNCSNM0> {

    @Resource(name = "transaccionOznm")
    private InvocadorTransaccion<PeticionTransaccionOznm, RespuestaTransaccionOznm> transaccionOznm;

    @Resource(name = "txProductMapper")
    private TxProductsMapper txProductMapper;

    @Override
    protected FormatoOZNCENM0 mapDtoInToRequestFormat(DTOIntFilterMovements dtoIn) {
        return txProductMapper.mapInOznm(dtoIn);
    }

    @Override
    protected DTOIntMovement mapResponseFormatToDtoOut(FormatoOZNCSNM0 formatOutput, DTOIntFilterMovements dtoIn) {
        return txProductMapper.mapOutOznm(formatOutput);
    }

    @Override
    protected InvocadorTransaccion<?, ?> getTransaction() {
        return transaccionOznm;
    }
}

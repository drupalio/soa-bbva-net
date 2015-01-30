package com.bbva.czic.products.dao.tx;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bbva.czic.products.business.dto.DTOIntFilterMovements;
import com.bbva.czic.products.business.dto.DTOIntMovement;
import com.bbva.czic.products.dao.mapper.TxProductsMapper;
import com.bbva.czic.products.dao.model.oznl.FormatoOZECNLE0;
import com.bbva.czic.products.dao.model.oznl.FormatoOZECNLS0;
import com.bbva.czic.products.dao.model.oznl.PeticionTransaccionOznl;
import com.bbva.czic.products.dao.model.oznl.RespuestaTransaccionOznl;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.MultiBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Created by Entelgy on 29/01/2015.
 */
@Component("tx-list-movements")
public class TxListMovements extends MultiBbvaTransaction<DTOIntFilterMovements, FormatoOZECNLE0, DTOIntMovement, FormatoOZECNLS0> {


    @Resource(name = "transaccionOznl")
    private InvocadorTransaccion<PeticionTransaccionOznl, RespuestaTransaccionOznl> transaccionOznl;
    @Resource(name = "txProductMapper")
    private TxProductsMapper txProductMapper;

    @Override
    protected FormatoOZECNLE0 mapDtoInToRequestFormat(DTOIntFilterMovements dtoIn) {
        return txProductMapper.mapInOznl(dtoIn);
    }

    @Override
    protected DTOIntMovement mapResponseFormatToDtoOut(FormatoOZECNLS0 formatOutput, DTOIntFilterMovements dtoIn) {
        return txProductMapper.mapOutOznl(formatOutput);
    }

    @Override
    protected InvocadorTransaccion<?, ?> getTransaction() {
        return transaccionOznl;
    }
}

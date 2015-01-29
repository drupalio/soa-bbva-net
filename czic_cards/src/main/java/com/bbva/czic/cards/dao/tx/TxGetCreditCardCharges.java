package com.bbva.czic.cards.dao.tx;

import com.bbva.czic.cards.business.dto.DTOIntCardCharge;
import com.bbva.czic.cards.business.dto.DTOIntFilterCards;
import com.bbva.czic.cards.dao.mapper.TxCardsMapper;
import com.bbva.czic.cards.dao.model.ozno.FormatoOZECNOE0;
import com.bbva.czic.cards.dao.model.ozno.FormatoOZECNOS0;
import com.bbva.czic.cards.dao.model.ozno.PeticionTransaccionOzno;
import com.bbva.czic.cards.dao.model.ozno.RespuestaTransaccionOzno;
import com.bbva.czic.routine.commons.rm.utils.tx.Tx;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.MultiBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

import javax.annotation.Resource;

/**
 * Created by Entelgy on 28/01/2015.
 */
@Tx("tx-get-creditcard-charges")
public class TxGetCreditCardCharges extends
        MultiBbvaTransaction<DTOIntFilterCards, FormatoOZECNOE0, DTOIntCardCharge, FormatoOZECNOS0> {

    @Resource(name = "transaccionOzno")
    private InvocadorTransaccion<PeticionTransaccionOzno, RespuestaTransaccionOzno> transaccionGetCardCharges;

    @Resource(name = "txCardsMapper")
    private TxCardsMapper txCardsMapper;

    @Override
    protected FormatoOZECNOE0 mapDtoInToRequestFormat(DTOIntFilterCards dtoIn) {
        return txCardsMapper.mapInOzno(dtoIn);
    }

    @Override
    protected DTOIntCardCharge mapResponseFormatToDtoOut(FormatoOZECNOS0 formatOutput, DTOIntFilterCards dtoIn) {
        return txCardsMapper.mapOutOzno(formatOutput);
    }

    @Override
    protected InvocadorTransaccion<?, ?> getTransaction() {
        return transaccionGetCardCharges;
    }
}

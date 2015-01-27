package com.bbva.czic.executives.dao.tx;

import com.bbva.czic.executives.business.dto.DTOIntExecutive;
import com.bbva.czic.executives.business.dto.DTOIntExecutivesFilter;
import com.bbva.czic.executives.dao.mapper.TxExecutiveMapper;
import com.bbva.czic.executives.dao.model.oznr.*;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
/**
 * Created by Entelgy on 12/01/2015.
 */
@Component("tx-get-executive")
public class TxGetExecutive extends SimpleBbvaTransaction<DTOIntExecutivesFilter, FormatoOZECNRE0, DTOIntExecutive, FormatoOZECNRS0> {


    @Resource(name = "transaccionOznr")
    private InvocadorTransaccion<PeticionTransaccionOznr, RespuestaTransaccionOznr> transaccionOznr;

    @Resource(name = "txExecutiveMapper")
    private TxExecutiveMapper txExecutiveMapper;

    @Override
    protected FormatoOZECNRE0 mapDtoInToRequestFormat(DTOIntExecutivesFilter dtoIn) {
        return txExecutiveMapper.mapInOznr(dtoIn);
    }

    @Override
    protected DTOIntExecutive mapResponseFormatToDtoOut(FormatoOZECNRS0 formatOutput, DTOIntExecutivesFilter dtoIn) {
        return txExecutiveMapper.mapOutOznr(formatOutput);
    }

    @Override
    protected InvocadorTransaccion<?, ?> getTransaction() {
        return transaccionOznr;
    }



}

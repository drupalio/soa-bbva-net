package com.bbva.czic.globalposition.dao.tx;

import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProductFilter;
import com.bbva.czic.globalposition.dao.mappers.ITxGlobalPositionMapper;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1E0;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1S0;
import com.bbva.czic.globalposition.dao.model.ozn1.TransaccionOzn1;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.ListBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Entelgy Colombia.
 */
@Component("tx-get-extract-global-balance-no-tc")
public class TxGetExtractGlobalBalanceNoTC extends ListBbvaTransaction<DTOIntProductFilter, FormatoOZECN1E0, DTOIntProduct, FormatoOZECN1S0> {

    @Autowired
    private transient TransaccionOzn1 transaccionOzn1;

    @Resource(name = "txGlobalPositionMapper")
    private transient ITxGlobalPositionMapper txGlobalPositionMapper;


    @Override
    protected FormatoOZECN1E0 mapDtoInToRequestFormat(DTOIntProductFilter dtoIn) {
        return txGlobalPositionMapper.mapInOzn1(dtoIn);
    }

    @Override
    protected DTOIntProduct mapResponseFormatToDtoOut(FormatoOZECN1S0 formatOutput, DTOIntProductFilter dtoIn) {
        return txGlobalPositionMapper.mapOutOzn1S0(formatOutput);
    }

    @Override
    protected InvocadorTransaccion<?, ?> getTransaction() {
        return transaccionOzn1;
    }
}

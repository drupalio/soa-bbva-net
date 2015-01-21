package com.bbva.czic.checkbooks.dao.mappers;

import com.bbva.czic.checkbooks.business.dto.DTOIntCheckbook;
import com.bbva.czic.checkbooks.dao.model.ozns.FormatoOZECNSE0;
import com.bbva.czic.checkbooks.dao.model.ozns.FormatoOZECNSS0;
import com.bbva.czic.dto.net.EnumCheckbookStatus;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("tx-get-checkbooks-mapper")
public class GetCheckbookMapper implements ISimpleTransactionMapper<DTOIntCheckbook, FormatoOZECNSE0, DTOIntCheckbook, FormatoOZECNSS0> {

    @Override
    public FormatoOZECNSE0 mapToInner(DTOIntCheckbook dtoIn) {
        FormatoOZECNSE0 formatoOZECNSE0 = new FormatoOZECNSE0();

        formatoOZECNSE0.setNumcheq(dtoIn.getId());

        return formatoOZECNSE0;
    }

    @Override
    public DTOIntCheckbook mapToOuter(FormatoOZECNSS0 outFormat, DTOIntCheckbook dtoIn) {

        final DTOIntCheckbook dtoIntCheckbook = new DTOIntCheckbook();

        dtoIntCheckbook.setId("12345");
        dtoIntCheckbook.setFirstCheck(new Integer("123"));
        dtoIntCheckbook.setLastCheck(new Integer("456"));
        dtoIntCheckbook.setTotalCheck(new Integer("5"));
        dtoIntCheckbook.setRequestDate(new Date());
        dtoIntCheckbook.setDeliveryDate(new Date());
        dtoIntCheckbook.setActualState(EnumCheckbookStatus.HABILITADO);

        return dtoIntCheckbook;
    }
}



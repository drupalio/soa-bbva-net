package com.bbva.czic.checkbooks.dao.mappers;

import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.dao.model.ozny.FormatoOZECNYE0;
import com.bbva.czic.checkbooks.dao.model.ozny.FormatoOZECNYS0;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;

public class GetCheckMapper implements ISimpleTransactionMapper<DTOIntCheck, FormatoOZECNYE0, DTOIntCheck, FormatoOZECNYS0> {

    @Override
    public FormatoOZECNYE0 mapToInner(DTOIntCheck dtoIn) {
        return null;
    }

    @Override
    public DTOIntCheck mapToOuter(FormatoOZECNYS0 outFormat, DTOIntCheck dtoIn) {
        return null;
    }
}

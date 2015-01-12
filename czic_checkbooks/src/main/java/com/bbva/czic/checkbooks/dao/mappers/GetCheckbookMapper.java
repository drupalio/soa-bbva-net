package com.bbva.czic.checkbooks.dao.mappers;

import com.bbva.czic.checkbooks.business.dto.DTOIntCheckbook;
import com.bbva.czic.checkbooks.dao.model.ozns.FormatoOZECNSE0;
import com.bbva.czic.checkbooks.dao.model.ozns.FormatoOZECNSS0;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;

public class GetCheckbookMapper implements ISimpleTransactionMapper<DTOIntCheckbook, FormatoOZECNSE0, DTOIntCheckbook, FormatoOZECNSS0> {

    @Override
    public FormatoOZECNSE0 mapToInner(DTOIntCheckbook dtoIn) {
        return null;
    }

    @Override
    public DTOIntCheckbook mapToOuter(FormatoOZECNSS0 outFormat, DTOIntCheckbook dtoIn) {
        return null;
    }
}

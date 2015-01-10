package com.bbva.czic.accounts.dao.mappers;

import com.bbva.czic.accounts.business.dto.DTOIntAccount;
import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCENA0;
import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCSNA0;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;

public class GetAccountMapper implements ISimpleTransactionMapper<DTOIntAccount,FormatoOZNCENA0,DTOIntAccount,FormatoOZNCSNA0>{

    @Override
    public FormatoOZNCENA0 mapToInner(DTOIntAccount dtoIn) {
        return null;
    }

    @Override
    public DTOIntAccount mapToOuter(FormatoOZNCSNA0 outFormat, DTOIntAccount dtoIn) {
        return null;
    }
}


package com.bbva.czic.accounts.dao.tx;

import com.bbva.czic.accounts.business.dto.DTOIntCheck;
import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.czic.accounts.business.dto.DTOIntResponseListCheck;
import com.bbva.czic.accounts.dao.model.oznx.*;
import com.bbva.czic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.czic.routine.commons.rm.utils.tx.IPaginatedTransactionMapper;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.PaginatedTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Entelgy on 14/01/2015.
 */
@Component("tx-list-Check-mapperc")
public class TxListCheck extends PaginatedTransaction<PeticionTransaccionOznx, RespuestaTransaccionOznx> {


    @Autowired
    private transient TransaccionOznx transaccionOznx;

    @Autowired
    @Qualifier("tx-listCheck-resume-mapper")
    private transient IPaginatedTransactionMapper<DTOIntFilterAccount, FormatoOZECNXE0, DTOIntResponseListCheck, IFormatNotApply, DTOIntCheck, FormatoOZECNXS0, IFormatNotApply> txGetAccountMovementResumeMapper;

    @Override
    protected InvocadorTransaccion<PeticionTransaccionOznx, RespuestaTransaccionOznx> getInvoker() {
        return null;
    }

    @Override
    protected <I, IF, O, OF, E, EOF, POF> IPaginatedTransactionMapper<I, IF, O, OF, E, EOF, POF> getMapper() {
        return null;
    }
}
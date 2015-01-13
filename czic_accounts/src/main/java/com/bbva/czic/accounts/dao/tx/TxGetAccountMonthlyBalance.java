package com.bbva.czic.accounts.dao.tx;

import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.czic.accounts.business.dto.DTOIntMonthlyBalances;
import com.bbva.czic.accounts.business.dto.DTOIntResponseMonthlyBalances;
import com.bbva.czic.accounts.dao.model.oznv.*;
import com.bbva.czic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.czic.routine.commons.rm.utils.tx.IPaginatedTransactionMapper;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.PaginatedTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Entelgy on 12/01/2015.
 */
@Component("tx-get-account-monthly-balance")
public class TxGetAccountMonthlyBalance extends PaginatedTransaction<PeticionTransaccionOznv,RespuestaTransaccionOznv> {
    @Autowired
    private transient TransaccionOznv transaccionOznv;

    @Autowired
    @Qualifier("tx-get-account-monthly-balance-mapper")
    private transient IPaginatedTransactionMapper<DTOIntFilterAccount, FormatoOZECNVE0, DTOIntResponseMonthlyBalances, IFormatNotApply, DTOIntMonthlyBalances, FormatoOZECNVS0, IFormatNotApply> txGetAccountMonthlyBalance;


    @Override
    protected InvocadorTransaccion<PeticionTransaccionOznv, RespuestaTransaccionOznv> getInvoker() {
        return transaccionOznv;
    }

    @Override
    protected IPaginatedTransactionMapper<DTOIntFilterAccount, FormatoOZECNVE0, DTOIntResponseMonthlyBalances, IFormatNotApply, DTOIntMonthlyBalances, FormatoOZECNVS0, IFormatNotApply> getMapper() {
        return txGetAccountMonthlyBalance;
    }
}

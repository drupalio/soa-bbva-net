package com.bbva.czic.loan.dao.tx;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.dao.mappers.impl.ITxLoanMapper;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCENJ0;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCSNJ0;
import com.bbva.czic.loan.dao.model.oznj.PeticionTransaccionOznj;
import com.bbva.czic.loan.dao.model.oznj.RespuestaTransaccionOznj;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
/**
* Created by Entelgy on 26/01/2015.
*/
@Component("tx-get-rotary-quota")
public class TxGetRotaryQuota extends SimpleBbvaTransaction<String, FormatoOZNCENJ0, DTOIntLoan, FormatoOZNCSNJ0> {

@Resource(name = "transaccionOznj")
private InvocadorTransaccion<PeticionTransaccionOznj, RespuestaTransaccionOznj> transaccionOznj;

@Resource(name = "tx-loan-mapper")
private ITxLoanMapper iTxLoanMapper;

    /**
     *
     * @param idLoan
     * @return
     */
    @Override
    protected FormatoOZNCENJ0 mapDtoInToRequestFormat(String idLoan) {
        FormatoOZNCENJ0 formatoOZNCENJ0 = new FormatoOZNCENJ0();
        formatoOZNCENJ0.setNomtarj(idLoan);
        return formatoOZNCENJ0;
    }

    /**
     *
     * @param formatOutput
     * @param dtoIn
     * @return
     */
    @Override
    protected DTOIntLoan mapResponseFormatToDtoOut(FormatoOZNCSNJ0 formatOutput, String dtoIn) {
        return iTxLoanMapper.mapOutOznj(formatOutput);
    }

    /**
     *
     * @return
     */
    @Override
    protected InvocadorTransaccion<?, ?> getTransaction() {
        return transaccionOznj;
    }
}
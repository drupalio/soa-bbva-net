package com.bbva.czic.loan.dao.tx;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.bbva.czic.loan.business.dto.DTOIntFilterLoan;
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
public class TxGetRotaryQuota extends
SimpleBbvaTransaction<DTOIntFilterLoan, FormatoOZNCENJ0, DTOIntLoan, FormatoOZNCSNJ0> {
@Resource(name = "transaccionOznj")
private InvocadorTransaccion<PeticionTransaccionOznj, RespuestaTransaccionOznj> transaccionOznj;
@Resource(name = "tx-loan-mapper")
private ITxLoanMapper iTxLoanMapper;
@Override
protected FormatoOZNCENJ0 mapDtoInToRequestFormat(DTOIntFilterLoan dtoIn) {
return iTxLoanMapper.mapInOznj(dtoIn);
}
@Override
protected DTOIntLoan mapResponseFormatToDtoOut(FormatoOZNCSNJ0 formatOutput, DTOIntFilterLoan dtoIn) {
return iTxLoanMapper.mapOutOznj(formatOutput);
}
@Override
protected InvocadorTransaccion<?, ?> getTransaction() {
return transaccionOznj;
}
}
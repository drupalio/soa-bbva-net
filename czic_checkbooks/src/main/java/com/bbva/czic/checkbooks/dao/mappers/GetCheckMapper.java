package com.bbva.czic.checkbooks.dao.mappers;

import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.dao.model.ozny.FormatoOZECNYE0;
import com.bbva.czic.checkbooks.dao.model.ozny.FormatoOZECNYS0;
import com.bbva.czic.dto.net.EnumCheckStatus;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Currency;

@Component(value = "tx-get-checks-mapper")
public class GetCheckMapper implements ISimpleTransactionMapper<DTOIntCheck, FormatoOZECNYE0, DTOIntCheck, FormatoOZECNYS0> {

    @Value("${locale.default.currency.iso}")
    private String CURRENCY;

    @Override
    public FormatoOZECNYE0 mapToInner(DTOIntCheck dtoIn) {

        final FormatoOZECNYE0 formatoOZECNYE0 = new FormatoOZECNYE0();

        formatoOZECNYE0.setNumcheq(dtoIn.getId());

        return formatoOZECNYE0;
    }

    @Override
    public DTOIntCheck mapToOuter(FormatoOZECNYS0 outFormat, DTOIntCheck dtoIn) {
        final DTOIntCheck intCheck = new DTOIntCheck();

        intCheck.setId(outFormat.getNumcheq());
        intCheck.setIssueDate(outFormat.getFechemi());
        intCheck.setValue(new Money(Currency.getInstance(CURRENCY), outFormat.getValcheq()));
        intCheck.setStatus(EnumCheckStatus.valueOf(outFormat.getEstcheq()));
        intCheck.setModifiedDate(outFormat.getFechmod());

        return intCheck;
    }
}

package com.bbva.czic.accounts.dao.mappers;

import com.bbva.czic.accounts.business.dto.DTOIntCheck;
import com.bbva.czic.accounts.business.dto.DTOIntResponseListCheck;
import com.bbva.czic.accounts.dao.model.oznx.FormatoOZECNXE0;
import com.bbva.czic.accounts.dao.model.oznx.FormatoOZECNXS0;
import com.bbva.czic.dto.net.EnumCheckStatus;
import com.bbva.czic.routine.commons.rm.utils.CurrencyEnum;
import com.bbva.czic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.czic.routine.commons.rm.utils.tx.IPaginatedTransactionMapper;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Currency;

/**
 * Created by user on 16/01/2015.
 */
@Component("tx-list-check-mapper")
public class ListCheckMapper implements IPaginatedTransactionMapper<DTOIntCheck, FormatoOZECNXE0, DTOIntResponseListCheck, IFormatNotApply, DTOIntCheck, FormatoOZECNXS0, IFormatNotApply> {


    @Override
    public DTOIntCheck mapToInnerEntity(FormatoOZECNXS0 outFormat, DTOIntCheck dtoIn) {
        final DTOIntCheck intCheck = new DTOIntCheck();

        intCheck.setId(outFormat.getNumcheq());
        intCheck.setIssueDate(outFormat.getFechemi());
        intCheck.setValue(new Money(Currency.getInstance(CurrencyEnum.COP.toString()), outFormat.getValcheq()));
        intCheck.setStatus(EnumCheckStatus.valueOf(outFormat.getEstcheq()));
        intCheck.setModifiedDate(outFormat.getFechmod());

        return intCheck;
    }

    @Override
    public void addPaginationInfo(IFormatNotApply paginationOutFormat, DTOIntCheck dtoIn) {

    }

    @Override
    public boolean doIHaveToPaginate(DTOIntCheck dtoIn) {
        return false;
    }

    @Override
    public FormatoOZECNXE0 mapToInner(DTOIntCheck dtoIn) {
        FormatoOZECNXE0 formatoOZECNYE0 = new FormatoOZECNXE0();

        formatoOZECNYE0.setNumprod(dtoIn.getId().toString());
        formatoOZECNYE0.setIndpagi(dtoIn.getpaginationKey());
        formatoOZECNYE0.setFechini(dtoIn.getStartDate());
        formatoOZECNYE0.setFechfin(dtoIn.getEndDate());
        formatoOZECNYE0.setEstcheq(dtoIn.getStatus().toString());
        formatoOZECNYE0.setId(dtoIn.getId());

        return formatoOZECNYE0;
    }

    @Override
    public DTOIntResponseListCheck mapToOuter(IFormatNotApply outFormat, DTOIntCheck dtoIn) {
        final DTOIntResponseListCheck productsWrappers = new DTOIntResponseListCheck();
        productsWrappers.setListDTDtoIntChecks(new ArrayList<DTOIntCheck>());
        return productsWrappers;
    }
}

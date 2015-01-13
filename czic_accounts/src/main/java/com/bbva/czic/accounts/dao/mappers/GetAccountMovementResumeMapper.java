package com.bbva.czic.accounts.dao.mappers;

import com.bbva.czic.accounts.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.accounts.business.dto.DTOIntEnumMonth;
import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.czic.accounts.business.dto.DTOIntResponseAccMovementsResumes;
import com.bbva.czic.accounts.dao.model.oznu.FormatoOZECNUE0;
import com.bbva.czic.accounts.dao.model.oznu.FormatoOZECNUS0;
import com.bbva.czic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.czic.routine.commons.rm.utils.tx.IPaginatedTransactionMapper;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by Entelgy on 12/01/2015.
 */
@Component("tx-get-account-movement-resume-mapper")
public class GetAccountMovementResumeMapper    implements IPaginatedTransactionMapper<DTOIntFilterAccount, FormatoOZECNUE0, DTOIntResponseAccMovementsResumes, IFormatNotApply, DTOIntAccMovementsResume, FormatoOZECNUS0, IFormatNotApply> {
    @Override
    public DTOIntAccMovementsResume mapToInnerEntity(FormatoOZECNUS0 outFormat, DTOIntFilterAccount dtoIn) {
        DTOIntAccMovementsResume dtoIntAccMovementsResume = new DTOIntAccMovementsResume();
        DTOIntEnumMonth dtoIntEnumMonth = new DTOIntEnumMonth();
        dtoIntEnumMonth.setMes(outFormat.getMes());
        dtoIntAccMovementsResume.setMonth(dtoIntEnumMonth);
        Money balance = new Money();
        balance.setAmount(outFormat.getSaldtot());
        Money inCome = new Money();
        inCome.setAmount(outFormat.getValdepo());
        Money outCome = new Money();
        outCome.setAmount(outFormat.getValcarg());

        dtoIntAccMovementsResume.setBalance(balance);
        dtoIntAccMovementsResume.setIncome(inCome);
        dtoIntAccMovementsResume.setOutcome(outCome);

        return dtoIntAccMovementsResume;
    }

    @Override
    public void addPaginationInfo(IFormatNotApply paginationOutFormat, DTOIntFilterAccount dtoIn) {

    }

    @Override
    public boolean doIHaveToPaginate(DTOIntFilterAccount dtoIn) {
        return false;
    }

    @Override
    public FormatoOZECNUE0 mapToInner(DTOIntFilterAccount dtoIn) {
        FormatoOZECNUE0 formatoEntrada = new FormatoOZECNUE0();
        //Dado que se usa el mismo mapeador del smc de monthly balance, el valida cuando es month==ge lo setea en la variable starDate
        formatoEntrada.setIntervm(dtoIn.getStartMonth().toString());
        formatoEntrada.setNumprod(dtoIn.getAccountId());
        return formatoEntrada;
    }

    @Override
    public DTOIntResponseAccMovementsResumes mapToOuter(IFormatNotApply outFormat, DTOIntFilterAccount dtoIn) {
        final DTOIntResponseAccMovementsResumes productsWrappers = new DTOIntResponseAccMovementsResumes();
        productsWrappers.setListDTOIntAccMovementsResume(new ArrayList<DTOIntAccMovementsResume>());
        return productsWrappers;
    }
}

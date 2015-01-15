package com.bbva.czic.accounts.dao.mappers;

import com.bbva.czic.accounts.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.accounts.business.dto.DTOIntEnumMonth;
import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.czic.accounts.business.dto.DTOIntResponseAccMovementsResumes;
import com.bbva.czic.accounts.dao.model.oznu.FormatoOZECNUE0;
import com.bbva.czic.accounts.dao.model.oznu.FormatoOZECNUS0;
import com.bbva.czic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Entelgy on 13/01/2015.
 */
public class GetAccountMovementResumeMapperTest {



    GetAccountMovementResumeMapper getAccountMovementResumeMapper;

    @Before
    public void init() {
        getAccountMovementResumeMapper = new GetAccountMovementResumeMapper();
    }

    @Test
    public void mapToInnerEntityTest() {
        FormatoOZECNUS0 outFormat = new FormatoOZECNUS0();
        outFormat.setMes("Enero");
        outFormat.setSaldtot(new BigDecimal("1500"));
        outFormat.setValcarg(new BigDecimal("1000"));
        outFormat.setValdepo(new BigDecimal("500"));

        DTOIntAccMovementsResume dtoIntAccMovementsResume = new DTOIntAccMovementsResume();
        dtoIntAccMovementsResume = getAccountMovementResumeMapper.mapToInnerEntity(outFormat,null);

        assertEquals(outFormat.getMes().toString(),dtoIntAccMovementsResume.getMonth().getMes());
        assertEquals(outFormat.getSaldtot(),dtoIntAccMovementsResume.getBalance().getAmount());
        assertEquals(outFormat.getValcarg(),dtoIntAccMovementsResume.getOutcome().getAmount());
        assertEquals(outFormat.getValdepo(),dtoIntAccMovementsResume.getIncome().getAmount());

    }

    @Test
    public void doIHaveToPaginateTest() {
        assertFalse(getAccountMovementResumeMapper.doIHaveToPaginate(null));
    }

    @Test
    public void mapToInnerTest() {

        DTOIntFilterAccount dtoIntFilterAccount = new DTOIntFilterAccount();
        dtoIntFilterAccount.setEndMonth(new Date());
        dtoIntFilterAccount.setStartMonth(new Date());
        dtoIntFilterAccount.setAccountId("102030");
        dtoIntFilterAccount.setMonth("Enero");

        FormatoOZECNUE0 formatoEntrada = new FormatoOZECNUE0();
        formatoEntrada = getAccountMovementResumeMapper.mapToInner(dtoIntFilterAccount);

        assertEquals(dtoIntFilterAccount.getAccountId(),formatoEntrada.getNumprod());
        //Dado que se usa el mismo mapeador del smc de monthly balance, el valida cuando es month==ge lo setea en la variable starDate
        assertEquals(dtoIntFilterAccount.getStartMonth().toString(),formatoEntrada.getIntervm());
    }

    @Test
    public void mapToOuter() {
        assertNotNull(getAccountMovementResumeMapper.mapToOuter(null, null));
    }
}

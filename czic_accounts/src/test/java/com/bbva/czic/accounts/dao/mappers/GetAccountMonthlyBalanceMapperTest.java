package com.bbva.czic.accounts.dao.mappers;

import com.bbva.czic.accounts.business.dto.DTOIntEnumMonth;
import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.czic.accounts.business.dto.DTOIntMonthlyBalances;
import com.bbva.czic.accounts.business.dto.DTOIntResponseMonthlyBalances;
import com.bbva.czic.accounts.dao.model.oznv.FormatoOZECNVE0;
import com.bbva.czic.accounts.dao.model.oznv.FormatoOZECNVS0;
import com.bbva.czic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Component;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Entelgy on 13/01/2015.
 */
public class GetAccountMonthlyBalanceMapperTest {


   GetAccountMonthlyBalanceMapper getAccountMonthlyBalanceMapper;

    @Before
    public void init() {
        getAccountMonthlyBalanceMapper = new GetAccountMonthlyBalanceMapper();
    }

    @Test
    public void mapToInnerEntityTest() {
         DTOIntMonthlyBalances dtoIntMonthlyBalances = new DTOIntMonthlyBalances();
        FormatoOZECNVS0 outFormat = new FormatoOZECNVS0();
        outFormat.setMes("11");
        outFormat.setSalddis(new BigDecimal("1500"));

        dtoIntMonthlyBalances = getAccountMonthlyBalanceMapper.mapToInnerEntity(outFormat,null);

   assertEquals(outFormat.getMes(),dtoIntMonthlyBalances.getMonth().getMes());
        assertEquals(outFormat.getSalddis(),dtoIntMonthlyBalances.getBalance().getAmount());
    }


    @Test
    public void mapToInnerTest() {

        DTOIntFilterAccount dtoIntFilterAccount = new DTOIntFilterAccount();
        dtoIntFilterAccount.setEndMonth(new Date());
        dtoIntFilterAccount.setStartMonth(new Date());
        dtoIntFilterAccount.setAccountId("102030");
        dtoIntFilterAccount.setMonth("Enero");

        FormatoOZECNVE0 formatoEntrada =getAccountMonthlyBalanceMapper.mapToInner(dtoIntFilterAccount);

        assertEquals(dtoIntFilterAccount.getEndMonth().toString(),formatoEntrada.getMesfin());
        assertEquals(dtoIntFilterAccount.getStartMonth().toString(),formatoEntrada.getMesini());
        assertEquals(dtoIntFilterAccount.getAccountId(),formatoEntrada.getNumcta());

    }

    @Test
    public void mapToOuterTest() {
      assertNotNull(getAccountMonthlyBalanceMapper.mapToOuter(null, null));
    }

    @Test
    public void doIHaveToPaginateTest() {
        assertTrue(!getAccountMonthlyBalanceMapper.doIHaveToPaginate(null));
    }
}

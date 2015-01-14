package com.bbva.czic.accounts.dao.mappers;

import com.bbva.czic.accounts.business.dto.DTOIntAccount;
import com.bbva.czic.accounts.business.dto.DTOIntBalance;
import com.bbva.czic.accounts.business.dto.DTOIntCheckbook;
import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCENA0;
import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCSNA0;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Entelgy on 13/01/2015.
 */
public class GetAccountMapperTest {

    GetAccountMapper getAccountMapper;

    @Before
    public void init() {
        getAccountMapper = new GetAccountMapper();
    }

    @Test
    public void mapToInnerTest() {
        DTOIntAccount dtoIntAccount = new DTOIntAccount();
        dtoIntAccount.setName("Nombre Test");
        dtoIntAccount.setBalance(new DTOIntBalance());
        dtoIntAccount.setIdAccount("010203");
        dtoIntAccount.setType("Tipo 1");
        dtoIntAccount.setListaCheckBook(new ArrayList<DTOIntCheckbook>());

        FormatoOZNCENA0 formatoEntrada = getAccountMapper.mapToInner(dtoIntAccount);

        assertEquals(dtoIntAccount.getIdAccount(),formatoEntrada.getNumprod());

    }

    @Test
    public void mapToOuterTest() {

        FormatoOZNCSNA0 outFormat = new FormatoOZNCSNA0();
        outFormat.setTipprod("Tipo producto");
        outFormat.setSddispo(new BigDecimal("1000"));
        outFormat.setSdcanje(new BigDecimal("500"));
        outFormat.setNumprod("12345");
        outFormat.setNomprod("Mi producto");
        outFormat.setSaltota(new BigDecimal("1500"));
        outFormat.setIdcheq0("10001");
        outFormat.setIdcheq1("10002");

        DTOIntAccount formatoSalida = getAccountMapper.mapToOuter(outFormat,null);

        assertEquals(outFormat.getTipprod(),formatoSalida.getType());
        assertEquals(outFormat.getSddispo(),formatoSalida.getBalance().getAvailableBalance().getAmount());
        assertEquals(outFormat.getSdcanje(),formatoSalida.getBalance().getTradeBalance().getAmount());
        assertEquals(outFormat.getNumprod(),formatoSalida.getIdAccount());
        assertEquals(outFormat.getNomprod(),formatoSalida.getName());
        assertEquals(outFormat.getSaltota(),formatoSalida.getBalance().getTotal().getAmount());
        assertNotNull(formatoSalida.getListaCheckBook().get(0));
        assertNotNull(formatoSalida.getListaCheckBook().get(1));
    }

}

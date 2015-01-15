package com.bbva.czic.accounts.facade.v01.mapper.impl;

import com.bbva.czic.accounts.business.dto.*;
import com.bbva.czic.accounts.dao.mappers.GetAccountMapper;
import com.bbva.czic.accounts.facade.v01.mappers.impl.AccountsMapper;
import com.bbva.czic.dto.net.*;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Entelgy on 13/01/2015.
 */
public class AccountsMapperTest {


    AccountsMapper accountsMapper;

    @Before
    public void init() {
        accountsMapper = new AccountsMapper();
    }



    /**
     * Metodo encargado de mapear un DTO interno de tipo DTOIntAccount a un DTO externo de tipo Account
     * @author David Tafur
     * @return
     */
    @Test
    public void mapTest() {

        Account account = new Account();

        DTOIntAccount dtoIntAccount = new DTOIntAccount();
        dtoIntAccount.setIdAccount("100200300400");
        dtoIntAccount.setName("Nombre cuenta");
        DTOIntBalance dtoIntBalance = new DTOIntBalance();
        Money money = new Money();
        money.setAmount(new BigDecimal("1000"));
        dtoIntBalance.setTotal(new Money());
        dtoIntAccount.setBalance(dtoIntBalance);
        dtoIntAccount.setListaCheckBook(new ArrayList<DTOIntCheckbook>());

        account=accountsMapper.map(dtoIntAccount);
        assertEquals(dtoIntAccount.getName(),account.getName());
        assertEquals(dtoIntAccount.getIdAccount(),account.getId());
        assertEquals(dtoIntAccount.getBalance().getTotal(),account.getBalance().getTotal());
        assertNotNull(dtoIntAccount.getListaCheckBook());
    }

    /**
     * Metodo encargado de mapear una lista de tipo DTOIntCheckbook a una lista Checkbook
     * @author David Tafur
     * @return
     */
    @Test
    public void mapLCheckbookTest(){
        List<DTOIntCheckbook> listaDTOIntCheckbook = new ArrayList<DTOIntCheckbook>();
        List<Checkbook> listaCheckbook = new ArrayList<Checkbook>();

        DTOIntCheckbook dtoIntCheckbook = new DTOIntCheckbook();
        dtoIntCheckbook.setId("010203");
        dtoIntCheckbook.setDeliveryDate(new Date());
        dtoIntCheckbook.setActualState(DTOIntEnumCheckbookStatus.HABILITADO);
        dtoIntCheckbook.setFirstCheck(10);
        dtoIntCheckbook.setLastCheckl(11);
        dtoIntCheckbook.setRequestDate(new Date());
        dtoIntCheckbook.setTotalCheck(12);


        listaDTOIntCheckbook.add(dtoIntCheckbook);
        listaDTOIntCheckbook.add(dtoIntCheckbook);

        listaCheckbook = accountsMapper.mapLCheckbook(listaDTOIntCheckbook);

        assertNotNull(listaCheckbook);
        assertTrue(listaCheckbook.size()==2);
        assertEquals(dtoIntCheckbook.getId(),listaCheckbook.get(0).getId());
        assertEquals(dtoIntCheckbook.getDeliveryDate(),listaCheckbook.get(0).getDeliveryDate().getTime());
        assertEquals(dtoIntCheckbook.getActualState().toString(),listaCheckbook.get(0).getActualState().toString());
        assertEquals(dtoIntCheckbook.getFirstCheck(),listaCheckbook.get(0).getFirstCheck());
        assertEquals(dtoIntCheckbook.getLastCheckl(),listaCheckbook.get(0).getLastCheck());
        assertEquals(dtoIntCheckbook.getRequestDate(),listaCheckbook.get(0).getRequestDate().getTime());
        assertEquals(dtoIntCheckbook.getTotalCheck(),listaCheckbook.get(0).getTotalCheck());


    }

    /**
     * Metodo encargado de mapear una lista de tipo DTOIntMonthlyBalances a una lista MonthlyBalances
     * @author David Tafur
     * @return
     */
    @Test
    public void mapLTest(){
        List<DTOIntMonthlyBalances> listaDtoIntMonthlyBalances = new ArrayList<DTOIntMonthlyBalances>();
        List<MonthlyBalances> listaMonthlyBalance = new ArrayList<MonthlyBalances>();

        DTOIntMonthlyBalances dtoIntMonthlyBalances = new DTOIntMonthlyBalances();
        DTOIntEnumMonth dtoIntEnumMonth = new DTOIntEnumMonth();
        dtoIntEnumMonth.setMes("JANUARY");
        dtoIntMonthlyBalances.setMonth(dtoIntEnumMonth);
        Money money = new Money();
        money.setAmount(new BigDecimal("100"));
        dtoIntMonthlyBalances.setBalance(money);

        listaDtoIntMonthlyBalances.add(dtoIntMonthlyBalances);
        listaDtoIntMonthlyBalances.add(dtoIntMonthlyBalances);

        listaMonthlyBalance = accountsMapper.mapL(listaDtoIntMonthlyBalances);

        assertNotNull(listaMonthlyBalance);
        assertTrue(listaMonthlyBalance.size() == 2);
        assertEquals(listaMonthlyBalance.get(0).getMonth().toString(),dtoIntMonthlyBalances.getMonth().getMes());
        assertEquals(listaMonthlyBalance.get(0).getBalance().getAmount(),dtoIntMonthlyBalances.getBalance().getAmount());
    }

    /**
     * Metodo encargado de mapear una lista de DTO internos de tipo DTOIntAccMovementsResume, a una lista de DTO de tipo AccMovementsResume
     *@author David Tafur
     * @return
     */
    @Test
    public void mapListDTOIntAccMovementResumeToListAccMovementsResume(){
        List<AccMovementsResume> listaAccMovementResume = new ArrayList<AccMovementsResume>();
        List<DTOIntAccMovementsResume> listaDTOIntAccMovementsResume = new ArrayList<DTOIntAccMovementsResume>();

        Money balance = new Money();
        balance.setAmount(new BigDecimal("1000"));
        Money income = new Money();
        income.setAmount(new BigDecimal("800"));
        Money outcome = new Money();
        outcome.setAmount(new BigDecimal("500"));
        DTOIntAccMovementsResume dtoIntAccMovementsResume = new DTOIntAccMovementsResume();
        dtoIntAccMovementsResume.setOutcome(outcome);
        dtoIntAccMovementsResume.setBalance(balance);
        dtoIntAccMovementsResume.setIncome(income);
        DTOIntEnumMonth dtoIntEnumMonth = new DTOIntEnumMonth();
        dtoIntEnumMonth.setMes("JANUARY");
        dtoIntAccMovementsResume.setMonth(dtoIntEnumMonth);

        listaDTOIntAccMovementsResume.add(dtoIntAccMovementsResume);
        listaDTOIntAccMovementsResume.add(dtoIntAccMovementsResume);

        listaAccMovementResume = accountsMapper.map(listaDTOIntAccMovementsResume);

        assertNotNull(listaAccMovementResume);
        assertTrue(listaAccMovementResume.size()==2);
        assertEquals(listaDTOIntAccMovementsResume.get(0).getOutcome().getAmount(),dtoIntAccMovementsResume.getOutcome().getAmount());
        assertEquals(listaDTOIntAccMovementsResume.get(0).getBalance().getAmount(),dtoIntAccMovementsResume.getBalance().getAmount());
        assertEquals(listaDTOIntAccMovementsResume.get(0).getIncome().getAmount(),dtoIntAccMovementsResume.getIncome().getAmount());
        assertEquals(listaDTOIntAccMovementsResume.get(0).getMonth().getMes(),dtoIntAccMovementsResume.getMonth().getMes());
    }


}

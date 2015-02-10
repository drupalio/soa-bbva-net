package com.bbva.czic.accounts.facade.v01.mapper.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.bbva.czic.accounts.business.dto.*;
import com.bbva.czic.accounts.facade.v01.mappers.IAccountsMapper;
import org.junit.Before;
import org.junit.Test;

import com.bbva.czic.accounts.facade.v01.mappers.impl.AccountsMapper;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.Account;
import com.bbva.czic.dto.net.MonthlyBalances;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

/**
 * Created by Entelgy on 13/01/2015.
 */
public class AccountsMapperTest {

	IAccountsMapper accountsMapper;

	@Before
	public void init() {
		accountsMapper = new AccountsMapper();
	}


	@Test
	public void testGetDTOIntFilter(){
		final String testFilter = "(month=ge=112014;month=le=022015)";

		final DTOIntFilterAccount dtoFilter =  accountsMapper.getDTOIntFilter(anyString(), testFilter);

		assertNotNull( dtoFilter);
	}

	/**
	 * Metodo encargado de mapear un DTO interno de tipo DTOIntAccount a un DTO externo de tipo Account
	 * 
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

		account = accountsMapper.map(dtoIntAccount);
		assertEquals(dtoIntAccount.getName(), account.getName());
		assertEquals(dtoIntAccount.getIdAccount(), account.getId());
		assertEquals(dtoIntAccount.getBalance().getTotal(), account.getBalance().getTotal());
		assertNotNull(dtoIntAccount.getListaCheckBook());
	}

	/**
	 * Metodo encargado de mapear una lista de tipo DTOIntMonthlyBalances a una lista MonthlyBalances
	 * 
	 * @author David Tafur
	 * @return
	 */
	@Test
	public void mapLTest() {
		List<DTOIntMonthlyBalances> listaDtoIntMonthlyBalances = new ArrayList<DTOIntMonthlyBalances>();
		List<MonthlyBalances> listaMonthlyBalance = new ArrayList<MonthlyBalances>();

		DTOIntMonthlyBalances dtoIntMonthlyBalances = new DTOIntMonthlyBalances();
		dtoIntMonthlyBalances.setMonth("JANUARY");
		Money money = new Money();
		money.setAmount(new BigDecimal("100"));
		dtoIntMonthlyBalances.setBalance(money);

		listaDtoIntMonthlyBalances.add(dtoIntMonthlyBalances);
		listaDtoIntMonthlyBalances.add(dtoIntMonthlyBalances);

		listaMonthlyBalance = accountsMapper.mapL(listaDtoIntMonthlyBalances);

		assertNotNull(listaMonthlyBalance);
		assertTrue(listaMonthlyBalance.size() == 2);
		//assertEquals(listaMonthlyBalance.get(0).getMonth().toString(), dtoIntMonthlyBalances.getMonth().getMes());
		assertEquals(listaMonthlyBalance.get(0).getBalance().getAmount(), dtoIntMonthlyBalances.getBalance()
				.getAmount());
	}

	/**
	 * Metodo encargado de mapear una lista de DTO internos de tipo DTOIntAccMovementsResume, a una lista de DTO de tipo
	 * AccMovementsResume
	 *
	 * @author David Tafur
	 * @return
	 */
	@Test
	public void mapListDTOIntAccMovementResumeToListAccMovementsResume() {
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
		dtoIntAccMovementsResume.setMonth("JANUARY");

		listaDTOIntAccMovementsResume.add(dtoIntAccMovementsResume);
		listaDTOIntAccMovementsResume.add(dtoIntAccMovementsResume);

		listaAccMovementResume = accountsMapper.map(listaDTOIntAccMovementsResume);

		assertNotNull(listaAccMovementResume);
		assertTrue(listaAccMovementResume.size() == 2);
		assertEquals(listaDTOIntAccMovementsResume.get(0).getOutcome().getAmount(), dtoIntAccMovementsResume
				.getOutcome().getAmount());
		assertEquals(listaDTOIntAccMovementsResume.get(0).getBalance().getAmount(), dtoIntAccMovementsResume
				.getBalance().getAmount());
		assertEquals(listaDTOIntAccMovementsResume.get(0).getIncome().getAmount(), dtoIntAccMovementsResume.getIncome()
				.getAmount());
		assertEquals(listaDTOIntAccMovementsResume.get(0).getMonth(), dtoIntAccMovementsResume.getMonth()
 				);
	}

	/**
	 * Metodo encargado de mapear una lista de DTO internos de tipo DTOIntCheck, a una lista de DTO de tipo ListCheck
	 *
	 * @author Cristian Rojas
	 * @return
	 */
	@Test
	public void testMapDtoIntCheckToCheck() {

		/**
		 * final Check check = new Check(); final DTOIntCheck intCheck = new DTOIntCheck(); intCheck.setId("123");
		 * intCheck.setIssueDate(new Date()); intCheck.setValue(new Money(java.util.Currency.getInstance("COP"), new
		 * BigDecimal(12341234))); intCheck.setStatus(EnumCheckStatus.HABILITADO); intCheck.setModifiedDate(new Date());
		 * List<Check> checks = new ArrayList<Check>(); checks.add(check); check = accountsMapper.mapChecks(checks);
		 * assertEquals(intCheck.getId(),check.getId());
		 * assertEquals(intCheck.getIssueDate(),check.getIssueDate().getTime());
		 * assertEquals(intCheck.getValue(),check.getValue()); assertEquals(intCheck.getStatus(),check.getStatus());
		 * assertEquals(intCheck.getModifiedDate(),check.getModifiedDate().getTime());
		 **/

	}

}

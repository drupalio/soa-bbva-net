package com.bbva.czic.accounts.facade.v01.mappers.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;

import com.bbva.czic.accounts.business.dto.*;
import com.bbva.czic.accounts.facade.v01.mappers.IAccountsMapper;
import com.bbva.czic.dto.net.*;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Before;
import org.junit.Test;

import com.bbva.czic.accounts.facade.v01.mappers.impl.AccountsMapper;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

/**
 * Created by Entelgy on 13/01/2015.
 */
public class AccountsMapperTest extends SpringContextBbvaTest {

	AccountsMapper accountsMapper;

	private static final DataFactory dataFactory = new DataFactory();

	@Before
	public void init() {
		accountsMapper = new AccountsMapper();
	}


	@Test
	public void testGetDTOIntFilter(){
		final String testFilter = "(month=ge=112014;month=le=022015)";

		final DTOIntFilterAccount dtoFilter =  accountsMapper.getDTOIntFilter("651651", testFilter);

		assertNotNull( dtoFilter);
	}

	@Test(expected = BusinessServiceException.class)
	public void testGetDtoIntFilterChecksFilterBadValues(){
		final String testFilter = "(issueDate=ge=2015-01;issueDate=le=2015-02)";
		accountsMapper.getDtoIntFilterChecks("6126156", testFilter, 1, 2);
	}

	@Test
	public void testGetDtoIntFilterChecksFilter(){
		final String testFilter = "(month=ge=112014;month=le=022015)";
		final DTOIntFilterChecks dtoFilter =  accountsMapper.getDtoIntFilterChecks("651615", testFilter, 1, 10);
		assertNotNull(dtoFilter);
	}

	@Test
	public void testGetDtoIntFilterMovResumes(){
		final String testFilter = "(month=ge=02)";
		final DTOIntFilterMovResumes dtoFilter =  accountsMapper.getDtoIntFilterMovResumes("651615", testFilter);
		assertNotNull(dtoFilter);
	}

	@Test
	public void testGetDtoIntCheckbook(){
		final DTOIntFilterCheckbooks dtoFilter =  accountsMapper.getDtoIntCheckbook("651615", "654612");
		assertNotNull(dtoFilter);
	}

	@Test
	public void testMapToAccount(){
		final Account account = accountsMapper.map(mockDtoIntAccount());
		assertNotNull(account);
		assertNotNull(account.getId());
		assertNotNull(account.getCheckbooks());
		assertNotNull(account.getBalance());
		assertNotNull(account.getName());
		assertNotNull(account.getType());
	}

	@Test
	public void testMapChecks(){
		final List<Check> checks =  accountsMapper.mapChecks(mockDtoIntChecks(10));

		assertNotNull(checks);
		assertTrue(checks.size() == 10);
	}

	@Test
	public void testMapL(){
		final List<DTOIntMonthlyBalances> monthlyBalances = mockDTOIntMonthlyBalances(5);

		final List<MonthlyBalances> monthlyBalanceses = accountsMapper.mapL(monthlyBalances);

		assertNotNull(monthlyBalances);
		assertTrue(monthlyBalances.size() == 5);
	}

	@Test
	public void testMapToAccountMovementsResume(){
		final List<DTOIntAccMovementsResume> movementsResumeList = mockDtoIntAccMovementsResume();

		final List<AccMovementsResume> movementsResumes = accountsMapper.map(movementsResumeList);

		assertNotNull(movementsResumes);
		assertTrue(movementsResumes.size() == 12);

	}

	@Test
	public void testMapToCheck(){

		final DTOIntCheck dtoIntCheck = mockDtoIntChecks(1).get(0);

		final Check check = accountsMapper.map(dtoIntCheck);

		assertNotNull(check);
		assertNotNull(check.getId());
		assertNotNull(check.getIssueDate());
		assertNotNull(check.getValue());
	}

	@Test
	public void testMapCheckbooks(){

		final List<DTOIntCheckbook> dtoIntCheckbook = mockDtoIntCheckbookList();

		final List<Checkbook> checkbook = accountsMapper.mapCheckbooks(dtoIntCheckbook);

		assertNotNull(checkbook);
		assertNotNull(checkbook.get(0).getId());
	}

	@Test
	public void testGetDTOIntFilterChecks(){
		final DTOIntCheckFilter filter = accountsMapper.getDTOIntFilterChecks("12346", "123456");

		assertNotNull(filter);
		assertNotNull(filter.getAccountId());
	}

	/**
	 * Metodo encargado de mapear un DTO interno de tipo DTOIntAccount a un DTO externo de tipo Account
	 * 
	 * @author David Tafur
	 * @return
	 */
//	@Test
//	public void mapTest() {
//
//		Account account = new Account();
//
//		DTOIntAccount dtoIntAccount = new DTOIntAccount();
//		dtoIntAccount.setIdAccount("100200300400");
//		dtoIntAccount.setName("Nombre cuenta");
//		DTOIntBalance dtoIntBalance = new DTOIntBalance();
//		Money money = new Money();
//		money.setAmount(new BigDecimal("1000"));
//		dtoIntBalance.setTotal(new Money());
//		dtoIntAccount.setBalance(dtoIntBalance);
//		dtoIntAccount.setListaCheckBook(new ArrayList<DTOIntCheckbook>());
//
//		account = accountsMapper.map(dtoIntAccount);
//		assertEquals(dtoIntAccount.getName(), account.getName());
//		assertEquals(dtoIntAccount.getIdAccount(), account.getId());
//		assertEquals(dtoIntAccount.getBalance().getTotal(), account.getBalance().getTotal());
//		assertNotNull(dtoIntAccount.getListaCheckBook());
//	}
//
//	/**
//	 * Metodo encargado de mapear una lista de tipo DTOIntMonthlyBalances a una lista MonthlyBalances
//	 *
//	 * @author David Tafur
//	 * @return
//	 */
//	@Test
//	public void mapLTest() {
//		List<DTOIntMonthlyBalances> listaDtoIntMonthlyBalances = new ArrayList<DTOIntMonthlyBalances>();
//		List<MonthlyBalances> listaMonthlyBalance = new ArrayList<MonthlyBalances>();
//
//		DTOIntMonthlyBalances dtoIntMonthlyBalances = new DTOIntMonthlyBalances();
//		dtoIntMonthlyBalances.setMonth("JANUARY");
//		Money money = new Money();
//		money.setAmount(new BigDecimal("100"));
//		dtoIntMonthlyBalances.setBalance(money);
//
//		listaDtoIntMonthlyBalances.add(dtoIntMonthlyBalances);
//		listaDtoIntMonthlyBalances.add(dtoIntMonthlyBalances);
//
//		listaMonthlyBalance = accountsMapper.mapL(listaDtoIntMonthlyBalances);
//
//		assertNotNull(listaMonthlyBalance);
//		assertTrue(listaMonthlyBalance.size() == 2);
//		//assertEquals(listaMonthlyBalance.get(0).getMonth().toString(), dtoIntMonthlyBalances.getMonth().getMes());
//		assertEquals(listaMonthlyBalance.get(0).getBalance().getAmount(), dtoIntMonthlyBalances.getBalance()
//				.getAmount());
//	}
//
//	/**
//	 * Metodo encargado de mapear una lista de DTO internos de tipo DTOIntAccMovementsResume, a una lista de DTO de tipo
//	 * AccMovementsResume
//	 *
//	 * @author David Tafur
//	 * @return
//	 */
//	@Test
//	public void mapListDTOIntAccMovementResumeToListAccMovementsResume() {
//		List<AccMovementsResume> listaAccMovementResume = new ArrayList<AccMovementsResume>();
//		List<DTOIntAccMovementsResume> listaDTOIntAccMovementsResume = new ArrayList<DTOIntAccMovementsResume>();
//
//		Money balance = new Money();
//		balance.setAmount(new BigDecimal("1000"));
//		Money income = new Money();
//		income.setAmount(new BigDecimal("800"));
//		Money outcome = new Money();
//		outcome.setAmount(new BigDecimal("500"));
//		DTOIntAccMovementsResume dtoIntAccMovementsResume = new DTOIntAccMovementsResume();
//		dtoIntAccMovementsResume.setOutcome(outcome);
//		dtoIntAccMovementsResume.setBalance(balance);
//		dtoIntAccMovementsResume.setIncome(income);
//		dtoIntAccMovementsResume.setMonth("JANUARY");
//
//		listaDTOIntAccMovementsResume.add(dtoIntAccMovementsResume);
//		listaDTOIntAccMovementsResume.add(dtoIntAccMovementsResume);
//
//		listaAccMovementResume = accountsMapper.map(listaDTOIntAccMovementsResume);
//
//		assertNotNull(listaAccMovementResume);
//		assertTrue(listaAccMovementResume.size() == 2);
//		assertEquals(listaDTOIntAccMovementsResume.get(0).getOutcome().getAmount(), dtoIntAccMovementsResume
//				.getOutcome().getAmount());
//		assertEquals(listaDTOIntAccMovementsResume.get(0).getBalance().getAmount(), dtoIntAccMovementsResume
//				.getBalance().getAmount());
//		assertEquals(listaDTOIntAccMovementsResume.get(0).getIncome().getAmount(), dtoIntAccMovementsResume.getIncome()
//				.getAmount());
//		assertEquals(listaDTOIntAccMovementsResume.get(0).getMonth(), dtoIntAccMovementsResume.getMonth()
// 				);
//	}

	private DTOIntAccount mockDtoIntAccount(){
		DTOIntAccount dtoIntAccount = new DTOIntAccount();
		dtoIntAccount.setIdAccount("123456789");
		dtoIntAccount.setName("name");
		dtoIntAccount.setType("type");

		dtoIntAccount.setBalance(mockDtoIntBalance());

		List<DTOIntCheckbook> mockCheckbooks = new ArrayList<DTOIntCheckbook>();
		mockCheckbooks.add(mockDtoIntCheckbook());
		dtoIntAccount.setListaCheckBook(mockCheckbooks);

		return dtoIntAccount;
	}

	private DTOIntBalance mockDtoIntBalance(){
		DTOIntBalance balance = new DTOIntBalance();
		balance.setAvailableBalance(new Money(Currency.getInstance("COP"), new BigDecimal(100000)));
		balance.setTotal(new Money(Currency.getInstance("COP"), new BigDecimal(100000)));
		balance.setTradeBalance(new Money(Currency.getInstance("COP"), new BigDecimal(100000)));

		return balance;
	}

	private List<DTOIntCheckbook> mockDtoIntCheckbookList(){
		DTOIntCheckbook checkbook = new DTOIntCheckbook();
		List<DTOIntCheckbook> checkbookList = new ArrayList<DTOIntCheckbook>();
		checkbook.setId("123456789");
		checkbook.setRequestDate(new Date());
		checkbook.setDeliveryDate(new Date());

		checkbookList.add(checkbook);
		return checkbookList;
	}

	private DTOIntCheckbook mockDtoIntCheckbook() {
		DTOIntCheckbook checkbook = new DTOIntCheckbook();

		checkbook.setId("123456789");
		checkbook.setRequestDate(new Date());
		checkbook.setDeliveryDate(new Date());

		return checkbook;
	}
	private List<DTOIntCheck> mockDtoIntChecks(int lenght){
		List<DTOIntCheck> checks  = new ArrayList<DTOIntCheck>();

		for (int i = 0; i < lenght; i++){
			DTOIntCheck check = new DTOIntCheck();
			check.setId(dataFactory.getNumberText(20));
			check.setIssueDate(new Date());
			check.setValue(new Money(Currency.getInstance("COP"), new BigDecimal(dataFactory.getNumberBetween(100000,200000))));

			checks.add(check);
		}
		return checks;
	}

	private List<DTOIntMonthlyBalances> mockDTOIntMonthlyBalances(int lenght){
		List<DTOIntMonthlyBalances> balances  = new ArrayList<DTOIntMonthlyBalances>();

		for (int i = 0; i < lenght; i++){
			DTOIntMonthlyBalances balance = new DTOIntMonthlyBalances();
			balance.setBalance(new Money(Currency.getInstance("COP"), new BigDecimal(dataFactory.getNumberBetween(10000, 50000))));
			balance.setMonth(dataFactory.getRandomText(6));

			balances.add(balance);
		}
		return balances;
	}

	private List<DTOIntAccMovementsResume> mockDtoIntAccMovementsResume(){
		List<DTOIntAccMovementsResume> resumes  = new ArrayList<DTOIntAccMovementsResume>();

		for (EnumMonth month : EnumMonth.values()){
			DTOIntAccMovementsResume resume = new DTOIntAccMovementsResume();
			resume.setBalance(new Money(Currency.getInstance("COP"), new BigDecimal(dataFactory.getNumberBetween(10000, 50000))));
			resume.setIncome(new Money(Currency.getInstance("COP"), new BigDecimal(dataFactory.getNumberBetween(10000, 50000))));
			resume.setOutcome(new Money(Currency.getInstance("COP"), new BigDecimal(dataFactory.getNumberBetween(10000, 50000))));
			resume.setMonth(month.name());

			resumes.add(resume);
		}
		return resumes;
	}
}

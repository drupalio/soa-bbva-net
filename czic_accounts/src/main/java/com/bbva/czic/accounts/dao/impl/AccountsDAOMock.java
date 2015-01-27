package com.bbva.czic.accounts.dao.impl;

import com.bbva.czic.accounts.business.dto.*;
import com.bbva.czic.accounts.dao.AccountsDAO;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.mockito.Mockito;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//@Repository(value = "accounts-dao")
//@Profile(value = "dev")
public class AccountsDAOMock implements AccountsDAO {

	private AccountsDAOMock mock;

	public AccountsDAOMock() throws JsonParseException, JsonMappingException, IOException {

		DTOIntAccount accounts = null;

		DTOIntCheck check = null;

		DTOIntCheckbook dtoIntCheckbook = null;

		List<DTOIntAccMovementsResume> listAccMovementsResume = new ArrayList<DTOIntAccMovementsResume>();
		DTOIntAccMovementsResume dtoIntAccMovementsResume = null;

		List<DTOIntMonthlyBalances> listDTOIntMonthlyBalances = new ArrayList<DTOIntMonthlyBalances>();
		DTOIntMonthlyBalances dtoIntMonthlyBalances = null;

		accounts = new ObjectMapper().readValue(
			this.getClass().getClassLoader().getResourceAsStream("mock/DTOAccounts.json"), DTOIntAccount.class);

		check = new ObjectMapper().readValue(
				this.getClass().getClassLoader().getResourceAsStream("mock/DTOListCheck.json"), DTOIntCheck.class);

		dtoIntCheckbook = new ObjectMapper().readValue(
				this.getClass().getClassLoader().getResourceAsStream("mock/DTOCheckbook.json"), DTOIntCheckbook.class);

		//Mapeo manual por los Money
		dtoIntAccMovementsResume = new DTOIntAccMovementsResume();
		Money income = new Money();
		Money outcome = new Money();
		Money balance = new Money();
		income.setAmount(new BigDecimal("1000"));
		outcome.setAmount(new BigDecimal("2000"));
		balance.setAmount(new BigDecimal("3000"));

		dtoIntAccMovementsResume.setIncome(income);
		dtoIntAccMovementsResume.setOutcome(outcome);
		dtoIntAccMovementsResume.setBalance(balance);

		listAccMovementsResume.add(dtoIntAccMovementsResume);
		listAccMovementsResume.add(dtoIntAccMovementsResume);
		listAccMovementsResume.add(dtoIntAccMovementsResume);

		dtoIntMonthlyBalances = new DTOIntMonthlyBalances();
		dtoIntMonthlyBalances.setBalance(balance);

		listDTOIntMonthlyBalances.add(dtoIntMonthlyBalances);
		listDTOIntMonthlyBalances.add(dtoIntMonthlyBalances);
		listDTOIntMonthlyBalances.add(dtoIntMonthlyBalances);

		mock = Mockito.mock(AccountsDAOMock.class);
		Mockito.when(getAccount(Mockito.any(DTOIntFilterAccount.class))).thenReturn(accounts);

		mock = Mockito.mock(AccountsDAOMock.class);
		List<DTOIntCheck>  checks = new ArrayList<DTOIntCheck>();
		checks.add(check);
		Mockito.when(getListCheck(Mockito.any(DTOIntFilterChecks.class))).thenReturn(checks);

		mock = Mockito.mock(AccountsDAOMock.class);
		Mockito.when(getCheckbooks(Mockito.any(DTOIntCheckbook.class))).thenReturn(dtoIntCheckbook);


		mock = Mockito.mock(AccountsDAOMock.class);
		Mockito.when(getAccountMonthlyBalance(Mockito.any(DTOIntFilterAccount.class))).thenReturn(listDTOIntMonthlyBalances);

		mock = Mockito.mock(AccountsDAOMock.class);
		Mockito.when(getAccountMovementResume(Mockito.any(DTOIntFilterMovResumes.class))).thenReturn(listAccMovementsResume);

	}

	@Override
	public List<DTOIntMonthlyBalances> getAccountMonthlyBalance(DTOIntFilterAccount dtoIntFilterAccount) {
		return new ArrayList<DTOIntMonthlyBalances>();
	}

	@Override
	public List<DTOIntAccMovementsResume> getAccountMovementResume(DTOIntFilterMovResumes dtoIntFilter) {
		return new ArrayList<DTOIntAccMovementsResume>();
	}

	@Override
	public DTOIntAccount getAccount(DTOIntFilterAccount dtoIntFilterAccount) {
		return null;
	}

	@Override
	public List<DTOIntCheck> getListCheck(DTOIntFilterChecks dtoIntCheck) {
		return null;
	}

	@Override
	public DTOIntCheckbook getCheckbooks(DTOIntCheckbook intCheckbook) {
		return null;
	}
}

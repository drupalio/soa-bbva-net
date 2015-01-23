package com.bbva.czic.accounts.dao.impl;

import java.io.IOException;
import java.util.List;

import com.bbva.czic.accounts.business.dto.*;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.mockito.Mockito;
import org.springframework.context.annotation.Profile;

import com.bbva.czic.accounts.dao.AccountsDAO;

// @Repository(value = "accounts-dao")
@Profile(value = "dev")
public class AccountsDAOMock implements AccountsDAO {

	private AccountsDAOMock mock;

	public AccountsDAOMock() throws JsonParseException, JsonMappingException, IOException {

		DTOIntAccount accounts = null;

		DTOIntCheck check = null;

		DTOIntCheckbook dtoIntCheckbook = null;

		accounts = new ObjectMapper().readValue(
				this.getClass().getClassLoader().getResourceAsStream("mock/DTOAccounts.json"), DTOIntAccount.class);

		check = new ObjectMapper().readValue(
				this.getClass().getClassLoader().getResourceAsStream("mock/DTOListCheck.json"), DTOIntCheck.class);

		dtoIntCheckbook = new ObjectMapper().readValue(
				this.getClass().getClassLoader().getResourceAsStream("mock/DTOCheckbook.json"), DTOIntCheckbook.class);


		mock = Mockito.mock(AccountsDAOMock.class);
		Mockito.when(getAccount(Mockito.any(DTOIntFilterAccount.class))).thenReturn(accounts);

		mock = Mockito.mock(AccountsDAOMock.class);
		Mockito.when(getListCheck(Mockito.any(DTOIntFilterChecks.class))).thenReturn(check);

		mock = Mockito.mock(AccountsDAOMock.class);
		Mockito.when(getCheckbooks(Mockito.any(DTOIntCheckbook.class))).thenReturn(dtoIntCheckbook);

	}

	@Override
	public List<DTOIntMonthlyBalances> getAccountMonthlyBalance(DTOIntFilterAccount dtoIntFilterAccount) {
		return null;
	}

	@Override
	public List<DTOIntAccMovementsResume> getAccountMovementResume(DTOIntFilterAccount dtoIntFilterAccount) {
		return null;
	}

	@Override
	public DTOIntAccount getAccount(DTOIntFilterAccount dtoIntFilterAccount) {
		return null;
	}

	@Override
	public DTOIntCheck getListCheck(DTOIntFilterChecks dtoIntCheck) {
		return null;
	}

	@Override
	public DTOIntCheckbook getCheckbooks(DTOIntCheckbook intCheckbook) {
		return null;
	}
}

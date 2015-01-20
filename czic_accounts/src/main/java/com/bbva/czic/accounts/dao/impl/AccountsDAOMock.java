package com.bbva.czic.accounts.dao.impl;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.mockito.Mockito;
import org.springframework.context.annotation.Profile;

import com.bbva.czic.accounts.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.accounts.business.dto.DTOIntAccount;
import com.bbva.czic.accounts.business.dto.DTOIntCheck;
import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.czic.accounts.business.dto.DTOIntFilterChecks;
import com.bbva.czic.accounts.business.dto.DTOIntMonthlyBalances;
import com.bbva.czic.accounts.dao.AccountsDAO;

// @Repository(value = "accounts-dao")
@Profile(value = "dev")
public class AccountsDAOMock implements AccountsDAO {

	private AccountsDAOMock mock;

	public AccountsDAOMock() throws JsonParseException, JsonMappingException, IOException {

		DTOIntAccount accounts = null;

		DTOIntCheck check = null;

		accounts = new ObjectMapper().readValue(
				this.getClass().getClassLoader().getResourceAsStream("mock/DTOAccounts.json"), DTOIntAccount.class);

		check = new ObjectMapper().readValue(
				this.getClass().getClassLoader().getResourceAsStream("mock/DTOListCheck.json"), DTOIntCheck.class);

		mock = Mockito.mock(AccountsDAOMock.class);
		Mockito.when(getAccount(Mockito.any(DTOIntFilterAccount.class))).thenReturn(accounts);

		mock = Mockito.mock(AccountsDAOMock.class);
		Mockito.when(getListCheck(Mockito.any(DTOIntFilterChecks.class))).thenReturn(check);

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
}

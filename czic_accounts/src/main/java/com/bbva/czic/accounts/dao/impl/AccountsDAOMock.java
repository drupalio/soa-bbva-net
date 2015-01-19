package com.bbva.czic.accounts.dao.impl;

import com.bbva.czic.accounts.business.dto.*;
import com.bbva.czic.accounts.dao.AccountsDAO;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.mockito.Mockito;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository(value = "accounts-dao")
@Profile(value = "dev")
public class AccountsDAOMock implements AccountsDAO {

	private AccountsDAOMock mock;

	public AccountsDAOMock() throws JsonParseException, JsonMappingException, IOException {

		DTOIntAccount accounts = null;

		DTOIntCheck check = null;

		accounts = new ObjectMapper().readValue(
				this.getClass().getClassLoader().getResourceAsStream("mock/DTOAccounts.json"), DTOIntAccount.class);

		check = new ObjectMapper().readValue(
				this.getClass().getClassLoader().getResourceAsStream("mock/DTOListCheck.json"),DTOIntCheck.class);



		mock = Mockito.mock(AccountsDAOMock.class);
		Mockito.when(getAccount(Mockito.any(DTOIntFilterAccount.class))).thenReturn(accounts);

		mock = Mockito.mock(AccountsDAOMock.class);
		Mockito.when(getListCheck(Mockito.any(DTOIntFilterChecks.class))).thenReturn(check);

	}


	@Override
	public DTOIntResponseMonthlyBalances getAccountMonthlyBalance(DTOIntFilterAccount dtoIntFilterAccount) {
		return null;
	}

	@Override
	public DTOIntResponseAccMovementsResumes getAccountMovementResume(DTOIntFilterAccount dtoIntFilterAccount) {
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

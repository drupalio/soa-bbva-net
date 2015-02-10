package com.bbva.czic.accounts.business.impl;

import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.czic.accounts.business.dto.DTOIntMonthlyBalances;
import com.bbva.czic.accounts.dao.AccountsDAO;
import com.bbva.czic.dto.net.MonthlyBalances;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertNotNull;

public class SrvIntAccountsTest extends SpringContextBbvaTest {

	@Mock
	AccountsDAO accountsDAO;

	@InjectMocks
	SrvIntAccounts srv;

	private static final DataFactory dataFactory = new DataFactory();

	@Before
	public void init(){
		srv = new SrvIntAccounts();
		MockitoAnnotations.initMocks(this);
	}

	// ----------------- testGetAccountMonthlyBalance ----------------------
	@Test(expected = BusinessServiceException.class)
	public void testGetAccountMonthlyBalanceInvalidFilter(){
		final DTOIntFilterAccount filterAccount = new DTOIntFilterAccount();
		filterAccount.setAccountId("123");

		srv.getAccountMonthlyBalance(filterAccount);
	}

	@Test(expected = BusinessServiceException.class)
	public void testGetAccountMonthlyBalanceInvalidAccountId(){
		final DTOIntFilterAccount filterAccount = new DTOIntFilterAccount();
		filterAccount.setAccountId("123456789HH234567890");

		srv.getAccountMonthlyBalance(filterAccount);
	}

	@Test(expected = BusinessServiceException.class)
	public void testGetAccountMonthlyBalanceDaoException(){
		final DTOIntFilterAccount filterAccount = new DTOIntFilterAccount();
		filterAccount.setAccountId("12345678901234567890");
		BusinessServiceException bsn = getBusinessServiceException();

		when(accountsDAO.getAccountMonthlyBalance(any(DTOIntFilterAccount.class)))
				.thenThrow(bsn);

		srv.getAccountMonthlyBalance(filterAccount);
	}

	@Test(expected = BusinessServiceException.class)
	public void testGetAccountMonthlyBalanceOutputException(){
		final DTOIntFilterAccount filterAccount = new DTOIntFilterAccount();
		filterAccount.setAccountId("12345678901234567890");
		BusinessServiceException bsn = getBusinessServiceException();

		List<DTOIntMonthlyBalances> mbalances = new ArrayList<DTOIntMonthlyBalances>();
		DTOIntMonthlyBalances balance = new DTOIntMonthlyBalances();
		balance.setMonth("month");
		mbalances.add(balance);


		when(accountsDAO.getAccountMonthlyBalance(any(DTOIntFilterAccount.class)))
				.thenReturn(mbalances);

		srv.getAccountMonthlyBalance(filterAccount);
	}

	@Test
	public void testGetAccountMonthlyBalance(){
		final DTOIntFilterAccount filterAccount = new DTOIntFilterAccount();
		filterAccount.setAccountId("12345678901234567890");

		List<DTOIntMonthlyBalances> mbalances = new ArrayList<DTOIntMonthlyBalances>();
		DTOIntMonthlyBalances balance = new DTOIntMonthlyBalances();
		balance.setMonth("month");
		balance.setBalance(new Money(Currency.getInstance("COP"), new BigDecimal(dataFactory.getNumberBetween(100000,200000))));
		mbalances.add(balance);


		when(accountsDAO.getAccountMonthlyBalance(any(DTOIntFilterAccount.class)))
				.thenReturn(mbalances);

		final List<DTOIntMonthlyBalances> result = srv.getAccountMonthlyBalance(filterAccount);

		assertNotNull(result);
		assertTrue(result.size() == 1);
	}

	// ----------------- testGetAccMovementResume ----------------------

	public void testGetAccMovementResumeInvalidFilter(){

	}

	private BusinessServiceException getBusinessServiceException(){
		return new BusinessServiceException(EnumError.TECHNICAL_ERROR.getAlias());
	}
}

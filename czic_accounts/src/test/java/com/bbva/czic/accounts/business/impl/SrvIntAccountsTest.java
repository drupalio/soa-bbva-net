package com.bbva.czic.accounts.business.impl;

import com.bbva.czic.accounts.business.dto.*;
import com.bbva.czic.accounts.dao.AccountsDAO;
import com.bbva.czic.dto.net.MonthlyBalances;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import com.sun.corba.se.impl.oa.NullServantImpl;
import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.*;

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
	private BusinessServiceException bsn = null;

	@Before
	public void init(){
		srv = new SrvIntAccounts();
		MockitoAnnotations.initMocks(this);
		bsn = new BusinessServiceException(EnumError.TECHNICAL_ERROR.getAlias());
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

		when(accountsDAO.getAccountMonthlyBalance(any(DTOIntFilterAccount.class)))
				.thenThrow(bsn);

		srv.getAccountMonthlyBalance(filterAccount);
	}

	@Test(expected = BusinessServiceException.class)
	public void testGetAccountMonthlyBalanceOutputException(){
		final DTOIntFilterAccount filterAccount = new DTOIntFilterAccount();
		filterAccount.setAccountId("12345678901234567890");

		final List<DTOIntMonthlyBalances> mbalances = new ArrayList<DTOIntMonthlyBalances>();
		final DTOIntMonthlyBalances balance = new DTOIntMonthlyBalances();
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

		final List<DTOIntMonthlyBalances> mbalances = new ArrayList<DTOIntMonthlyBalances>();
		final DTOIntMonthlyBalances balance = new DTOIntMonthlyBalances();
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

	@Test(expected = BusinessServiceException.class)
	public void testGetAccMovementResumeInvalidFilterMonth(){
		final DTOIntFilterMovResumes filter = new DTOIntFilterMovResumes();
		filter.setAccountId("12345678901234567890");
		filter.setMonth("13");

		srv.getAccMovementResume(filter);
	}

	@Test(expected = BusinessServiceException.class)
	public void testGetAccMovementResumeInvalidAccountIdNullMonth(){
		final DTOIntFilterMovResumes filter = new DTOIntFilterMovResumes();
		filter.setAccountId("123456789HH234567890");

		srv.getAccMovementResume(filter);
	}

	@Test(expected = BusinessServiceException.class)
	public void testGetAccMovementResumeDaoException(){
		final DTOIntFilterMovResumes filter = new DTOIntFilterMovResumes();
		filter.setAccountId("12345678901234567890");
		filter.setMonth("02");

		when(accountsDAO.getAccountMovementResume(any(DTOIntFilterMovResumes.class))).thenThrow(bsn);

		srv.getAccMovementResume(filter);
	}

	@Test(expected = BusinessServiceException.class)
	public void testGetAccMovementResumeOutputException(){
		final DTOIntFilterMovResumes filter = new DTOIntFilterMovResumes();
		filter.setAccountId("12345678901234567890");
		filter.setMonth("02");

		final List<DTOIntAccMovementsResume> result = new ArrayList<DTOIntAccMovementsResume>();
		final DTOIntAccMovementsResume resume = new DTOIntAccMovementsResume();
		resume.setMonth("month");
		result.add(resume);

		when(accountsDAO.getAccountMovementResume(any(DTOIntFilterMovResumes.class))).thenReturn(result);

		srv.getAccMovementResume(filter);
	}

	@Test
	public void testGetAccMovementResume(){
		final DTOIntFilterMovResumes filter = new DTOIntFilterMovResumes();
		filter.setAccountId("12345678901234567890");
		filter.setMonth("02");

		final List<DTOIntAccMovementsResume> result = new ArrayList<DTOIntAccMovementsResume>();
		final DTOIntAccMovementsResume resume = new DTOIntAccMovementsResume();
		resume.setMonth("month");
		resume.setBalance(new Money(Currency.getInstance("COP"), new BigDecimal(dataFactory.getNumberBetween(100000,200000))));
		result.add(resume);

		when(accountsDAO.getAccountMovementResume(any(DTOIntFilterMovResumes.class))).thenReturn(result);

		List<DTOIntAccMovementsResume> movResumes = srv.getAccMovementResume(filter);

		assertNotNull(movResumes);
	}

	@Test(expected = BusinessServiceException.class)
	public void testGetAccMovementResumeInvalidFilterAccountId(){
		final DTOIntFilterMovResumes filter = new DTOIntFilterMovResumes();
		filter.setAccountId("123");
		filter.setMonth("02");

		srv.getAccMovementResume(filter);
	}

	// ----------------- testGetAccount ----------------------

	@Test(expected = BusinessServiceException.class)
	public void testgetAccountDAOException(){
		final DTOIntFilterAccount filter = new DTOIntFilterAccount();
		filter.setAccountId("12345678901234567890");

		when(accountsDAO.getAccount(any(DTOIntFilterAccount.class))).thenThrow(bsn);

		srv.getAccount(filter);
	}

	@Test(expected = BusinessServiceException.class)
	public void testgetAccountOutputException(){
		final DTOIntFilterAccount filter = new DTOIntFilterAccount();
		filter.setAccountId("12345678901234567890");
		final DTOIntAccount dtoAcc = new DTOIntAccount();

		when(accountsDAO.getAccount(any(DTOIntFilterAccount.class))).thenReturn(dtoAcc);

		srv.getAccount(filter);
	}

	@Test
	public void testgetAccount(){
		final DTOIntFilterAccount filter = new DTOIntFilterAccount();
		filter.setAccountId("12345678901234567890");
		final DTOIntAccount dtoAcc = new DTOIntAccount();
		dtoAcc.setIdAccount("12345678901234567890");
		dtoAcc.setName("Name");
		dtoAcc.setType("Type");
		dtoAcc.setBalance(new DTOIntBalance());

		when(accountsDAO.getAccount(any(DTOIntFilterAccount.class))).thenReturn(dtoAcc);

		final DTOIntAccount acc =  srv.getAccount(filter);

		assertNotNull(acc);
	}

	@Test(expected = BusinessServiceException.class)
	public void testgetAccountInvalidFilter(){
		final DTOIntFilterAccount filter = new DTOIntFilterAccount();
		filter.setAccountId("1234567");

		srv.getAccount(filter);
	}

	// ----------------- testListCheck ----------------------

	@Test(expected = BusinessServiceException.class)
	public void testListCheckInvalidFilter(){
		final DTOIntFilterChecks filterChecks = new DTOIntFilterChecks();

		srv.listCheck(filterChecks);
	}

	@Test(expected = BusinessServiceException.class)
	public void testListCheckInvalidAccountId(){
		final DTOIntFilterChecks filterChecks = new DTOIntFilterChecks();
		filterChecks.setPageSize(10);
		filterChecks.setPaginationKey(1);
		filterChecks.setAccountId("123456789AA234567890");

		srv.listCheck(filterChecks);
	}

	@Test(expected = BusinessServiceException.class)
	public void testListCheckInvalidDateRange(){
		final DTOIntFilterChecks filterChecks = new DTOIntFilterChecks();
		filterChecks.setPageSize(10);
		filterChecks.setPaginationKey(1);
		filterChecks.setAccountId("12345678901234567890");

		filterChecks.setStartDate(new Date());
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
		filterChecks.setEndDate(cal.getTime());

		srv.listCheck(filterChecks);
	}

	@Test(expected = BusinessServiceException.class)
	public void testListCheckDAOException(){
		final DTOIntFilterChecks filterChecks = new DTOIntFilterChecks();
		filterChecks.setPageSize(10);
		filterChecks.setPaginationKey(1);
		filterChecks.setAccountId("12345678901234567890");

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
		filterChecks.setStartDate(cal.getTime());
		filterChecks.setEndDate(new Date());

		when(accountsDAO.getListCheck(any(DTOIntFilterChecks.class))).thenThrow(bsn);

		srv.listCheck(filterChecks);
	}

	@Test(expected = BusinessServiceException.class)
	public void testListCheckOutputException(){
		final DTOIntFilterChecks filterChecks = new DTOIntFilterChecks();
		filterChecks.setPageSize(10);
		filterChecks.setPaginationKey(1);
		filterChecks.setAccountId("12345678901234567890");

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
		filterChecks.setStartDate(cal.getTime());
		filterChecks.setEndDate(new Date());

		final List<DTOIntCheck> dtoIntChecks = new ArrayList<DTOIntCheck>();
		final DTOIntCheck intCheck = new DTOIntCheck();
		dtoIntChecks.add(intCheck);

		when(accountsDAO.getListCheck(any(DTOIntFilterChecks.class))).thenReturn(dtoIntChecks);

		srv.listCheck(filterChecks);
	}

	@Test
	public void testListCheck(){
		final DTOIntFilterChecks filterChecks = new DTOIntFilterChecks();
		filterChecks.setPageSize(10);
		filterChecks.setPaginationKey(1);
		filterChecks.setAccountId("12345678901234567890");

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
		filterChecks.setStartDate(cal.getTime());
		filterChecks.setEndDate(new Date());

		final List<DTOIntCheck> dtoIntChecks = new ArrayList<DTOIntCheck>();
		final DTOIntCheck intCheck = new DTOIntCheck();
		intCheck.setId("123456789");
		intCheck.setValue(new Money(Currency.getInstance("COP"), new BigDecimal(dataFactory.getNumberBetween(0, 1000000))));
		dtoIntChecks.add(intCheck);

		when(accountsDAO.getListCheck(any(DTOIntFilterChecks.class))).thenReturn(dtoIntChecks);

		final List<DTOIntCheck> checks = srv.listCheck(filterChecks);

		assertNotNull(checks);
		assertTrue(checks.size() == 1);
	}

	// ----------------- testGetCheckbooks ----------------------
	@Test(expected = BusinessServiceException.class)
	public void testGetCheckbooksInvalidFilter(){
		final DTOIntFilterCheckbooks chkbook = new DTOIntFilterCheckbooks();

		srv.getCheckbooks(chkbook);
	}

	@Test(expected = BusinessServiceException.class)
	public void testGetChecksInvalidAccountId(){
		final DTOIntFilterCheckbooks chkbook = new DTOIntFilterCheckbooks();
		chkbook.setId(dataFactory.getNumberText(20));
		chkbook.setIdAccount(dataFactory.getNumberText(18) + "AA");

		srv.getCheckbooks(chkbook);
	}

	@Test(expected = BusinessServiceException.class)
	public void testGetCheckbooksInvalidCheckbookId(){
		final DTOIntFilterCheckbooks chkbook = new DTOIntFilterCheckbooks();
		chkbook.setId(dataFactory.getNumberText(18) + "AA");
		chkbook.setIdAccount(dataFactory.getNumberText(20));

		srv.getCheckbooks(chkbook);
	}

	@Test(expected = BusinessServiceException.class)
	public void testGetCheckbooksDAOException(){
		final DTOIntFilterCheckbooks chkbook = new DTOIntFilterCheckbooks();
		chkbook.setId(dataFactory.getNumberText(20));
		chkbook.setIdAccount(dataFactory.getNumberText(20));

		when(accountsDAO.getCheckbooks(any(DTOIntFilterCheckbooks.class))).thenThrow(bsn);

		srv.getCheckbooks(chkbook);
	}

	@Test
	public void testGetCheckbooks(){
		final DTOIntFilterCheckbooks chkbook = new DTOIntFilterCheckbooks();
		final DTOIntCheckbook book = new DTOIntCheckbook();
		chkbook.setId(dataFactory.getNumberText(20));
		chkbook.setIdAccount(dataFactory.getNumberText(20));

		when(accountsDAO.getCheckbooks(any(DTOIntFilterCheckbooks.class))).thenReturn(book);

		DTOIntCheckbook result = srv.getCheckbooks(chkbook);

		assertNotNull(result);
	}

	// ----------------- testGetCheck ----------------------
	@Test(expected = BusinessServiceException.class)
	public void testGetChecksInvalidFilter(){
		final DTOIntCheckFilter filter = new DTOIntCheckFilter();

		srv.getChecks(filter);
	}

	@Test(expected = BusinessServiceException.class)
	public void testGetCheckbooksInvalidAccountId(){
		final DTOIntCheckFilter filter = new DTOIntCheckFilter();
		filter.setCheckId(dataFactory.getNumberText(9));
		filter.setAccountId(dataFactory.getNumberText(18) + "SC");

		srv.getChecks(filter);
	}

	@Test(expected = BusinessServiceException.class)
	public void testGetCheckbooksInvalidCheckId(){
		final DTOIntCheckFilter filter = new DTOIntCheckFilter();
		filter.setCheckId(dataFactory.getNumberText(7) + "CC");
		filter.setAccountId(dataFactory.getNumberText(20));

		srv.getChecks(filter);
	}

	@Test(expected = BusinessServiceException.class)
	public void testGetChecksDAOException(){
		final DTOIntCheckFilter filter = new DTOIntCheckFilter();
		filter.setCheckId(dataFactory.getNumberText(9));
		filter.setAccountId(dataFactory.getNumberText(20));

		when(accountsDAO.getChecks(any(DTOIntCheckFilter.class))).thenThrow(bsn);

		srv.getChecks(filter);
	}

	@Test
	public void testGetCheck(){
		final DTOIntCheckFilter filter = new DTOIntCheckFilter();
		filter.setCheckId(dataFactory.getNumberText(9));
		filter.setAccountId(dataFactory.getNumberText(20));

		DTOIntCheck check = new DTOIntCheck();
		check.setId(dataFactory.getNumberText(9));
		check.setValue(new Money(Currency.getInstance("COP"), new BigDecimal(dataFactory.getNumberBetween(0, 1000000))));

		when(accountsDAO.getChecks(any(DTOIntCheckFilter.class))).thenReturn(check);

		DTOIntCheck result = srv.getChecks(filter);

		assertNotNull(result);
	}
}

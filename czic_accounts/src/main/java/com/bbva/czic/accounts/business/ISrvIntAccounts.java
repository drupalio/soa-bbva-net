package com.bbva.czic.accounts.business;

import java.util.Date;
import java.util.List;

import com.bbva.czic.accounts.business.dto.DTOIntAccount;
import com.bbva.czic.accounts.business.dto.DTOIntMovement;
import com.bbva.czic.accounts.dao.AccountsDAO;

public interface ISrvIntAccounts<Account> {

	public DTOIntMovement getMovement(String idProduct, String idMovement);

	public List<DTOIntAccount> listMovements(String accountId, String starDate, String endDate, String bottomValue, String topValue, String paginationKey, String pageSize);

	public List<DTOIntAccount> getAccountMonthlyBalance(String id, Date startMonth,Date endMonth);

	public List<DTOIntAccount> getAccMovementResume(String income, String outcome, String balance, String month);

	public AccountsDAO getAccount(String idAccount);

	List<DTOIntAccount> getAccountMonthlyBalance();

	List<DTOIntAccount> getAccMovementResume();

	List<DTOIntAccount> listMovements();

}
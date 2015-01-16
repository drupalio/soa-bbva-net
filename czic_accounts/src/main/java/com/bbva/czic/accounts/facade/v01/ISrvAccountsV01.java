package com.bbva.czic.accounts.facade.v01;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.Account;
import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.MonthlyBalances;

import java.util.List;

public interface ISrvAccountsV01{

	public Account getAccount(String idAccount);

	public List<MonthlyBalances> getAccountMonthlyBalance( String idAccount, String filter, String fields, String expands,String sort);

	public List<AccMovementsResume> getAccMovementResume(String idAccount, String filter, String fields, String expands,String sort);


	Check listCheck(  String accountId, String filter, String status, String paginationKey, String pageSize);

}
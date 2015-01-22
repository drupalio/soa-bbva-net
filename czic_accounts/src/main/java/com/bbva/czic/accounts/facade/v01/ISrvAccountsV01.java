package com.bbva.czic.accounts.facade.v01;

import com.bbva.czic.dto.net.*;
import com.wordnik.swagger.annotations.ApiParam;

import javax.ws.rs.PathParam;
import java.util.List;

public interface ISrvAccountsV01{

	public Account getAccount(String idAccount);

	public List<MonthlyBalances> getAccountMonthlyBalance( String idAccount, String filter, String fields, String expands,String sort);

	public List<AccMovementsResume> getAccMovementResume(String idAccount, String filter, String fields, String expands,String sort);


	List<Check> listCheck(String accountId, String filter, String status, String paginationKey, String pageSize);

	public Checkbook getCheckbook(String checkbookId, String accountId);

}
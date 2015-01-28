package com.bbva.czic.accounts.facade.v01;

import com.bbva.czic.dto.net.*;
import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

public interface ISrvAccountsV01{

	Account getAccount(String idAccount);

	List<MonthlyBalances> getAccountMonthlyBalance( String idAccount, String filter, String fields, String expands,String sort);

	List<AccMovementsResume> getAccMovementResume(String idAccount, String filter, String fields, String expands,String sort);


	List<Check> listCheck(String accountId, String filter, Integer paginationKey, Integer pageSize);

	Checkbook getCheckbook(String checkbookId, String accountId);

	public Check getCheck(String accountId, String checkId);

}
package com.bbva.czic.accounts.facade.v01;

import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Response;

public interface ISrvAccountsV01<Movement> {

	public Movement getMovement(String idProduct, String idMovement);

	public Response listMovements(String accountId, String starDate, String endDate, String bottomValue, String topValue, String paginationKey);
	
	public <Account> Account getAccount(String idAccount);
	
// En validacion de plantillas
	
	public Response getAccountMonthlyBalance(String id, Date startMonth,Date endMonth);

	public Response getAccMovementResume(String income, String outcome, String balance, String month);

	Response listMovements(String accountId, String starDate, String endDate,
			String bottomValue);

	Response getAccountMonthlyBalance(String filter, String fields,
			String expands, String sort);

	

}
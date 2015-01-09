package com.bbva.czic.accounts.facade.v01;

import java.util.Date;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.accounts.business.ISrvIntAccounts;
import com.bbva.czic.accounts.dao.AccountsDAO;
import com.bbva.czic.dto.net.Account;
import com.bbva.czic.dto.net.Movement;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.bbva.jee.arq.spring.core.servicing.annotations.SN;
import com.bbva.jee.arq.spring.core.servicing.annotations.VN;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("/V01")
@SN(registryID = "SN201400333", logicalID = "accounts")
@VN(vnn = "V01")
@Api(value = "/accounts/V01", description = "SN accounts")
@Produces({ MediaType.APPLICATION_JSON })
@Service
public abstract class SrvAccountsV01 implements ISrvAccountsV01, com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

	private static I18nLog log = I18nLogFactory
			.getLogI18n(SrvAccountsV01.class, "META-INF/spring/i18n/log/mensajesLog");

	public HttpHeaders httpHeaders;

	@Autowired
	BusinessServicesToolKit bussinesToolKit;

	public UriInfo uriInfo;

	@Override
	public void setUriInfo(UriInfo ui) {
		this.uriInfo = ui;
	}

	@Override
	public void setHttpHeaders(HttpHeaders httpHeaders) {
		this.httpHeaders = httpHeaders;
	}

	@Autowired
	ISrvIntAccounts srvIntAccounts;
	
	@Override
	@ApiOperation(value = "Operacion que retorna el resumen de la informacion de una cuenta", notes = "Tipo de Producto", response = AccountsDAO.class)
	@ApiResponses(value = { @ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = Response.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@Path("/{id}")
	@SMC(registryID = "SMC201400334", logicalID = "getAccount")
	public AccountsDAO getAccount(@ApiParam(value = "identifier param") @PathParam("id") String idAccount) {
	
		return srvIntAccounts.getAccount(idAccount);
	}
	
	@ApiOperation(value = "En validacion", notes = "Information Office", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = Response.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@SMC(registryID = "SMC201400334", logicalID = "listMovements")
	public Response listMovements(
			@ApiParam(value = "Claimer identifier param") @DefaultValue("null") @QueryParam("$accountId") String accountId,
			@ApiParam(value = "Claimer identifier param") @DefaultValue("null") @QueryParam("$starDate") String starDate,
			@ApiParam(value = "Claimer identifier param") @DefaultValue("null") @QueryParam("$endDate") String endDate,
			@ApiParam(value = "Claimer identifier param") @DefaultValue("null") @QueryParam("$bottomValue") String bottomValue,
			@ApiParam(value = "Claimer identifier param") @DefaultValue("null") @QueryParam("$topValue") String topValue,
			@ApiParam(value = "Claimer identifier param") @DefaultValue("null") @QueryParam("$paginationKey") String paginationKey,
			@ApiParam(value = "Claimer identifier param") @DefaultValue("null") @QueryParam("$pageSize") String pageSize)	{
				
		return (Response) srvIntAccounts.listMovements(accountId, starDate, endDate, bottomValue, topValue, paginationKey, pageSize);
	}


	@Override
	@ApiOperation(value = "Consulta que trae la informaci�n detallada de un movimiento realizado sobre una cuenta", notes = "Information Producto", response = Account.class)
	@ApiResponses(value = { @ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = Response.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@Path("/{idAccount}/movements/{idMovement}")
	@SMC(registryID = "SMC201400334", logicalID = "getMovement")
	public List getMovement(@ApiParam(value = "Claim identifier param") @PathParam("idAccount") String idAccount,
			@ApiParam(value = "Claimer identifier param") @PathParam("idMovement") String idMovement) {
	
		 return srvIntAccounts.getAccMovementResume();
	}
	
// En validacion - Pendiente
	@Override
	@ApiOperation(value = "Operacion realizada", notes = "Information Operation", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = Response.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@SMC(registryID = "SMC201400334", logicalID = "getAccountMonthlyBalance")
	public Response getAccountMonthlyBalance(
			@ApiParam(value = "filter param") @DefaultValue("null") @QueryParam("$filter") String filter,
			@ApiParam(value = "fields param") @DefaultValue("null") @QueryParam("$fields") String fields,
			@ApiParam(value = "expands param") @DefaultValue("null") @QueryParam("$expands") String expands,
			@ApiParam(value = "order by param") @DefaultValue("null") @QueryParam("$sort") String sort) {
		// TODO: autogenerated, complete implementation using internal service
		return null;
	}

	@Override
	@ApiOperation(value = "Saldos Productos", notes = "Inforamtion Saldos de productos", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = Response.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@SMC(registryID = "SMC201400334", logicalID = "getAccMovementResume")
	public Response getAccMovementResume(
			@ApiParam(value = "filter param") @DefaultValue("null") @QueryParam("$filter") String filter,
			@ApiParam(value = "fields param") @DefaultValue("null") @QueryParam("$fields") String fields,
			@ApiParam(value = "expands param") @DefaultValue("null") @QueryParam("$expands") String expands,
			@ApiParam(value = "order by param") @DefaultValue("null") @QueryParam("$sort") String sort) {
		// TODO: autogenerated, complete implementation using internal service
		return null;
	}

	@Override
	public Response listMovements(String accountId, String starDate,
			String endDate, String bottomValue, String topValue,
			String paginationKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getAccountMonthlyBalance(String id, Date startMonth,
			Date endMonth) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

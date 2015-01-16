package com.bbva.czic.accounts.facade.v01.impl;

import com.bbva.czic.accounts.business.ISrvIntAccounts;
import com.bbva.czic.accounts.business.dto.DTOIntCheck;
import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.czic.accounts.dao.AccountsDAO;
import com.bbva.czic.accounts.facade.v01.ISrvAccountsV01;
import com.bbva.czic.accounts.facade.v01.mappers.IAccountsMapper;
import com.bbva.czic.accounts.facade.v01.utils.IFilterConverter;
import com.bbva.czic.accounts.facade.v01.utils.IListCheckFilterConverter;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.Account;
import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.MonthlyBalances;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.bbva.jee.arq.spring.core.servicing.annotations.SN;
import com.bbva.jee.arq.spring.core.servicing.annotations.VN;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;
import com.wordnik.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/V01")
@SN(registryID = "SN201400333", logicalID = "accounts")
@VN(vnn = "V01")
@Api(value = "/accounts/V01", description = "SN accounts")
@Produces({ MediaType.APPLICATION_JSON })
@Service
public class SrvAccountsV01 implements ISrvAccountsV01, com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

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

	@Resource(name = "accounts-mapper")
	private IAccountsMapper iAccountsMapper;


	@Resource(name = "accounts-filter-converter")
	private IFilterConverter accFilterConverter;

	@Resource(name = "listCheck-filter-converter")
	private IListCheckFilterConverter listCheckFilterConverter;

	@Override
	@ApiOperation(value = "Operacion que retorna el resumen de la informacion de una cuenta", notes = "Tipo de Producto", response = AccountsDAO.class)
	@ApiResponses(value = { @ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = Response.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@Path("/{id}")
	@SMC(registryID = "SMC201400334", logicalID = "getAccount")
	public Account getAccount(@ApiParam(value = "identifier param") @PathParam("id") String idAccount) {
		DTOIntFilterAccount dtoIntFilterAccount = new DTOIntFilterAccount();
		dtoIntFilterAccount.setAccountId(idAccount);
		return  iAccountsMapper.map(srvIntAccounts.getAccount(dtoIntFilterAccount));
	}


	@Override
	@ApiOperation(value = "Operacion realizada", notes = "Information Operation", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = Response.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@Path("/{id}/monthlyBalances")
	@SMC(registryID = "SMC201400334", logicalID = "getAccountMonthlyBalance")
	public List<MonthlyBalances> getAccountMonthlyBalance(
			@ApiParam(value = "identifier param") @PathParam("id") String idAccount,
			@ApiParam(value = "filter param") @DefaultValue("null") @QueryParam("$filter") String filter,
			@ApiParam(value = "fields param") @DefaultValue("null") @QueryParam("$fields") String fields,
			@ApiParam(value = "expands param") @DefaultValue("null") @QueryParam("$expands") String expands,
			@ApiParam(value = "order by param") @DefaultValue("null") @QueryParam("$sort") String sort) {
		DTOIntFilterAccount dtoIntFilterAccount = new DTOIntFilterAccount();
		dtoIntFilterAccount = accFilterConverter.getDTOIntFilter(idAccount,filter);
		return iAccountsMapper.mapL(srvIntAccounts.getAccountMonthlyBalance(dtoIntFilterAccount));
	}

	@Override
	@ApiOperation(value = "Saldos Productos", notes = "Inforamtion Saldos de productos", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = Response.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@Path("/{id}/movementsResumes")
	@SMC(registryID = "SMC201400334", logicalID = "getAccMovementResume")
	public List<AccMovementsResume> getAccMovementResume(
			@ApiParam(value = "identifier param") @PathParam("id") String idAccount,
			@ApiParam(value = "filter param") @DefaultValue("null") @QueryParam("$filter") String filter,
			@ApiParam(value = "fields param") @DefaultValue("null") @QueryParam("$fields") String fields,
			@ApiParam(value = "expands param") @DefaultValue("null") @QueryParam("$expands") String expands,
			@ApiParam(value = "order by param") @DefaultValue("null") @QueryParam("$sort") String sort) {
		DTOIntFilterAccount dtoIntFilterAccount = new DTOIntFilterAccount();
		dtoIntFilterAccount = accFilterConverter.getDTOIntFilter(idAccount,filter);
		return iAccountsMapper.map(srvIntAccounts.getAccMovementResume(dtoIntFilterAccount));
	}

	/*
	* Se crea manualmente
 	*/

	@Override
	@ApiOperation(value = "Listado Cheques", notes = "Listado De Chequeras ", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = Response.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@Path("/{id}/listChecks")
	@SMC(registryID = "SMC201400026", logicalID = "listCheck")
	public Check listCheck(
			@ApiParam(value = "identifier param") @PathParam("accountId") String accountId,
			@ApiParam(value = "filter param") @DefaultValue("null") @QueryParam("$filter") String filter,
			@ApiParam(value = "fields param") @DefaultValue("null") @QueryParam("$status") String status,
			@ApiParam(value = "fields param") @DefaultValue("null") @QueryParam("$paginationKey") String paginationKey,
			@ApiParam(value = "expands param") @DefaultValue("null") @QueryParam("$pageSize") String pageSize) {
		DTOIntCheck dtoIntCheck = new DTOIntCheck();
		dtoIntCheck = (DTOIntCheck) listCheckFilterConverter.getDTOIntFilter(accountId,filter);
		return iAccountsMapper.mapChecks(srvIntAccounts.listCheck(dtoIntCheck));
	}

}

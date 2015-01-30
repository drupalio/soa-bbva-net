package com.bbva.czic.accounts.facade.v01.impl;

import java.util.List;

import javax.annotation.Resource;
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

import com.bbva.czic.accounts.business.dto.*;
import org.apache.cxf.jaxrs.model.wadl.ElementClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.accounts.business.ISrvIntAccounts;
import com.bbva.czic.accounts.dao.AccountsDAO;
import com.bbva.czic.accounts.facade.v01.ISrvAccountsV01;
import com.bbva.czic.accounts.facade.v01.mappers.IAccountsMapper;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.Account;
import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;
import com.bbva.czic.dto.net.MonthlyBalances;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.validator.impl.FiqlValidator;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.bbva.jee.arq.spring.core.servicing.annotations.SN;
import com.bbva.jee.arq.spring.core.servicing.annotations.VN;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
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
public class SrvAccountsV01 implements ISrvAccountsV01,
		com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

	private static I18nLog log = I18nLogFactory.getLogI18n(
			SrvAccountsV01.class, "META-INF/spring/i18n/log/mensajesLog");

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
	private ISrvIntAccounts srvIntAccounts;

	@Resource(name = "accounts-mapper")
	private IAccountsMapper iAccountsMapper;

	@Override
	@ApiOperation(value = "Operacion que retorna el resumen de la informacion de una cuenta", notes = "Tipo de Producto", response = AccountsDAO.class)
	@ApiResponses(value = {
			@ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = Response.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@Path("/{id}")
	@SMC(registryID = "SMC201400334", logicalID = "getAccount")
	public Account getAccount(
			@ApiParam(value = "identifier param") @PathParam("id") String idAccount) {

		final DTOIntFilterAccount dtoIntFilterAccount = new DTOIntFilterAccount();
		dtoIntFilterAccount.setAccountId(idAccount);
		return iAccountsMapper.map(srvIntAccounts.getAccount(dtoIntFilterAccount));
	}

	@Override
	@ApiOperation(value = "Operacion realizada", notes = "Information Operation", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = Response.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@Path("/{accountId}/monthlyBalances")
	@SMC(registryID = "SMCCO1400020", logicalID = "getAccountMonthlyBalance")
	public List<MonthlyBalances> getAccountMonthlyBalance(
			@ApiParam(value = "identifier param") @PathParam("accountId")String idAccount,
			@ApiParam(value = "filter param") @DefaultValue("null") @QueryParam("$filter") String filter
			) {

		// 1. Validate filter FIQL
		new FiqlValidator(filter).exist().hasGeAndLe("month").validate();

		// 2. Mapping to DTOIntFilter
		final DTOIntFilterAccount dtoIntFilterAccount = iAccountsMapper
				.getDTOIntFilter(idAccount, filter);

		// Invoke SrvIntAccounts and Mapping to canonical DTO
		return iAccountsMapper.mapL(srvIntAccounts
				.getAccountMonthlyBalance(dtoIntFilterAccount));
	}

	@Override
	@ApiOperation(value = "Saldos Productos", notes = "Inforamtion Saldos de productos", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = Response.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@Path("/{id}/movementsResumes")
	@SMC(registryID = "SMC201400334", logicalID = "getAccMovementResume")
	public List<AccMovementsResume> getAccMovementResume(
			@ApiParam(value = "identifier param") @PathParam("id") String idAccount,
			@ApiParam(value = "filter param") @DefaultValue("null") @QueryParam("$filter") String filter) {

		new FiqlValidator(filter).hasGe("month").validateIfExisit();

		DTOIntFilterMovResumes dtoIntFilter = iAccountsMapper
				.getDtoIntFilterMovResumes(idAccount, filter);

		return iAccountsMapper.map(srvIntAccounts
				.getAccMovementResume(dtoIntFilter));
	}

	/*
	 * Se crea manualmente
	 */

	@Override
	@ApiOperation(value = "Listado Cheques", notes = "Listado De Chequeras ", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = Response.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@Path("/{id}/listChecks")
	@SMC(registryID = "SMC201400026", logicalID = "listCheck")
	public List<Check> listCheck(
			@ApiParam(value = "identifier param") @PathParam("id") String accountId,
			@ApiParam(value = "filter param") @DefaultValue("null") @QueryParam("$filter") String filter,
			@ApiParam(value = "fields param") @DefaultValue("null") @QueryParam("paginationKey") Integer paginationKey,
			@ApiParam(value = "expands param") @DefaultValue("null") @QueryParam("pageSize") Integer pageSize) {

		// Validacion del filtro
		new FiqlValidator(filter).exist().hasGeAndLeDate("issueDate")
				.hasEq("status").validateAny();

		// Mapeo del filtro a DTO
		DTOIntFilterChecks dtoIntFilterChecks = iAccountsMapper
				.getDtoIntFilterChecks(accountId, filter, paginationKey,
						pageSize);

		return iAccountsMapper.mapChecks(srvIntAccounts
				.listCheck(dtoIntFilterChecks));
	}

	@Override
	@ApiOperation(value = "Operation obtaining checkbooks related to a client's product.", notes = "----", response = Checkbook.class)
	@ApiResponses(value = {
			@ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Successfully", response = Checkbook.class),
			@ApiResponse(code = 400, message = "Request Error"),
			@ApiResponse(code = 409, message = "Functional Error"),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@Path("/{accountId}/checkbooks/{checkbookId}")
	@ElementClass(response = Checkbook.class)
	@SMC(registryID = "SMCCO1400013", logicalID = "getCheckbooks")
	public Checkbook getCheckbook(
			@ApiParam(value = "Checkbooks identifier") @PathParam("checkbookId") String checkbookId,
			@ApiParam(value = "account identifier") @PathParam("accountId") String accountId) {
		// 1. Validate parameter
		if (accountId.equals("null") || accountId == null || accountId.trim().isEmpty()) {
			throw new BusinessServiceException(
					EnumError.WRONG_PARAMETERS.getAlias());
		}
		if (checkbookId.equals("null") || checkbookId == null || checkbookId.trim().isEmpty()) {
			throw new BusinessServiceException(
					EnumError.WRONG_PARAMETERS.getAlias());
		}
		// 2. Mapping to DTOIntCheckbook
		final DTOIntCheckbook dtointCheckbook = iAccountsMapper
				.getDtoIntCheckbook(accountId, checkbookId);

		// 3. Invoke SrvIntAccount and Mapping to canonical DTO
		return iAccountsMapper.mapCheckbooks(srvIntAccounts
				.getCheckbooks(dtointCheckbook));
	}

	@Override
	@ApiOperation(value = "Operation to get the details of a check associated with a checkbook for the account associated with a client.", notes = "--", response = Check.class)
	@ApiResponses(value = {
			@ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Successfully", response = Check.class),
			@ApiResponse(code = 400, message = "Request Error"),
			@ApiResponse(code = 409, message = "Functional Error"),
			@ApiResponse(code = 500, message = "Technical Error")
	})
	@GET
	@ElementClass(response = Check.class)
	@Path("/{accountId}/checks/{checkId}")
	@SMC(registryID = "SMCCO1400020", logicalID = "getChecks")
	public Check getCheck(	@ApiParam(value = "Claim identifier param") @PathParam("accountId") String accountId,
							  @ApiParam(value = "Claim identifier param") @PathParam("checkId") String checkId) {

		// 1. Validate filter FIQL
		//	new FiqlValidator(filter).exist().hasGeAndLe("month").validate();

		// 2. Mapping to DTOIntFilter
		DTOIntCheckFilter dtoIntExecutivesFilter = iAccountsMapper.getDTOIntFilterChecks(checkId,accountId);

		// 3. Invoke SrvIntAccounts and Mapping to canonical DTO
		return iAccountsMapper.map(srvIntAccounts.getChecks(dtoIntExecutivesFilter));
	}


}

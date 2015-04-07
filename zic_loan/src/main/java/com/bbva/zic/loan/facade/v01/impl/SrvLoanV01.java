package com.bbva.zic.loan.facade.v01.impl;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.UriInfo;

import com.bbva.zic.dto.net.RotaryQuotaMove;

import com.bbva.zic.loan.business.dto.DTOIntFilterRotaryMovement;
import com.bbva.zic.loan.facade.v01.ISrvLoanV01;
import com.bbva.zic.loan.facade.v01.mappers.ILoanMapper;
import com.bbva.zic.loan.business.ISrvIntLoan;
import com.bbva.zic.loan.business.dto.DTOIntFilterLoan;
import com.bbva.zic.routine.commons.rm.utils.fiql.FiqlType;
import com.bbva.zic.routine.commons.rm.utils.validator.impl.FiqlValidator;
import org.apache.cxf.jaxrs.model.wadl.ElementClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.zic.dto.net.Loan;
import com.bbva.zic.dto.net.Movement;

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

import java.util.List;

@Path("/V01")
@SN(registryID = "SNCO1400006", logicalID = "loan")
@VN(vnn = "V01")
@Api(value = "/loan/V01", description = "SN loan")
@Produces({ MediaType.APPLICATION_JSON })
@Service
public class SrvLoanV01 implements ISrvLoanV01,	com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvLoanV01.class,"META-INF/spring/i18n/log/mensajesLog");

	public HttpHeaders httpHeaders;

	@Autowired
	BusinessServicesToolKit bussinesToolKit;

	@Resource(name = "loan-mapper")
	private ILoanMapper iLoanMapper;

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
	ISrvIntLoan isrvIntLoan;

	@ApiOperation(value = "Obtiene la informaci�n general del producto de fianciamiento", notes = "Obtiene la informaci�n general del producto de fianciamiento", response = Loan.class)
	@ApiResponses(value = {
			@ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = Loan.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@ElementClass(response = Loan.class)
	@Path("/rotaryQuota/{idLoan}")
	@SMC(registryID = "SMCCO1400010", logicalID = "getRotaryQuota")
	public Loan getRotaryQuota(
			@ApiParam(value = "Claim identifier param") @PathParam("idLoan") String idLoan) {
		log.info("Iniciado getRotaryQuota");
		return  iLoanMapper.map(isrvIntLoan.getRotaryQuota(idLoan));
	}

	@ApiOperation(value = "Obtiene un resumen de movimientos realizados sobre el producto de financiamiento. �ste servicio es paginado", notes = "Obtiene un resumen de movimientos realizados sobre el producto de financiamiento. �ste servicio es paginado", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = List.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@ElementClass(response = List.class)
	@Path("/rotaryQuota/{loanId}/movements")
	@SMC(registryID = "SMCCO1400011", logicalID = "listRotaryQuotaMovements")
	public List<Movement> listRotaryQuotaMovements(@ApiParam(value = "Loan identifier") @PathParam("loanId") String loanId,
												   @ApiParam(value = "Loan page Size") @QueryParam("pageSize") Integer pageSize,
												   @ApiParam(value = "Loan movement indicator") @QueryParam("movementInd") String movementInd,
												   @ApiParam(value = "Loan extract indicator") @QueryParam("extractInd") String extractInd,
												   @ApiParam(value = "order by param") @DefaultValue("null") @QueryParam("$filter") String filter) {

		log.info("Iniciado listRotaryQuotaMovements");
		// 1. Validate filter FIQL
		new FiqlValidator(filter).hasGeAndLe(FiqlType.transactionDate.name()).validateIfExist();

		final DTOIntFilterLoan dtoIntFilterLoan = iLoanMapper.getDtoIntFilter(filter);
		dtoIntFilterLoan.setExtractInd(extractInd);
		dtoIntFilterLoan.setMovementInd(movementInd);
		dtoIntFilterLoan.setPageSize(pageSize);
		dtoIntFilterLoan.setIdLoan(loanId);

		return iLoanMapper.map(isrvIntLoan.listRotaryQuotaMovements(dtoIntFilterLoan));
	}

	@ApiOperation(value = "Obtiene los detalles del movimiento seleccionado para el producto de financiamiento", notes = "Obtiene los detalles del movimiento seleccionado para el producto de financiamiento", response = RotaryQuotaMove.class)
	@ApiResponses(value = { @ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = RotaryQuotaMove.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@ElementClass(response = RotaryQuotaMove.class)
	@Path("/rotaryQuota/{idLoan}/movement/{idMovement}")
	@SMC(registryID = "SMCCO1400012", logicalID = "getRotaryQuotaMovement")
	public RotaryQuotaMove getRotaryQuotaMovement(
			@ApiParam(value = "Claimer identifier param") @PathParam("idLoan") String idLoan,
			@ApiParam(value = "Claimer identifier param") @PathParam("idMovement") String idMovement,
	        @ApiParam(value = "order by param") @DefaultValue("null") @QueryParam("$filter") String filter) {

		// 1. Validate filter FIQL
		new FiqlValidator(filter).hasEq(FiqlType.movementNumber.name()).validateIfExist();

		final String movementNumber =  iLoanMapper.getMovementNumber(filter);

		log.info("Iniciado getRotaryQuotaMovement");
		return iLoanMapper.map(isrvIntLoan.getRotaryQuotaMovement(new DTOIntFilterRotaryMovement(idLoan, Integer.parseInt(idMovement), movementNumber)));
	}
}

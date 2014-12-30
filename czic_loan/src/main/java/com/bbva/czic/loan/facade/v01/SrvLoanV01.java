package com.bbva.czic.loan.facade.v01;

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

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.dto.net.RotaryQuotaMove;
import com.bbva.czic.loan.business.ISrvIntLoan;
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
@SN(registryID = "SN201400006", logicalID = "loan")
@VN(vnn = "V01")
@Api(value = "/loan/V01", description = "SN loan")
@Produces({ MediaType.APPLICATION_JSON })
@Service
public class SrvLoanV01 implements ISrvLoanV01, com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvLoanV01.class, "META-INF/spring/i18n/log/mensajesLog");

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
	ISrvIntLoan srvIntLoan;

	@Override
	@ApiOperation(value = "Obtiene la informaci�n general del producto de fianciamiento", notes = "Obtiene la informaci�n general del producto de fianciamiento", response = Loan.class)
	@ApiResponses(value = { @ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = Response.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@Path("/rotaryQuota/{idLoan}")
	@SMC(registryID = "SMC201400010", logicalID = "getRotaryQuota")
	public Loan getRotaryQuota(@ApiParam(value = "Claim identifier param") @PathParam("idLoan") String idLoan) {
		return srvIntLoan.getRotaryQuota(idLoan);
	}

	@Override
	@ApiOperation(value = "Obtiene un resumen de movimientos realizados sobre el producto de financiamiento. �ste servicio es paginado", notes = "Obtiene un resumen de movimientos realizados sobre el producto de financiamiento. �ste servicio es paginado", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = Response.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@Path("/rotaryQuota/{loanId}/movements")
	@SMC(registryID = "SMC201400011", logicalID = "listRotaryQuotaMovements")
	public List<Movement> listRotaryQuotaMovements(@PathParam("loanId") String loanId,
			@ApiParam(value = "filter param") @DefaultValue("null") @QueryParam("$filter") String filter,
			@ApiParam(value = "fields param") @DefaultValue("null") @QueryParam("$fields") String fields,
			@ApiParam(value = "expands param") @DefaultValue("null") @QueryParam("$expands") String expands,
			@ApiParam(value = "order by param") @DefaultValue("null") @QueryParam("$sort") String sort) {
		return srvIntLoan.listRotaryQuotaMovements(loanId, filter, fields, expands, sort);
	}

	@Override
	@ApiOperation(value = "Obtiene los detalles del movimiento seleccionado para el producto de financiamiento", notes = "Obtiene los detalles del movimiento seleccionado para el producto de financiamiento", response = RotaryQuotaMove.class)
	@ApiResponses(value = { @ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = Response.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@Path("/rotaryQuota/{idLoan}/movement/{idMovement}")
	@SMC(registryID = "SMC201400012", logicalID = "getRotaryQuotaMovement")
	public Movement getRotaryQuotaMovement(
			@ApiParam(value = "Claimer identifier param") @PathParam("idMovement") String idMovement,
			@ApiParam(value = "Claimer identifier param") @PathParam("idLoan") String idLoan) {
		return srvIntLoan.getRotaryQuotaMovement(idMovement, idLoan);
	}
}

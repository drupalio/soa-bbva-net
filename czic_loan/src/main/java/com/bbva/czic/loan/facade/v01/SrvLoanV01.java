package com.bbva.czic.loan.facade.v01;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.czic.mapper.LoanMapper;
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
public class SrvLoanV01 implements ISrvLoanV01,
		com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvLoanV01.class,
			"META-INF/spring/i18n/log/mensajesLog");

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
	@ApiResponses(value = {
			@ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = Response.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@Path("/rotaryQuota/{idLoan}")
	@SMC(registryID = "SMC201400010", logicalID = "getRotaryQuota")
	public Loan getRotaryQuota(
			@ApiParam(value = "Claim identifier param") @PathParam("idLoan") String idLoan) {

		DTOIntLoan dtoIntLoan = srvIntLoan.getRotaryQuota(idLoan);

		Loan loan = new Loan();
		loan.setPayment(dtoIntLoan.getPayment());
		loan.setStatus(dtoIntLoan.getStatus());
		loan.setBalance(dtoIntLoan.getBalance());

		return loan;
	}

}

package com.bbva.czic.checkbooks.facade.v01;

import com.bbva.czic.checkbooks.business.ISrvIntCheckbooks;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckbook;
import com.bbva.czic.checkbooks.facade.v01.mappers.ICheckbookMapper;
import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.bbva.jee.arq.spring.core.servicing.annotations.SN;
import com.bbva.jee.arq.spring.core.servicing.annotations.VN;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.wordnik.swagger.annotations.*;
import org.apache.cxf.jaxrs.model.wadl.ElementClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/V01")
@SN(registryID = "SNCO1400007", logicalID = "checkbooks")
@VN(vnn = "V01")
@Api(value = "/checkbooks/V01", description = "SN checkbooks")
@Produces({ MediaType.APPLICATION_JSON })
@Service
public class SrvCheckbooksV01 implements ISrvCheckbooksV01, com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvCheckbooksV01.class,
			"META-INF/spring/i18n/log/mensajesLog");

	public HttpHeaders httpHeaders;

	public UriInfo uriInfo;

	@Resource(name = "checkbooks-mapper")
	private ICheckbookMapper checkbookMapper;

	@Override
	public void setUriInfo(UriInfo ui) {
		this.uriInfo = ui;
	}

	@Override
	public void setHttpHeaders(HttpHeaders httpHeaders) {
		this.httpHeaders = httpHeaders;
	}

	@Autowired
	ISrvIntCheckbooks srvIntCheckbooks;

	@Override
	@ApiOperation(value = "Operation obtaining checkbooks related to a client's product.", notes = "----", response = Checkbook.class)
	@ApiResponses(value = {
			@ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Successfully", response = Checkbook.class),
			@ApiResponse(code = 400, message = "Request Error"),
			@ApiResponse(code = 409, message = "Functional Error"),
			@ApiResponse(code = 500, message = "Technical Error")
	})
	@GET
	@Path("{checkbookId}")
	@ElementClass(response = Checkbook.class)
	@SMC(registryID = "SMCCO1400013", logicalID = "getCheckbooks")
	public Checkbook  getCheckbook(
			@ApiParam(value = "Checkbooks identifier") @PathParam("checkbookId") String checkbookId,
			@ApiParam(value = "Checkbooks identifier") @PathParam("checkbookId") String accountId) {

		if (checkbookId == "checks" || checkbookId.equals("checks")){
			throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias());
		}

		final DTOIntCheckbook intCheckbook = new DTOIntCheckbook();
		intCheckbook.setId(checkbookId);
		intCheckbook.setNumeroCuenta(accountId);
		return checkbookMapper.map(srvIntCheckbooks.getCheckbooks(intCheckbook));
	}


	@Override
	@ApiOperation(value = "Operation to get the details of a check associated with a checkbook for the account associated with a client.", notes = "--", response = Check.class)
	@ApiResponses(value = {
			@ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Successfully", response = List.class),
			@ApiResponse(code = 400, message = "Request Error"),
			@ApiResponse(code = 409, message = "Functional Error"),
			@ApiResponse(code = 500, message = "Technical Error")
	})
	@GET
	@ElementClass(response = Check.class)
	@Path("/checks/{checkId}")
	@SMC(registryID = "SMCCO1400014", logicalID = "getChecks")
	public Check getCheck(
			@ApiParam(value = "Claim identifier param") @PathParam("checkId") String checkId) {

		final DTOIntCheck intCheck = new DTOIntCheck();
		intCheck.setId(checkId);
		return checkbookMapper.map(srvIntCheckbooks.getChecks(intCheck));

	}

}
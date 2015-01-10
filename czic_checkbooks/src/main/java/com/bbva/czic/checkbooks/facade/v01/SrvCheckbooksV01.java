package com.bbva.czic.checkbooks.facade.v01;

import java.util.Calendar;
import java.util.List;

import javax.persistence.IdClass;
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

import com.bbva.czic.dto.net.Checkbook;
import com.bbva.czic.dto.net.EnumCheckStatus;

import org.apache.cxf.jaxrs.model.wadl.ElementClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.checkbooks.business.ISrvIntCheckbooks;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.business.dto.DTOIntEnumCheckbookStatus;
import com.bbva.czic.checkbooks.business.dto.DTOIntEnumCheckStatus;
import com.bbva.czic.dto.net.Check;
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
@SN(registryID = "SNCO1400007", logicalID = "checkbooks")
@VN(vnn = "V01")
@Api(value = "/checkbooks/V01", description = "SN checkbooks")
@Produces({ MediaType.APPLICATION_JSON })
@Service
public class SrvCheckbooksV01 implements ISrvCheckbooksV01, com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvCheckbooksV01.class,
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
	ISrvIntCheckbooks srvIntCheckbooks;

	@Override
	@ApiOperation(value = "Operation obtaining checkbooks related to a client's product.", notes = "----", response = Checkbook.class)
	@ApiResponses(value = { @ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = List.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@Path("{checkbookId}")
	@ElementClass(response = Checkbook.class)
	@SMC(registryID = "SMCCO1400013", logicalID = "getCheckbooks")
	public List<Checkbook>  getCheckbooks(
			@ApiParam(value = "Checkbooks identifier") @PathParam("checkbookId") String idCheckbook) {
		return srvIntCheckbooks.getCheckbooks(idCheckbook);
	}


	@Override
	@ApiOperation(value = "Operation to get the details of the checks associated with a checkbook for the account associated with a client. This service is paginated", notes = "--", response = Check.class)
	@ApiResponses(value = { @ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 400, message = "wrongParameters"),
			@ApiResponse(code = 409, message = "NoData")
		 })
	@GET
	@ElementClass(response = Check.class)
	@Path("/checks/{checkId}")
	@SMC(registryID = "SMCCO1400014", logicalID = "getChecks")
	public List<Check> getChecks(
			@ApiParam(value = "Claim identifier param") @PathParam("checkId") String id,
			@ApiParam(value = "filter param") @DefaultValue("null") @QueryParam("$filter") String filter,
			//@ApiParam(value = "filter param") @DefaultValue("null") @QueryParam("$filter") Calendar fechini,
			//@ApiParam(value = "filter param") @DefaultValue("null") @QueryParam("$filter") Calendar fechfin,
			//@ApiParam(value = "fields param") @DefaultValue("null") @QueryParam("$filter") EnumCheckStatus status,
			@ApiParam(value = "fields param") @DefaultValue("null") @QueryParam("$fields") Integer indpagi,
			@ApiParam(value = "expands param") @DefaultValue("null") @QueryParam("$expands") Integer tampagi) {
		
				 return srvIntCheckbooks.getChecks(id, filter, indpagi, tampagi);
						 
	}
				
}
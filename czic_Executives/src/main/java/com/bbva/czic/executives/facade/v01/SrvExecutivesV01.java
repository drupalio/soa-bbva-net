package com.bbva.czic.executives.facade.v01;

import com.bbva.czic.dto.net.Executive;
import com.bbva.czic.executives.business.ISrvIntExecutives;
import com.bbva.czic.executives.dao.GetExecutiveMapper;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.bbva.jee.arq.spring.core.servicing.annotations.SN;
import com.bbva.jee.arq.spring.core.servicing.annotations.VN;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;
import com.wordnik.swagger.annotations.*;
import org.apache.cxf.jaxrs.model.wadl.ElementClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/V01")
@SN(registryID = "SNCO1400005", logicalID = "executives")
@VN(vnn = "V01")
@Api(value = "/executives/V01", description = "Executive REST service.")
@Produces({ MediaType.APPLICATION_JSON })
@Service
public class SrvExecutivesV01 implements ISrvExecutivesV01,
		com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

	private static I18nLog log = I18nLogFactory.getLogI18n(
			SrvExecutivesV01.class, "META-INF/spring/i18n/log/mensajesLog");

	public HttpHeaders httpHeaders;

	@Autowired
	BusinessServicesToolKit businessToolKit;

	public UriInfo uriInfo;

	@Autowired
	ISrvIntExecutives iSrvIntExecutives;

	@Override
	public void setUriInfo(UriInfo ui) {
		this.uriInfo = ui;
	}

	@Override
	public void setHttpHeaders(HttpHeaders httpHeaders) {
		this.httpHeaders = httpHeaders;
	}

	@Autowired
	ISrvIntExecutives srvIntExecutives;

	@ApiOperation(value = "Servicio multicanal getExecutive", notes = "Servicio multicanal getExecutive", response = Executive.class)
	@ApiResponses(value = {
			@ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = Executive.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@ElementClass(response = Executive.class)
	@SMC(registryID = "SMCCO1400009", logicalID = "executives")
	public Executive getExecutive(
			@ApiParam(value = "filter param") @DefaultValue("null") @QueryParam("$filter") String filter,
			@ApiParam(value = "fields param") @DefaultValue("null") @QueryParam("$fields") String fields,
			@ApiParam(value = "expands param") @DefaultValue("null") @QueryParam("$expands") String expands,
			@ApiParam(value = "order by param") @DefaultValue("null") @QueryParam("$sort") String sort) {

		return GetExecutiveMapper.mapOuter(iSrvIntExecutives
				.getExecutive(filter));
	}

}
package com.bbva.czic.executives.facade.v01.impl;

import javax.annotation.Resource;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.apache.cxf.jaxrs.model.wadl.ElementClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.dto.net.Executive;
import com.bbva.czic.executives.business.ISrvIntExecutives;
import com.bbva.czic.executives.business.dto.DTOIntExecutivesFilter;
import com.bbva.czic.executives.facade.v01.ISrvExecutivesV01;
import com.bbva.czic.executives.facade.v01.mapper.IExecutivesMapper;
import com.bbva.czic.routine.commons.rm.utils.validator.impl.FiqlValidator;
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

	@Resource(name = "executives-mapper")
	private IExecutivesMapper iExecutivesMapper;

	@Autowired
	BusinessServicesToolKit businessToolKit;

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

		// 1. Validate filter FIQL
		new FiqlValidator(filter).exist().hasEq("id").hasEq("type").validate();

		// 2. Mapping to DTOIntFilter
		DTOIntExecutivesFilter dtoIntExecutivesFilter = iExecutivesMapper.getDTOIntFilter(filter);

		// 3. Invoke SrvIntAccounts and Mapping to canonical DTO
		return iExecutivesMapper.map(srvIntExecutives.getExecutive(dtoIntExecutivesFilter));
	}

}
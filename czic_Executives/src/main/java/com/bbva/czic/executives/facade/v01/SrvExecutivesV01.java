package com.bbva.czic.executives.facade.v01;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.bbva.jee.arq.spring.core.servicing.annotations.SN;
import com.bbva.jee.arq.spring.core.servicing.annotations.VN;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import com.wordnik.swagger.jaxrs.PATCH;

import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

import com.bbva.czic.dto.net.Office;
import com.bbva.czic.dto.net.Executive;
import com.bbva.czic.dto.net.ThirdParty;
import com.bbva.czic.dto.net.EnumThirdPartyType;
import com.bbva.czic.dto.net.User;
import com.bbva.czic.executives.business.ISrvIntExecutives;


	
@Path("/V01")
@SN(registryID="SN201400005",logicalID="Executives")
@VN(vnn="V01")
@Api(value="/Executives/V01",description="Executive REST service.")
@Produces({ MediaType.APPLICATION_JSON})
@Service

	
public class SrvExecutivesV01 implements ISrvExecutivesV01, com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvExecutivesV01.class,"META-INF/spring/i18n/log/mensajesLog");

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
	ISrvIntExecutives srvIntExecutives;

	
	@ApiOperation(value="Servicio multicanal getExecutive", notes="Servicio multicanal getExecutive",response=Response.class)
	@ApiResponses(value = {
		@ApiResponse(code = -1, message = "aliasGCE1"),
		@ApiResponse(code = -1, message = "aliasGCE2"),
		@ApiResponse(code = 200, message = "Found Sucessfully", response=Response.class),
		@ApiResponse(code = 500, message = "Technical Error")})
	@GET
	@SMC(registryID="SMC201400009",logicalID="executives")
	public Response executives(@ApiParam(value="filter param")@DefaultValue("null") @QueryParam("$filter") String filter, @ApiParam(value="fields param")@DefaultValue("null") @QueryParam("$fields") String fields, @ApiParam(value="expands param")@DefaultValue("null") @QueryParam("$expands") String expands, @ApiParam(value="order by param")@DefaultValue("null") @QueryParam("$sort") String sort) {
		//TODO: autogenerated, complete implementation using internal service
		return null;
	}

	

}

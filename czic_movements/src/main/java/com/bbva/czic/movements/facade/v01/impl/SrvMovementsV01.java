package com.bbva.czic.movements.facade.v01.impl;

import com.bbva.czic.dto.net.AccMoveDetail;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.movements.business.ISrvIntMovements;
import com.bbva.czic.movements.business.dto.DTOIntMovementsFilter;
import com.bbva.czic.movements.facade.v01.ISrvMovementsV01;
import com.bbva.czic.movements.facade.v01.mapper.IMovementsMapper;
import com.bbva.czic.movements.facade.v01.utils.converter.IFilterConverter;
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

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;


@Path("/V01")
@SN(registryID="SN201500001",logicalID="movements")
@VN(vnn="V01")
@Api(value="/movements/V01",description="SN movements")
@Produces({ MediaType.APPLICATION_JSON})
@Service

	
public class SrvMovementsV01 implements ISrvMovementsV01, com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvMovementsV01.class,"META-INF/spring/i18n/log/mensajesLog");

	public HttpHeaders httpHeaders;
	
	@Autowired
	BusinessServicesToolKit bussinesToolKit;

	@Resource(name = "movements-filter")
	private IFilterConverter movFilterConverter;


	@Resource(name = "accounts-mapper")
	private IMovementsMapper iMovementsMapper;

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
	ISrvIntMovements srvIntMovements;


	@Override
	@ApiOperation(value="Consulta que trae la informaci�n detallada de un movimiento realizado sobre una cuenta", notes="Consulta de movimiento",response=Movement.class)
	@ApiResponses(value = {
			@ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response=Response.class),
			@ApiResponse(code = 400, message = "Wrong parameters"),
			@ApiResponse(code = 409, message = "Data not found"),
			@ApiResponse(code = 500, message = "Technical Error")})
	@GET
	@Path("/movements/V01/{movementId}")
	@Produces({MediaType.APPLICATION_JSON})
	@ElementClass(response = AccMoveDetail.class)
	@SMC(registryID="SMC201500001",logicalID="getMovement")
	public Movement getMovement(@ApiParam(value = "identifier param") @PathParam("idMovement") String idMovement,
									 @ApiParam(value = "filter param") @DefaultValue("null") @QueryParam("$filter") String filter) {
		log.info("Into getMovement...");
		log.info("getMovement params: " + idMovement + ", " + filter);

		if(idMovement == null || idMovement.trim().isEmpty()
				|| filter == null || filter.isEmpty()){
			throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias());
		}

		DTOIntMovementsFilter dtoIntMovementsFilter =	movFilterConverter.dtoIntMovementsFilter(filter,idMovement);

		return  iMovementsMapper.movementMap(srvIntMovements.getMovement(dtoIntMovementsFilter));
	}


	@Override
	@ApiOperation(value="Operacion que lista los movimientos asociados a un producto y tipo en particular segun los parametros de busqueda, en el caso de que no se envie nungun parametro retornara los movimientos asociados que esten almacenados en backend.", notes="Listado de movimientos",response=Movement.class)
	@ApiResponses(value = {
		@ApiResponse(code = -1, message = "aliasGCE1"),
		@ApiResponse(code = -1, message = "aliasGCE2"),
		@ApiResponse(code = 200, message = "Found Sucessfully", response=Response.class),
		@ApiResponse(code = 400, message = "Wrong parameters"),
		@ApiResponse(code = 409, message = "Data not found"),
		@ApiResponse(code = 500, message = "Technical Error")})
	@GET
	@Path("/movements/V01")
	@ElementClass(response = List.class)
	@SMC(registryID="SMC201500002",logicalID="listMovements")
	public Movement listMovements(@ApiParam(value = "identifier param") @PathParam("id") String idMovement,
								  @ApiParam(value = "filter param") @DefaultValue("null") @QueryParam("$filter") String filter,
								  @ApiParam(value = "pagination key") @DefaultValue("null") @QueryParam("paginationKey") Integer paginationKey,
								  @ApiParam(value = "pagination size") @DefaultValue("null") @QueryParam("pageSize") Integer pageSize) {
		//TODO: autogenerated, complete implementation using internal service
		return null;
	}

	

}

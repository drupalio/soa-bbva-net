package com.bbva.czic.internationalcontracttransfer.facade.v01.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.dto.net.InternationalContractTransfer;
import com.bbva.czic.internationalcontracttransfer.business.ISrvIntInternationalContractTransfer;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntFilterInternationalContractTransfers;
import com.bbva.czic.internationalcontracttransfer.facade.v01.ISrvInternationalContractTransferV01;
import com.bbva.czic.internationalcontracttransfer.facade.v01.mapper.IInternationalContractTransferMapper;
import com.bbva.czic.routine.commons.rm.utils.validator.impl.FiqlValidator;
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
@SN(registryID = "SN201500333", logicalID = "internationalContractTransfer")
@VN(vnn = "V01")
@Api(value = "/internationalContractTransfer/V01", description = "SN internationalContractTransfer")
@Produces({ MediaType.APPLICATION_JSON })
@Service
public class SrvInternationalContractTransferV01 implements ISrvInternationalContractTransferV01,
		com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

	private static Log log = LogFactory.getLog(SrvInternationalContractTransferV01.class);

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
	ISrvIntInternationalContractTransfer srvIntInternationalContractTransfer;

	@Resource(name = "internationalContractTransfer-mapper")
	private IInternationalContractTransferMapper internationalMapper;

	@Override
	@ApiOperation(value = "Operacion que lista todas las transacciones internacionales del cliente", notes = "Consulta de operaciones", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = Response.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@SMC(registryID = "SMC201500334", logicalID = "listInternationalContractTransfer")
	public List<InternationalContractTransfer> listInternationalContractTransfer(
			@ApiParam(value = "filter param") @DefaultValue("null") @QueryParam("$filter") String filter,
			@ApiParam(value = "senderContractParticipantsId") @DefaultValue("null") @QueryParam("senderContractParticipantsId") String senderContractParticipantsId,
			@ApiParam(value = "pagination key") @DefaultValue("null") @QueryParam("paginationKey") Integer paginationKey,
			@ApiParam(value = "pagination size") @DefaultValue("null") @QueryParam("pageSize") Integer pageSize,
			@ApiParam(value = "expands param") @DefaultValue("null") @QueryParam("$expands") String expands) {

		// 1. Validate filter
		new FiqlValidator(filter).hasEq("referencesValue").hasEq("typeName").hasGeAndLe("date").validateAny();

		// Mapeo del filtro a DTO
		DTOIntFilterInternationalContractTransfers intFilterInternational = internationalMapper.map(filter,
				senderContractParticipantsId, paginationKey, pageSize, expands);

		// 3. Invoke SrvIntCustomers and Mapping to canonical DTO
		return internationalMapper.mapList(srvIntInternationalContractTransfer
				.listInternationalContractTransfer(intFilterInternational));

	}
}

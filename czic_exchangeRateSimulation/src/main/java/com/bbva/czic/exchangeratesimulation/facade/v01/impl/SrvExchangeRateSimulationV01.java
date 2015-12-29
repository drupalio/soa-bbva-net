package com.bbva.czic.exchangeratesimulation.facade.v01.impl;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.dto.net.ExchangeRateSimulation;
import com.bbva.czic.exchangeratesimulation.business.ISrvIntExchangeRateSimulation;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntExchangeRateSimulation;
import com.bbva.czic.exchangeratesimulation.facade.v01.ISrvExchangeRateSimulationV01;
import com.bbva.czic.exchangeratesimulation.facade.v01.mapper.IExchangeRateSimulationMapper;
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
@SN(registryID = "SN201500333", logicalID = "exchangeRateSimulation")
@VN(vnn = "V01")
@Api(value = "/exchangeRateSimulation/V01", description = "SN exchangeRateSimulation")
@Produces({ MediaType.APPLICATION_JSON })
@Service
public class SrvExchangeRateSimulationV01 implements ISrvExchangeRateSimulationV01,
		com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

	private static Log log = LogFactory.getLog(SrvExchangeRateSimulationV01.class);

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

	@Resource(name = "exchangeRateSimulation-mapper")
	public IExchangeRateSimulationMapper exchangeRateMapper;

	@Autowired
	ISrvIntExchangeRateSimulation srvIntExchangeRateSimulation;

	@Override
	@ApiOperation(value = "Operación que obtiene las tasas vigentes en el momento o las tasas de un avance de operacion", notes = "Consulta de tasas", response = ExchangeRateSimulation.class)
	@ApiResponses(value = { @ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Added Sucessfully", response = Response.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@POST
	@Path("/{simulateId}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@SMC(registryID = "SMC201500334", logicalID = "getExchangeRateSimulation")
	public ExchangeRateSimulation getExchangeRateSimulation(
			@ApiParam(value = "Simulate identifier param") @PathParam("simulateId") String simulateId,
			@ApiParam(value = "exchangeRate information", required = true) ExchangeRateSimulation exchangeRateSimulation) {

		// 2. Mapping to DTOIntExchangeRateSimulation
		DTOIntExchangeRateSimulation dtoIntExchangeRate = exchangeRateMapper.map(exchangeRateSimulation);
		dtoIntExchangeRate.setId(simulateId);

		// 3. Invoke SrvIntAccounts and Mapping to canonical DTO
		DTOIntExchangeRateSimulation resultado = srvIntExchangeRateSimulation
				.getExchangeRateSimulation(dtoIntExchangeRate);
		return exchangeRateMapper.map(resultado);
	}
}

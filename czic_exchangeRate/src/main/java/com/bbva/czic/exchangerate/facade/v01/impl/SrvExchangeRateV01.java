package com.bbva.czic.exchangerate.facade.v01.impl;

import java.math.BigDecimal;

import javax.annotation.Resource;
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

import com.bbva.czic.dto.net.ExchangeRate;
import com.bbva.czic.exchangerate.business.ISrvIntExchangeRate;
import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRateFilter;
import com.bbva.czic.exchangerate.facade.v01.ISrvExchangeRateV01;
import com.bbva.czic.exchangerate.facade.v01.mapper.IExchangeRateMapper;
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
@SN(registryID = "SN201500333", logicalID = "exchangeRate")
@VN(vnn = "V01")
@Api(value = "/exchangeRate/V01", description = "SN exchangeRate")
@Produces({ MediaType.APPLICATION_JSON })
@Service
public class SrvExchangeRateV01 implements ISrvExchangeRateV01,
		com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

	private static Log log = LogFactory.getLog(SrvExchangeRateV01.class);

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

	@Resource(name = "exchange-mapper")
	public IExchangeRateMapper exchangeRateMapper;

	@Autowired
	ISrvIntExchangeRate srvIntExchangeRate;

	@Override
	@ApiOperation(value = "Operaci�n que obtiene las tasas vigentes en el momento o las tasas de un avance de operaci�n", notes = "Consulta de tasas", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = Response.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@SMC(registryID = "SMC201500334", logicalID = "getExchangeRate")
	public ExchangeRate getExchangeRate(
			@ApiParam(value = "rate currency") @QueryParam("$exchangeRateCurrency") String exchangeRateCurrency,
			@ApiParam(value = "filter param") @QueryParam("$customer.id") String customerId,
			@ApiParam(value = "fields param") @QueryParam("$exchangeRateValues.purchaseValue.amount") BigDecimal purchaseValueAmount,
			@ApiParam(value = "expands param") @QueryParam("exchangeRateValues.saleValue.amount") BigDecimal saleValueAmount) {

		// 2. Mapping to DTOIntFilter
		DTOIntExchangeRateFilter dtoIntExchangeRateFilter = exchangeRateMapper.map(exchangeRateCurrency, customerId,
				purchaseValueAmount, saleValueAmount);

		// 3. Invoke SrvIntAccounts and Mapping to canonical DTO
		return exchangeRateMapper.map(srvIntExchangeRate.getExchangeRate(dtoIntExchangeRateFilter));
	}
}

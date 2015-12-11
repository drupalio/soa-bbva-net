package com.bbva.czic.currency.facade.v01.impl;

import javax.annotation.Resource;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

import com.bbva.czic.currency.facade.v01.ISrvCurrencyV01;
import com.bbva.czic.currency.facade.v01.mapper.IMapper;
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

import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

import com.bbva.czic.dto.net.Currency;
import com.bbva.czic.currency.business.ISrvIntCurrency;

import java.util.List;


@Path("/V01")
@SN(registryID="SN123456789",logicalID="currency")
@VN(vnn="V01")
@Api(value="/currency/V01",description="SN Customer")
@Produces({ MediaType.APPLICATION_JSON})
@Service

	
public class SrvCurrencyV01 implements ISrvCurrencyV01, com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvCurrencyV01.class,"META-INF/spring/i18n/log/mensajesLog");

	public HttpHeaders httpHeaders;
	
	@Autowired
	BusinessServicesToolKit bussinesToolKit;

	@Resource(name = "CurrencyMapper")
	private IMapper iMapper;

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
	ISrvIntCurrency srvIntCurrency;

	
	@ApiOperation(value="Operacion que retorna todos los tipos de monedas o divisas que hay (COP-Peso colombiano,EUR-Euro...etc)", notes="Operaci�n que retorna todos los tipos de monedas o divisas que hay (COP-Peso colombiano,EUR-Euro...etc)",response=List.class)
	@ApiResponses(value = {
		@ApiResponse(code = -1, message = "aliasGCE1"),
		@ApiResponse(code = -1, message = "aliasGCE2"),
		@ApiResponse(code = 200, message = "Found Sucessfully", response=Response.class),
		@ApiResponse(code = 400, message = "Wrong Parameter"),
		@ApiResponse(code = 500, message = "Technical Error")})
	@GET
	@SMC(registryID="SMC234567890",logicalID="listCurrencies")
	public List<Currency> listCurrencies() {
		return iMapper.MapOutListCurrency(srvIntCurrency.listCurrencies());
	}

	

}

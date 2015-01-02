package com.bbva.czic.customers.facade.v01;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.customers.business.ISrvIntCustomers;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
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
@SN(registryID="SNCO1400003",logicalID="customers")
@VN(vnn="V01")
@Api(value="/customers/V01",description="SN Customer")
@Produces({ MediaType.APPLICATION_JSON})
@Service

	
public class SrvCustomersV01 implements ISrvCustomersV01, com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvCustomersV01.class,"META-INF/spring/i18n/log/mensajesLog");

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
	ISrvIntCustomers srvIntCustomers;

	
	@ApiOperation(value="Returns the relationship between consumption and / or expenses of the customer in different business scopes", notes="these are ordered items for all credit cards a client.",response=List.class)
	@ApiResponses(value = {
		@ApiResponse(code = -1, message = "aliasGCE1"),
		@ApiResponse(code = -1, message = "aliasGCE2"),
		@ApiResponse(code = 200, message = "Found Sucessfully", response=Response.class),
		@ApiResponse(code = 500, message = "Technical Error")})
	
	
	@GET
	@Path("/{idUser}/cardCharges")
	@SMC(registryID="SMCCO1400006",logicalID="getlistCreditCardsCharges")
	public List<CardCharge> getlistCreditCardsCharges(
		@ApiParam(value = "Claim identifier param") @PathParam("numprod") String idUser,
		@ApiParam(value = "Claim identifier param") @QueryParam("fechain") String fechain,
		@ApiParam(value = "Claim identifier param") @QueryParam("fechafi") String fechafi){
		return srvIntCustomers.getlistCreditCharges(idUser, fechain, fechafi);
	}
		
	@ApiOperation(value="Returns the list of summaries of balance all customer accounts per month", notes="(income, expenses and balance)",response=List.class)
	@ApiResponses(value = {
		@ApiResponse(code = -1, message = "aliasGCE1"),
		@ApiResponse(code = -1, message = "aliasGCE2"),
		@ApiResponse(code = 200, message = "Found Sucessfully", response=Response.class),
		@ApiResponse(code = 500, message = "Technical Error")})
	@GET
	@Path("/{idUser}/accMovementsResumes")
	@SMC(registryID="SMCCO1400007",logicalID="getlistAccountsMovementsResume")
	public List<AccMovementsResume> getlistAccountsMovementsResume(
		@ApiParam(value = "Claim identifier param") @PathParam("idUser") String idUser,
		@ApiParam(value = "Claim identifier param") @QueryParam("fechain") String fechain,
		@ApiParam(value = "Claim identifier param") @QueryParam("fechafi") String fechafi){
		return srvIntCustomers.getlistAccountsMovementsResume(idUser, fechain, fechafi);
	}

	

}



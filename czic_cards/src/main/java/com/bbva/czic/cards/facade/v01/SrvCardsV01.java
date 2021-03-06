package com.bbva.czic.cards.facade.v01;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

import com.bbva.czic.cards.business.dto.DTOIntFilterCards;
import com.bbva.czic.cards.facade.v01.mapper.ICardsMapper;
import com.bbva.czic.routine.commons.rm.utils.validator.impl.FiqlValidator;
import org.apache.cxf.jaxrs.model.wadl.ElementClass;
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
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.cards.business.CardsMapper;
import com.bbva.czic.cards.business.ISrvIntCards;
import com.bbva.czic.cards.business.dto.DTOIntCardCharge;

@Path("/V01")
@SN(registryID = "SNCO1400004", logicalID = "cards")
@VN(vnn = "V01")
@Api(value = "/cards/V01", description = "CardCharge REST service.")
@Produces({ MediaType.APPLICATION_JSON })
@Service
public class SrvCardsV01 implements ISrvCardsV01,
		com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvCardsV01.class,
			"META-INF/spring/i18n/log/mensajesLog");

	public HttpHeaders httpHeaders;

	@Resource(name = "cards-mapper")
	ICardsMapper cardsMapper;

	@Autowired
	ISrvIntCards iSrvIntCards;

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
	ISrvIntCards srvIntCards;

	@ApiOperation(value = "Servicio multicanal de cards", notes = "Servicio multicanal de cards", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = List.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@ElementClass(response = List.class)
	@Path("creditCard/{id}/cardCharges")
	@SMC(registryID = "SMCCO1400008", logicalID = "getCreditCardCharges")
	public List<CardCharge> getCreditCardCharges(
			@ApiParam(value = "CreditCard identifier") @PathParam("id") String id,
			@ApiParam(value = "filter param") @DefaultValue("null") @QueryParam("$filter") String filter,
			@ApiParam(value = "fields param") @DefaultValue("null") @QueryParam("fields") String fields,
			@ApiParam(value = "expands param") @DefaultValue("null") @QueryParam("expands") String expands,
			@ApiParam(value = "order by param") @DefaultValue("null") @QueryParam("sort") String sort) {

		new FiqlValidator(filter).exist().hasGeAndLe("chargeDate").validate();

		final DTOIntFilterCards dtoFilter = cardsMapper.map(id,filter);

		return cardsMapper.map(iSrvIntCards.getCreditCardCharges(dtoFilter));
	}
}

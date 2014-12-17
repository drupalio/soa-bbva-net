package com.bbva.czic.globalposition.facade.v01;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
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

import com.bbva.czic.dto.canonicaldto.Product;
import com.bbva.czic.globalposition.business.ISrvIntGlobalPosition;
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
<<<<<<< HEAD
@SN(registryID = "SN201400333", logicalID = "GlobalPosition")
@VN(vnn = "V01")
@Api(value = "/GlobalPosition/V01", description = "SN GlobalPosition")
@Produces({ MediaType.APPLICATION_JSON })
=======
@SN(registryID="SNCO1400002",logicalID="GlobalPosition")
@VN(vnn="V01")
@Api(value="/GlobalPosition/V01",description="SN GlobalPosition")
<<<<<<< HEAD
@Produces({ MediaType.APPLICATION_JSON })
@Service
public class SrvGlobalPositionV01 implements ISrvGlobalPositionV01, com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvGlobalPositionV01.class,"META-INF/spring/i18n/log/mensajesLog");
=======
@Produces({ MediaType.APPLICATION_JSON})
>>>>>>> f28cd92075cd1dde70c5fe52f78de1f956f39c53
@Service
public class SrvGlobalPositionV01 implements ISrvGlobalPositionV01,
		com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvGlobalPositionV01.class,
			"META-INF/spring/i18n/log/mensajesLog");
>>>>>>> c88cf536a882fb4e3e39e3f1c0ec90dc52f0fd26

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
	ISrvIntGlobalPosition srvIntGlobalPosition;

	@Override
	@ApiOperation(value = "Gets all the users products", notes = "List of products that COULD be filtered by product type.", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = Response.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@Path("/customers/{customerId}/products")
<<<<<<< HEAD
	@SMC(registryID = "SMC201400335", logicalID = "getExtractGlobalBalance")
	public List<Product> getExtractGlobalBalance(
			@PathParam("customerId") String customerId,
			@ApiParam(value = "filter param") @DefaultValue("(productType=={productType})") @QueryParam("$filter") String filter,
			@ApiParam(value = "fields param") @DefaultValue("null") @QueryParam("$fields") String fields,
			@ApiParam(value = "expands param") @DefaultValue("null") @QueryParam("$expands") String expands,
			@ApiParam(value = "order by param") @DefaultValue("null") @QueryParam("$sort") String sort) {
		// TODO: autogenerated, complete implementation using internal service
=======
	@Produces({ MediaType.APPLICATION_JSON })
	@SMC(registryID="SMCCO1400003",logicalID="getExtractGlobalBalance")
	public List<Product> getExtractGlobalBalance(@PathParam("customerId") String customerId, @ApiParam(value="filter param")@DefaultValue("(productType=={productType})") @QueryParam("$filter") String filter, @ApiParam(value="fields param")@DefaultValue("null") @QueryParam("$fields") String fields, @ApiParam(value="expands param")@DefaultValue("null") @QueryParam("$expands") String expands, @ApiParam(value="order by param")@DefaultValue("null") @QueryParam("$sort") String sort) {
		//TODO: autogenerated, complete implementation using internal service

>>>>>>> f28cd92075cd1dde70c5fe52f78de1f956f39c53
		return null;
	}

	@Override
	@ApiOperation(value = "Update the product.", notes = "Update the product partially", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Modified Sucessfully", response = Response.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@PUT
	@Path("/{idProduct}")
	@Consumes({ MediaType.APPLICATION_JSON })
<<<<<<< HEAD
	@SMC(registryID="SMCCO1400020",logicalID="updateProductVisibility")
=======
<<<<<<< HEAD
	@SMC(registryID = "SMC201400334", logicalID = "update")
	public Response update(@ApiParam(value = "Claim identifier") @PathParam("idProduct") String idProduct,
			@ApiParam(value = "Claim information") Product infoProduct) {
		// TODO: autogenerated, complete implementation using internal service
=======
>>>>>>> c88cf536a882fb4e3e39e3f1c0ec90dc52f0fd26
	public Response update(@ApiParam(value="Claim identifier")@PathParam("idProduct") String idProduct, @ApiParam(value="Claim information")Product infoProduct) {

		return null;
	}

	@SMC(registryID="SMCCO1400004",logicalID="updateProductVisibility")
	private Response updateProductVisibility(){

		return null;
	}

	@SMC(registryID="SMCCO1400005",logicalID="updateProductOperability")
	private Response updateProductOperability(){

>>>>>>> f28cd92075cd1dde70c5fe52f78de1f956f39c53
		return null;
	}

}

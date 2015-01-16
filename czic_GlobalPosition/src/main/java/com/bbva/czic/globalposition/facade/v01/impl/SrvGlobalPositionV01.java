package com.bbva.czic.globalposition.facade.v01.impl;

import java.util.List;

import javax.annotation.Resource;
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

import org.apache.cxf.jaxrs.model.wadl.ElementClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.dto.net.Product;
import com.bbva.czic.globalposition.business.ISrvIntGlobalPosition;
import com.bbva.czic.globalposition.business.dto.DTOIntFilterProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.facade.v01.ISrvGlobalPositionV01;
import com.bbva.czic.globalposition.facade.v01.mapper.IGlobalPositionMapper;
import com.bbva.czic.globalposition.facade.v01.utils.converters.IFilterConverter;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.bbva.jee.arq.spring.core.servicing.annotations.SN;
import com.bbva.jee.arq.spring.core.servicing.annotations.VN;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("/V01")
@SN(registryID = "SNCO1400002", logicalID = "GlobalPosition")
@VN(vnn = "V01")
@Api(value = "/GlobalPosition/V01", description = "SN GlobalPosition")
@Produces({ MediaType.APPLICATION_JSON })
@Service
public class SrvGlobalPositionV01 implements ISrvGlobalPositionV01,
		com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvGlobalPositionV01.class,
			"META-INF/spring/i18n/log/mensajesLog");

	public HttpHeaders httpHeaders;

	@Resource(name = "global-position-filter-converter")
	private IFilterConverter gpFilterConverter;

	@Resource(name = "global-position-mapper")
	private IGlobalPositionMapper globalPositionMapper;

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
	@ApiOperation(value = "Gets all the users products", notes = "List of products that COULD be filtered by product type.", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = -1, message = "wrongParameters"),
			@ApiResponse(code = -1, message = "noData"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = List.class),
			@ApiResponse(code = 500, message = "Technical Error"),
			@ApiResponse(code = 400, message = "wrongParameters"), @ApiResponse(code = 409, message = "noData") })
	@GET
	@Path("/customers/{customerId}/products")
	@Produces({ MediaType.APPLICATION_JSON })
	@ElementClass(response = List.class)
	@SMC(registryID = "SMCCO1400003", logicalID = "getExtractGlobalBalance")
	public List<Product> getExtractGlobalBalance(
			@ApiParam(value = "Customer identifier") @PathParam("customerId") String customerId,
			@ApiParam(value = "filter param") @DefaultValue("null") @QueryParam("$filter") String filter) {

		log.info("SrvGlobalPositionV01.getExtractGlobalBalance : HOT SWAP");

		final DTOIntFilterProduct filterProduct = gpFilterConverter.getDTOIntFilter(customerId, filter);
		List<DTOIntProduct> products = srvIntGlobalPosition.getExtractGlobalBalance(filterProduct);

		return globalPositionMapper.map(products);
	}

	@Override
	@ApiOperation(value = "Update the product.", notes = "Update the product partially", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = -1, message = "wrongParameters"),
			@ApiResponse(code = 200, message = "Modified Sucessfully", response = Response.class),
			@ApiResponse(code = 500, message = "Technical Error"),
			@ApiResponse(code = 400, message = "wrongParameters") })
	@PUT
	@Path("/{idProduct}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response update(@ApiParam(value = "Product identifier") @PathParam("idProduct") String idProduct,
			@ApiParam(value = "Product information") Product infoProduct) {

		infoProduct.setId(idProduct);

		if (infoProduct.getVisible() != null) {
			this.updateProductVisibility(idProduct, infoProduct);
		} else if (infoProduct.getOperable() != null) {
			this.updateProductOperability(idProduct, infoProduct);
		} else {
			throw new BusinessServiceException("wrongParameters");
		}

		return Response.ok().build();
	}

	@SMC(registryID = "SMCCO1400004", logicalID = "update")
	private void updateProductVisibility(String idProduct, Product infoProduct) {

		final DTOIntProduct productInt = new DTOIntProduct();

		productInt.setId(idProduct);
		productInt.setVisible(infoProduct.getVisible());

		srvIntGlobalPosition.updateProductVisibility(productInt);
	}

	@SMC(registryID = "SMCCO1400005", logicalID = "update")
	private void updateProductOperability(String idProduct, Product infoProduct) {

		final DTOIntProduct productInt = new DTOIntProduct();

		productInt.setId(idProduct);
		productInt.setOperable(infoProduct.getOperable());

		srvIntGlobalPosition.updateProductOperability(productInt);
	}
}

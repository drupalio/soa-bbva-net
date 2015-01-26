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

import com.bbva.czic.routine.commons.rm.utils.validator.impl.FiqlValidator;
import org.apache.cxf.jaxrs.model.wadl.ElementClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.bbva.czic.dto.net.Product;
import com.bbva.czic.globalposition.business.ISrvIntGlobalPosition;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProductFilter;
import com.bbva.czic.globalposition.facade.v01.ISrvGlobalPositionV01;
import com.bbva.czic.globalposition.facade.v01.mappers.IGlobalPositionMapper;
import com.bbva.czic.globalposition.facade.v01.utils.converters.IFilterConverter;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
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

	public static final String PRODUCT_TYPE = "productType";
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

		// 1. Validate filter FIQL
		new FiqlValidator(filter).exist().hasEq(PRODUCT_TYPE).validate();

		// 2. Mapping to DTOIntFilter
		final DTOIntProductFilter filterProduct = globalPositionMapper.getDTOIntFilter(customerId, filter);

		// 3. Invoke SrvIntAccounts and Mapping to canonical DTO
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
	@Path("/{idProduct}/setProductVisibility")
	@Consumes({ MediaType.APPLICATION_JSON })
	@SMC(registryID = "SMCCO1400004", logicalID = "updateProductVisibility")
	public Response updateProductVisibility(
			@ApiParam(value = "Product identifier") @PathParam("idProduct") String idProduct,
			@ApiParam(value = "Product information") Product infoProduct) {

		final DTOIntProduct productInt = new DTOIntProduct();
		infoProduct.setId(idProduct);

		if (idProduct == null || infoProduct.getVisible() == null) {
			throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias());
		}

		productInt.setId(idProduct);
		productInt.setVisible(infoProduct.getVisible());

		srvIntGlobalPosition.updateProductVisibility(productInt);

		return Response.ok().build();
	}

	@Override
	@ApiOperation(value = "Update the product.", notes = "Update the product partially", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = -1, message = "wrongParameters"),
			@ApiResponse(code = 200, message = "Modified Sucessfully", response = Response.class),
			@ApiResponse(code = 500, message = "Technical Error"),
			@ApiResponse(code = 400, message = "wrongParameters") })
	@PUT
	@Path("/{idProduct}/setProductOperability")
	@Consumes({ MediaType.APPLICATION_JSON })
	@SMC(registryID = "SMCCO1400005", logicalID = "updateProductOperability")
	public Response updateProductOperability(
			@ApiParam(value = "Product identifier") @PathParam("idProduct") String idProduct,
			@ApiParam(value = "Product information") Product infoProduct) {

		final DTOIntProduct productInt = new DTOIntProduct();
		infoProduct.setId(idProduct);

		if (idProduct == null || infoProduct.getOperable() == null) {
			throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias());
		}
		productInt.setId(idProduct);
		productInt.setOperable(infoProduct.getOperable());

		srvIntGlobalPosition.updateProductOperability(productInt);
		return Response.ok().build();
	}
}

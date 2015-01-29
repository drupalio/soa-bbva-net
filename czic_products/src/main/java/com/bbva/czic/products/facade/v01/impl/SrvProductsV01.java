package com.bbva.czic.products.facade.v01.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.DefaultValue;
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

import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.dto.net.Extract;
import com.bbva.czic.products.business.ISrvIntProducts;
import com.bbva.czic.products.business.dto.*;
import com.bbva.czic.products.facade.v01.ISrvProductsV01;
import com.bbva.czic.products.facade.v01.mapper.IProductsMapper;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.validator.impl.FiqlValidator;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.bbva.jee.arq.spring.core.servicing.annotations.SN;
import com.bbva.jee.arq.spring.core.servicing.annotations.VN;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("/V01")
@SN(registryID = "SN201400011", logicalID = "products")
@VN(vnn = "V01")
@Api(value = "/products/V01", description = "Products REST service.")
@Produces({ MediaType.APPLICATION_JSON })
@Service
public class SrvProductsV01 implements ISrvProductsV01,
		com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

	private static I18nLog log = I18nLogFactory.getLogI18n(
			SrvProductsV01.class, "META-INF/spring/i18n/log/mensajesLog");

	public HttpHeaders httpHeaders;

	@Autowired
	BusinessServicesToolKit bussinesToolKit;

	@Resource(name = "products-mapper")
	private IProductsMapper productsMapper;

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
	ISrvIntProducts srvIntProducts;

	@ApiOperation(value = "Operaci�n  que muestra las condiciones de los productos asociados a un cliente", notes = "Operaci�n  que muestra las condiciones de los productos asociados a un cliente", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = Response.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@Path("/{productId}/conditions")
	@Produces({ MediaType.APPLICATION_JSON })
	@SMC(registryID = "SMC201400022", logicalID = "getConditions")
	public Conditions getConditions(
			@ApiParam(value = "Product identifier") @PathParam("productId") String productId) {
		// 1. Validate parameter
		if (productId == null || productId.trim().isEmpty()) {
			throw new BusinessServiceException(
					EnumError.WRONG_PARAMETERS.getAlias());
		}

		// 2. Mapping to DTOIntFilter
		final DTOIntProduct dtoIntProduct = productsMapper
				.getDtoIntConditions(productId);

		// 3. Invoke SrvIntCustomers and Mapping to canonical DTO
		return productsMapper.map(srvIntProducts.getConditions(dtoIntProduct));
	}

	@Override
	@ApiOperation(value = "Listado Extractos", notes = "Listado De Extractos ", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = Response.class),
			@ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@Path("/{productId}/listExtracts")
	@SMC(registryID = "Pending", logicalID = "listExtracts")
	public List<Extract> listExtracts(
			@ApiParam(value = "identifier param") @PathParam("id") String productId,
			@ApiParam(value = "filter param") @DefaultValue("null") @QueryParam("$filter") String filter,
			@ApiParam(value = "fields param") @DefaultValue("null") @QueryParam("paginationKey") Integer paginationKey,
			@ApiParam(value = "expands param") @DefaultValue("null") @QueryParam("pageSize") Integer pageSize) {
		// 1. Validate parameter
		if (productId == null || productId.trim().isEmpty()) {
			throw new BusinessServiceException(
					EnumError.WRONG_PARAMETERS.getAlias());
		}

		// 2. Validate filter
		new FiqlValidator(filter).exist().hasGeAndLe("month")
				.hasGeAndLe("year").validate();

		// Mapeo del filtro a DTO
		DTOIntExtract dtoIntFilterExtract = productsMapper
				.getDtoIntFilterExtract(productId, filter, paginationKey,
						pageSize);
		// 3. Invoke SrvIntCustomers and Mapping to canonical DTO
		return productsMapper.mapExtracts(srvIntProducts
				.listExtracts(dtoIntFilterExtract));
	}

}

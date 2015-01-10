package com.bbva.czic.globalposition.facade.v01.impl;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.czic.dto.net.Product;
import com.bbva.czic.globalposition.business.ISrvIntGlobalPosition;
import com.bbva.czic.globalposition.business.dto.DTOIntFilterProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.facade.v01.ISrvGlobalPositionV01;
import com.bbva.czic.globalposition.facade.v01.mapper.IGlobalPositionMapper;
import com.bbva.czic.globalposition.facade.v01.mapper.Mapper;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.bbva.jee.arq.spring.core.servicing.annotations.SN;
import com.bbva.jee.arq.spring.core.servicing.annotations.VN;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;
import com.wordnik.swagger.annotations.*;
import org.apache.cxf.jaxrs.ext.search.PrimitiveStatement;
import org.apache.cxf.jaxrs.ext.search.SearchCondition;
import org.apache.cxf.jaxrs.ext.search.SearchParseException;
import org.apache.cxf.jaxrs.ext.search.fiql.FiqlParser;
import org.apache.cxf.jaxrs.model.wadl.ElementClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;


@Path("/V01")
@SN(registryID="SNCO1400002",logicalID="GlobalPosition")
@VN(vnn="V01")
@Api(value="/GlobalPosition/V01",description="SN GlobalPosition")
@Produces({ MediaType.APPLICATION_JSON})
@Service
public class SrvGlobalPositionV01 implements ISrvGlobalPositionV01, com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvGlobalPositionV01.class,"META-INF/spring/i18n/log/mensajesLog");

	public HttpHeaders httpHeaders;
	
	@Autowired
	BusinessServicesToolKit businessToolKit;

	@Resource(name = "global-position-mapper")
	IGlobalPositionMapper globalPositionMapper;

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

	
	@ApiOperation(value="Gets all the users products", notes="List of products that COULD be filtered by product type.", response=List.class)
	@ApiResponses(value = {
		@ApiResponse(code = -1, message = "wrongParameters"),
		@ApiResponse(code = -1, message = "noData"),
		@ApiResponse(code = 200, message = "Found Sucessfully", response=List.class),
		@ApiResponse(code = 500, message = "Technical Error"),
		@ApiResponse(code = 400, message = "wrongParameters"),
		@ApiResponse(code = 409, message = "noData")
	})
	@GET
	@Path("/customers/{customerId}/products")
	@Produces({MediaType.APPLICATION_JSON})
	@ElementClass(response = List.class)
	@SMC(registryID="SMCCO1400003",logicalID="getExtractGlobalBalance")
	public List<Product> getExtractGlobalBalance(
			@ApiParam(value = "Customer identifier") @PathParam("customerId") String customerId,
			@ApiParam(value = "filter param") @DefaultValue("null") @QueryParam("$filter") String filter) {

		final DTOIntFilterProduct filterProduct = getFilterProduct(customerId, filter);

		List<DTOIntProduct> products = srvIntGlobalPosition.getExtractGlobalBalance(filterProduct);
		return Mapper.productListMap(products);
	}

	@ApiOperation(value="Update the product.", notes="Update the product partially", response=Response.class)
	@ApiResponses(value = {
		@ApiResponse(code = -1, message = "wrongParameters"),
		@ApiResponse(code = 200, message = "Modified Sucessfully", response=Response.class),
		@ApiResponse(code = 500, message = "Technical Error"),
		@ApiResponse(code = 400, message = "wrongParameters")
	})
	@PUT
	@Path("/{idProduct}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response update(
			@ApiParam(value="Product identifier")@PathParam("idProduct") String idProduct,
			@ApiParam(value="Produc information")Product infoProduct) {

		infoProduct.setId(idProduct);

		if (infoProduct.getVisible() != null) {
			this.updateProductVisibility(idProduct, infoProduct);
		} else if (infoProduct.getOperable() != null){
			this.updateProductOperability(idProduct, infoProduct);
		} else {
			throw new BusinessServiceException("wrongParameters");
		}

		return Response.ok().build();
	}

	@SMC(registryID="SMCCO1400004",logicalID="update")
	private void updateProductVisibility(String idProduct, Product infoProduct) {

		final DTOIntProduct productInt = new DTOIntProduct();

		productInt.setId(idProduct);
		productInt.setVisible(infoProduct.getVisible());

		srvIntGlobalPosition.updateProductVisibility(productInt);
	}

	@SMC(registryID="SMCCO1400005",logicalID="update")
	private void updateProductOperability(String idProduct, Product infoProduct) {

		final DTOIntProduct productInt = new DTOIntProduct();

		productInt.setId(idProduct);
		productInt.setOperable(infoProduct.getOperable());

		srvIntGlobalPosition.updateProductOperability(productInt);
	}

	private DTOIntFilterProduct getFilterProduct(String customerId, String filter) {

		final DTOIntFilterProduct filterProduct = new DTOIntFilterProduct();
		filterProduct.setProductType(null);

		if (filter != null && !filter.contentEquals("null")) {
			log.info("A query string (filter) has been sended: " + filter);
			SearchCondition<DTOIntProduct> sc;
			try {
				sc = new FiqlParser<DTOIntProduct>(DTOIntProduct.class).parse(filter);

				final List<PrimitiveStatement> splitDataFilter = businessToolKit.getDataFromFilter(sc);
				for (PrimitiveStatement st : splitDataFilter) {
					if (st.getProperty().equals("productType")) {
						filterProduct.setProductType(EnumProductType.valueOf(st.getValue().toString()));
					}
				}

			} catch (SearchParseException e) {
				log.error("SearchParseException - The query string (filter) has failed: " + e);
				throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias(), filter, e.getMessage());
			} catch (IllegalArgumentException e) {
				log.error("IllegalArgumentException - The product type is an invalid type - does not exist: " + e);
				throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias(), filter, e.getMessage());
			}
		}

		filterProduct.setIdCustomer(customerId);

		return filterProduct;

	}
}

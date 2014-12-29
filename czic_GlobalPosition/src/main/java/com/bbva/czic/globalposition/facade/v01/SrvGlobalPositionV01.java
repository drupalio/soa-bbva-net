package com.bbva.czic.globalposition.facade.v01;

import com.bbva.czic.dto.net.Product;
import com.bbva.czic.globalposition.business.ISrvIntGlobalPosition;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.bbva.jee.arq.spring.core.servicing.annotations.SN;
import com.bbva.jee.arq.spring.core.servicing.annotations.VN;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;
import com.wordnik.swagger.annotations.*;
import org.apache.cxf.jaxrs.model.wadl.ElementClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	
	@ApiOperation(value="Gets all the users products", notes="List of products that COULD be filtered by product type.",response=Response.class)
	@ApiResponses(value = {
		@ApiResponse(code = -1, message = "wrongParameters"),
		@ApiResponse(code = -1, message = "noData"),
		@ApiResponse(code = 200, message = "Found Sucessfully", response=Product[].class),
		@ApiResponse(code = 500, message = "Technical Error"),
		@ApiResponse(code = 400, message = "wrongParameters"),
		@ApiResponse(code = 409, message = "noData")
	})
	@GET
	@Path("/customers/{customerId}/products")
	@Produces({MediaType.APPLICATION_JSON})
	@ElementClass(response = Product.class)
	@SMC(registryID="SMCCO1400003",logicalID="getExtractGlobalBalance")
	public Product[] getExtractGlobalBalance(
			@PathParam("customerId") String customerId,
			@ApiParam(value = "filter param") @DefaultValue("null") @QueryParam("$filter") String filter,
			@ApiParam(value = "fields param") @DefaultValue("null") @QueryParam("$fields") String fields,
			@ApiParam(value = "expands param") @DefaultValue("null") @QueryParam("$expands") String expands,
			@ApiParam(value = "order by param") @DefaultValue("null") @QueryParam("$sort") String sort) {

		List<Product> products = srvIntGlobalPosition.getExtractGlobalBalance(customerId, filter);
		return products.toArray(new Product[products.size()]);
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
			@ApiParam(value="Claim identifier")@PathParam("idProduct") String idProduct,
			@ApiParam(value="Claim information")Product infoProduct) {

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

		srvIntGlobalPosition.updateProductVisibility(idProduct, infoProduct);
	}

	@SMC(registryID="SMCCO1400005",logicalID="update")
	private void updateProductOperability(String idProduct, Product infoProduct) {

		srvIntGlobalPosition.updateProductOperability(idProduct, infoProduct);
	}
}

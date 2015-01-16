package com.bbva.czic.globalposition.facade.v01;

import com.bbva.czic.dto.net.Product;
import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


public interface ISrvGlobalPositionV01 {
 	public List<Product> getExtractGlobalBalance(String customerId, String filter);

	Response updateProductVisibility(String idProduct, Product infoProduct);

	Response updateProductOperability(String idProduct, Product infoProduct);
}
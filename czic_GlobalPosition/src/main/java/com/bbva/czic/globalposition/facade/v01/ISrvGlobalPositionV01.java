package com.bbva.czic.globalposition.facade.v01;

import com.bbva.czic.dto.net.Product;

import javax.ws.rs.core.Response;
import java.util.List;


public interface ISrvGlobalPositionV01 {
 	public Product[] getExtractGlobalBalance(String customerId, String filter, String fields, String expands, String orderby);

	public Response update(String idProduct, Product infoProduct);
}
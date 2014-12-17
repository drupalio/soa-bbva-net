package com.bbva.czic.globalposition.facade.v01;

import java.util.List;

import javax.ws.rs.core.Response;

import com.bbva.czic.dto.canonicaldto.Product;

public interface ISrvGlobalPositionV01 {

	public List<Product> getExtractGlobalBalance(String customerId, String filter, String fields, String expands,
			String orderby);

	public Response update(String idProduct, Product infoProduct);

}
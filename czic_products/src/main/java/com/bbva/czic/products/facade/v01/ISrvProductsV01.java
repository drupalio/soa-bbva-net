package com.bbva.czic.products.facade.v01;

import javax.ws.rs.core.Response;


public interface ISrvProductsV01 {

	public Response getConditions(String productId);

}
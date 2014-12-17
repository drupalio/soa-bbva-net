package com.bbva.czic.globalposition.facade.v01;

<<<<<<< HEAD
import java.util.List;

import javax.ws.rs.core.Response;
=======
import com.bbva.czic.dto.net.Product;

import javax.ws.rs.core.Response;
import java.util.List;
>>>>>>> new_master

import com.bbva.czic.dto.canonicaldto.Product;

public interface ISrvGlobalPositionV01 {

<<<<<<< HEAD
	public List<Product> getExtractGlobalBalance(String customerId, String filter, String fields, String expands,
			String orderby);

	public Response update(String idProduct, Product infoProduct);

=======
	public Response update(String idProduct, Product infoProduct);
>>>>>>> new_master
}
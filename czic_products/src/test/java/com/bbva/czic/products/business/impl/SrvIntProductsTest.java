package com.bbva.czic.products.business.impl;



import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.bbva.czic.products.business.ISrvIntProducts;
import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntProduct;
import com.bbva.czic.products.dao.IProductsDAO;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;



public class SrvIntProductsTest {

	@Mock
	IProductsDAO productsDAO;

	@InjectMocks
	@Autowired
	ISrvIntProducts srv;

	@Test()
	public void testGetConditionsSucces() {
		DTOIntConditions initialResult =null;

		// setUp - expectation
		DTOIntProduct dtoIntProduct = new DTOIntProduct();
		when(productsDAO.getConditions(dtoIntProduct)).thenReturn(new DTOIntConditions());

		initialResult= srv.getConditions(dtoIntProduct);

		assertNotNull(initialResult);
	}




	private BusinessServiceException getBsnExeptionByAlias(String alias){
		return new BusinessServiceException(alias);
	}


}


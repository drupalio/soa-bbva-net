package com.bbva.czic.products.business.impl;


import com.bbva.czic.products.business.ISrvIntProducts;
import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntProduct;
import com.bbva.czic.products.dao.IProductsDAO;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;


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


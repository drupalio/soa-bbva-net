package com.bbva.czic.products.business.impl;


import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

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

import com.bbva.czic.products.business.ISrvIntProducts;
import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntProduct;
import com.bbva.czic.products.dao.IProductsDAO;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = BusinessServiceTestContextLoader.class, locations = {"classpath*:/META-INF/spring/applicationContext-*.xml", "classpath:/META-INF/spring/business-service.xml", "classpath:/META-INF/spring/business-service-test.xml"})
@TestExecutionListeners(listeners = {MockInvocationContextTestExecutionListener.class, DependencyInjectionTestExecutionListener.class})
public class SrvIntProductsTest {

	@Mock
	IProductsDAO productsDAO;

	@InjectMocks
	@Autowired
	ISrvIntProducts srv;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test()
	public void testGetConditionsSucces() {
		DTOIntConditions initialResult =null;

		// setUp - expectation
		DTOIntProduct dtoIntProduct = new DTOIntProduct();
		when(productsDAO.getConditions(dtoIntProduct)).thenReturn(new DTOIntConditions());

		initialResult= srv.getConditions(dtoIntProduct);

		assertNotNull(initialResult);
	}


}


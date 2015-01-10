package com.bbva.czic.globalposition.business;

import com.bbva.czic.globalposition.business.dto.DTOIntFilterProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProducts;
import com.bbva.czic.globalposition.business.impl.SrvIntGlobalPosition;
import com.bbva.czic.globalposition.dao.GlobalPositionDAO;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		loader = BusinessServiceTestContextLoader.class,
		locations = {
				"classpath*:/META-INF/spring/applicationContext-*.xml",
				"classpath:/META-INF/spring/business-service.xml",
				"classpath:/META-INF/spring/business-service-test.xml"
		})
@TestExecutionListeners(listeners = {
		//MockInvocationContextTestExecutionListener.class,
		DependencyInjectionTestExecutionListener.class
})
public class SrvIntGlobalPositionTest {

	@Mock
	GlobalPositionDAO globalPositionDAO;

	@InjectMocks
	@Autowired
	SrvIntGlobalPosition srv;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testNotNullIfProductExist() {
		// Setup data
		final DTOIntProducts intProducts = new DTOIntProducts();
		final DTOIntFilterProduct filterProduct = new DTOIntFilterProduct();

		// Setup expectation
		when(globalPositionDAO.getExtractGlobalBalance(filterProduct)).thenReturn(intProducts);

		// SUT execution
		final List<DTOIntProduct> products = srv.getExtractGlobalBalance(filterProduct);

		//Validation

	}
	
}


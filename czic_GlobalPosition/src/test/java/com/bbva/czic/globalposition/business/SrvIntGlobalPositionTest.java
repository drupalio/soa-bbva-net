package com.bbva.czic.globalposition.business;

import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProductFilter;
import com.bbva.czic.globalposition.business.impl.SrvIntGlobalPosition;
import com.bbva.czic.globalposition.dao.IGlobalPositionDAO;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		loader = BusinessServiceTestContextLoader.class,
		locations = {
				"classpath*:/META-INF/spring/applicationContext-*.xml",
				"classpath:/META-INF/spring/business-service.xml",
				"classpath:/META-INF/spring/business-service-test.xml"
		})
@TestExecutionListeners(listeners = {
		MockInvocationContextTestExecutionListener.class,
		DependencyInjectionTestExecutionListener.class
})
public class SrvIntGlobalPositionTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Mock
	IGlobalPositionDAO globalPositionDAO;

	@InjectMocks
	//@Autowired
	SrvIntGlobalPosition srv;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testNotNullIfProductExist() {
		// Setup data
		final List<DTOIntProduct> intProducts = new ArrayList<DTOIntProduct>();
		final DTOIntProductFilter filterProduct = new DTOIntProductFilter();

		// Setup expectation
		when(globalPositionDAO.getExtractGlobalBalance(filterProduct)).thenReturn(intProducts);

		// SUT execution
		final List<DTOIntProduct> products = srv.getExtractGlobalBalance(filterProduct);

		//Validation
		assertNotNull(products);
	}

}


package com.bbva.czic.globalposition.business;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.business.impl.SrvIntGlobalPosition;
import com.bbva.czic.globalposition.dao.GlobalPositionDAO;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


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
	public void testModifyProduct() {

	}

	private List<DTOIntProduct> getProductsList() {

		List<DTOIntProduct> intProducts = new ArrayList<DTOIntProduct>();

		DTOIntProduct intProduct = new DTOIntProduct();
		intProduct.setId("1");
		intProduct.setAlias("Cuentas Corrientes");
		intProduct.setName("Cuentas que tal");
		//intProduct.setType("PC");
		intProduct.setType(EnumProductType.PC);

		intProducts.add(intProduct);

		intProduct = new DTOIntProduct();
		intProduct.setId("2");
		intProduct.setAlias("Cuentas Corrientes");
		intProduct.setName("Cuentas que tal");
		//intProduct.setType("TC");
		intProduct.setType(EnumProductType.TC);

				intProducts.add(intProduct);

		intProduct = new DTOIntProduct();
		intProduct.setId("3");
		intProduct.setAlias("Cuentas Corrientes");
		intProduct.setName("Cuentas que tal");
		//intProduct.setType("ED");
		intProduct.setType(EnumProductType.ED);

				intProducts.add(intProduct);

		intProduct = new DTOIntProduct();
		intProduct.setId("4");
		intProduct.setAlias("Cuentas Corrientes");
		intProduct.setName("Cuentas que tal");
		//intProduct.setType("AQ");
		intProduct.setType(EnumProductType.AQ);

				intProducts.add(intProduct);

		intProduct = new DTOIntProduct();
		intProduct.setId("5");
		intProduct.setAlias("Cuentas Corrientes");
		intProduct.setName("Cuentas que tal");
		//intProduct.setType("RQ");
		intProduct.setType(EnumProductType.RQ);

				intProducts.add(intProduct);

		return intProducts;

	}
	
}


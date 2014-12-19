package com.bbva.czic.globalposition.business;

import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.business.impl.SrvIntGlobalPosition;
import com.bbva.czic.globalposition.dao.GlobalPositionDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class SrvIntGlobalPositionTest {

	@Mock
	GlobalPositionDAO globalPositionDAO;

	@InjectMocks
	SrvIntGlobalPosition srv;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllProductsIfNoFilter() {
		//setUp - data
		List<DTOIntProduct> products = getProductsList();

		//setUp - expectation
		when(globalPositionDAO.getExtractGlobalBalance(anyString())).thenReturn(products);

		//SUT's excecution
		srv.getExtractGlobalBalance("111", null);

		//validation
		assertEquals(products.size(), 5);
	}

	@Test
	public void testFilterByProductType(){
		//setUp - data
		List<DTOIntProduct> products = getProductsList();

		//setUp - expectation
		when(globalPositionDAO.getExtractGlobalBalance(anyString())).thenReturn(products);

		//SUT's excecution
		srv.getExtractGlobalBalance("111", "({productType==DE)");

		//validation
		assertEquals(products.size(), 1);
	}
		
	@Test
	public void testModifyProduct() {
		//TODO: call srv.modifyProduct
	}

	private List<DTOIntProduct> getProductsList() {

		List<DTOIntProduct> intProducts = new ArrayList<DTOIntProduct>();

		DTOIntProduct intProduct = new DTOIntProduct();
		intProduct.setId("1");
		intProduct.setAlias("Cuentas Corrientes");
		intProduct.setName("Cuentas que tal");
		intProduct.setProductType("PC");

		intProducts.add(intProduct);

		intProduct = new DTOIntProduct();
		intProduct.setId("2");
		intProduct.setAlias("Cuentas Corrientes");
		intProduct.setName("Cuentas que tal");
		intProduct.setProductType("TDC");

		intProducts.add(intProduct);

		intProduct = new DTOIntProduct();
		intProduct.setId("3");
		intProduct.setAlias("Cuentas Corrientes");
		intProduct.setName("Cuentas que tal");
		intProduct.setProductType("ED");

		intProducts.add(intProduct);

		intProduct = new DTOIntProduct();
		intProduct.setId("4");
		intProduct.setAlias("Cuentas Corrientes");
		intProduct.setName("Cuentas que tal");
		intProduct.setProductType("AQ");

		intProducts.add(intProduct);

		intProduct = new DTOIntProduct();
		intProduct.setId("5");
		intProduct.setAlias("Cuentas Corrientes");
		intProduct.setName("Cuentas que tal");
		intProduct.setProductType("RQ");

		intProducts.add(intProduct);

		/*
		Gson gson = new Gson();
		List<DTOIntProduct> products = new ArrayList<DTOIntProduct>();
		try {
			BufferedReader br = new BufferedReader(
                    new FileReader(this.getClass().getResource("products.json").getFile()));

			//convert the json string back to object
			products = Arrays.asList(gson.fromJson(br, DTOIntProduct[].class));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		*/
		return intProducts;

	}
	
}


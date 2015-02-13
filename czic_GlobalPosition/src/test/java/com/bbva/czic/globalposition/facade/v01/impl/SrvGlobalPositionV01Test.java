package com.bbva.czic.globalposition.facade.v01.impl;

import com.bbva.czic.dto.net.Balance;
import com.bbva.czic.dto.net.Product;
import com.bbva.czic.globalposition.business.ISrvIntGlobalPosition;
import com.bbva.czic.globalposition.facade.v01.ISrvGlobalPositionV01;
import com.bbva.czic.globalposition.facade.v01.mappers.IGlobalPositionMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

public class SrvGlobalPositionV01Test {

	@Mock
	private IGlobalPositionMapper globalPositionMapper;

	@Mock
	ISrvIntGlobalPosition srvIntGlobalPosition;

	@InjectMocks
	private ISrvGlobalPositionV01 srvGlobalPositionV01;

	@Before
	public void init(){
		srvGlobalPositionV01 = new SrvGlobalPositionV01();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void callGetExtractGlobalBalanceFacadeTest(){

		List<Product> productList = new ArrayList<Product>();

		Product product = new Product();
		product.setId("12345");
		product.setOperable(true);
		product.setName("Credito");
		product.setType("QA");
		product.setBalance(new Balance());

		productList.add(product);

		when(srvGlobalPositionV01.getExtractGlobalBalance("123", "productType==PC")).thenReturn(productList);

		List<Product> resultList = srvGlobalPositionV01.getExtractGlobalBalance("123", "(productType==PC)");

		Assert.assertNotNull(resultList);
	}

	@Test
	 public void callUpdateProductVisibilityTest(){

		Product product = new Product();
		product.setId("1234");

		srvGlobalPositionV01.updateProductVisibility("12345", product);

	}

	@Test
	public void callUpdateProductOperabilityTest(){

		Product product = new Product();
		product.setId("1234");

		srvGlobalPositionV01.updateProductOperability("12345", product);
	}
}

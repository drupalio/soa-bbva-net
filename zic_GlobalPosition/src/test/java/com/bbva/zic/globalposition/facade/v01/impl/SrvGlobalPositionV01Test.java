package com.bbva.zic.globalposition.facade.v01.impl;

import com.bbva.zic.dto.net.Balance;
import com.bbva.zic.dto.net.Product;
import com.bbva.zic.globalposition.business.ISrvIntGlobalPosition;
import com.bbva.zic.globalposition.facade.v01.ISrvGlobalPositionV01;
import com.bbva.zic.globalposition.facade.v01.mappers.IGlobalPositionMapper;
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

		when(srvGlobalPositionV01.getExtractGlobalBalance("productType==PC")).thenReturn(productList);

		List<Product> resultList = srvGlobalPositionV01.getExtractGlobalBalance("(productType==PC)");

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

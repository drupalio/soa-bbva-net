package com.bbva.zic.globalposition.dao.impl;

import com.bbva.zic.globalposition.business.dto.*;
import com.bbva.zic.globalposition.dao.IGlobalPositionDAO;
import com.bbva.zic.globalposition.dao.tx.TxGetExtractGlobalBalance;
import com.bbva.zic.globalposition.dao.tx.TxGetExtractGlobalBalanceNoTC;
import com.bbva.zic.routine.commons.rm.utils.tx.ISimpleTransaction;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;

public class TestGlobalPositionDAO {

	@Mock
	private TxGetExtractGlobalBalance txGetExtractGlobalBalance;

	@Mock
	private TxGetExtractGlobalBalanceNoTC txGetExtractGlobalBalanceNoTC;

	@Mock
	private ISimpleTransaction txUpdateProductVisibility;

	@Mock
	private ISimpleTransaction txUpdateProductOperability;

	@InjectMocks
	private IGlobalPositionDAO globalPositionDAO;

	@Before
	public void init(){
		globalPositionDAO = new GlobalPositionDAO();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void callGetExtractGlobalBalanceWithProductTypeIsInvalid() {

		List<DTOIntProduct> dtoIntProductList = new ArrayList<DTOIntProduct>();

		DTOIntProductFilter dtoIntProductFilter = new DTOIntProductFilter();
		dtoIntProductFilter.setProductType("QA");

		DTOIntProduct dtoIntProduct = new DTOIntProduct();
		dtoIntProduct.setId("123456");
		dtoIntProduct.setName("Credito");
		dtoIntProduct.setOperable(true);
		dtoIntProduct.setBalance(new DTOIntBalance());

		dtoIntProductList.add(dtoIntProduct);

		Mockito.when(globalPositionDAO.getExtractGlobalBalance(dtoIntProductFilter)).thenReturn(dtoIntProductList);

		List<DTOIntProduct> resultList = globalPositionDAO.getExtractGlobalBalance(dtoIntProductFilter);

		Assert.assertNotNull(resultList);
	}

	@Test
	public void callGetExtractGlobalBalancewithAllParametersOk() {

		List<DTOIntProduct> dtoIntProductList = new ArrayList<DTOIntProduct>();

		DTOIntProductFilter dtoIntProductFilter = new DTOIntProductFilter();
		dtoIntProductFilter.setProductType("TC");

		DTOIntProduct dtoIntProduct = new DTOIntProduct();
		dtoIntProduct.setId("123456");
		dtoIntProduct.setName("Credito");
		dtoIntProduct.setOperable(true);
		dtoIntProduct.setBalance(new DTOIntBalance());

		dtoIntProductList.add(dtoIntProduct);

		Mockito.when(globalPositionDAO.getExtractGlobalBalance(dtoIntProductFilter)).thenReturn(dtoIntProductList);

		List<DTOIntProduct> resultList = globalPositionDAO.getExtractGlobalBalance(dtoIntProductFilter);

		Assert.assertNotNull(resultList);
	}

	@Test
	public void callupdateProductVisibilityTestOk(){
		globalPositionDAO.updateProductVisibility(any(DTOIntProductVisibility.class));
	}

	@Test
	public void callUpdateProductOperabilityTestOk(){
		globalPositionDAO.updateProductOperability(any(DTOIntProductOperability.class));
	}

}

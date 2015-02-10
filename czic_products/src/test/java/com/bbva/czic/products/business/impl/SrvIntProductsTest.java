package com.bbva.czic.products.business.impl;



import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bbva.czic.products.business.ISrvIntProducts;
import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntExtract;
import com.bbva.czic.products.business.dto.DTOIntExtractOutput;
import com.bbva.czic.products.business.dto.DTOIntFilterExtract;
import com.bbva.czic.products.business.dto.DTOIntProduct;
import com.bbva.czic.products.dao.IProductsDAO;
import com.bbva.czic.products.facade.v01.impl.SrvProductsV01Test;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;



public class SrvIntProductsTest extends SpringContextBbvaTest {
	
	final static DataFactory dataF = new DataFactory();
	
	@Mock
	IProductsDAO productsDAO;

	@InjectMocks
	ISrvIntProducts srv;
	
	@Before
	public void init(){
		srv = new SrvIntProducts();
        MockitoAnnotations.initMocks(this);
	}

//  ------------------ getConditions ------------------	
	
	@Test
	public void testGetConditionsSuccess() {
		
		// setUp - expectation
		DTOIntProduct dtoIntProduct = mockDTOIntProductEntity();
		DTOIntConditions dtoIntCondition = SrvProductsV01Test.mockDTOIntConditionsEntity();
		when(productsDAO.getConditions(any(DTOIntProduct.class))).thenReturn(dtoIntCondition);

		//Test
		DTOIntConditions initialResult= srv.getConditions(dtoIntProduct);
		assertNotNull(initialResult);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetConditionsNullInputDto() {
		
		// setUp - expectation
		DTOIntProduct dtoIntProduct = null;
		DTOIntConditions dtoIntCondition = SrvProductsV01Test.mockDTOIntConditionsEntity();
		when(productsDAO.getConditions(any(DTOIntProduct.class))).thenReturn(dtoIntCondition);

		//Test
		DTOIntConditions initialResult= srv.getConditions(dtoIntProduct);
	}
	
	@Test(expected = BusinessServiceException.class)
	public void testGetConditionsDaoException() {

		// setUp - expectation
		final DTOIntProduct dtoIntProduct = mockDTOIntProductEntity();
		BusinessServiceException bsn=new BusinessServiceException(EnumError.TECHNICAL_ERROR.getAlias());
		when(productsDAO.getConditions(any(DTOIntProduct.class))).thenThrow(bsn);

		// Test
		srv.getConditions(dtoIntProduct);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetConditionsNullOutputDto() {
		
		// setUp - expectation
		DTOIntProduct dtoIntProduct = mockDTOIntProductEntity();
		when(productsDAO.getConditions(any(DTOIntProduct.class))).thenReturn(null);

		//Test
		DTOIntConditions initialResult= srv.getConditions(dtoIntProduct);
	}
	
//  ------------------ listExtracts ------------------	
	
	@Test
	public void testListExtractsSuccess() {
		
		// setUp - expectation
		DTOIntExtractOutput dtoExtractOutput = mockDTOIntExtractOutputEntity();
		DTOIntFilterExtract dtoIntFilterExtract = mockDTOIntFilterExtractNoExtractIdEntity();
		when(productsDAO.listExtracts(any(DTOIntFilterExtract.class))).thenReturn(dtoExtractOutput);

		//Test
		List<DTOIntExtract> initialResult= srv.listExtracts(dtoIntFilterExtract);
		assertNotNull(initialResult);
	}
	
	@Test
	public void testGetExtractsSuccess() {
		
		// setUp - expectation
		DTOIntExtractOutput dtoExtractOutput = mockDTOIntExtractOutputEntity();
		DTOIntFilterExtract dtoIntFilterExtract = mockDTOIntFilterExtractEntity();
		when(productsDAO.listExtracts(any(DTOIntFilterExtract.class))).thenReturn(dtoExtractOutput);

		//Test
		List<DTOIntExtract> initialResult= srv.listExtracts(dtoIntFilterExtract);
		assertNotNull(initialResult);
	}

	@Test(expected = BusinessServiceException.class)
	public void testListExtractDaoException() {
		// setUp - expectation
		DTOIntFilterExtract dtoIntFilterExtract = mockDTOIntFilterExtractEntity();
		BusinessServiceException bsn = new BusinessServiceException(
				EnumError.TECHNICAL_ERROR.getAlias());
		when(productsDAO.listExtracts(any(DTOIntFilterExtract.class))).thenThrow(bsn);

		// Test
		srv.listExtracts(dtoIntFilterExtract);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testListExtractsNullInputDto() {

		// setUp - expectation
		DTOIntExtractOutput dtoExtractOutput = null;
		DTOIntFilterExtract dtoIntFilterExtract = mockDTOIntFilterExtractNoExtractIdEntity();
		when(productsDAO.listExtracts(any(DTOIntFilterExtract.class)))
				.thenReturn(dtoExtractOutput);

		// Test
		List<DTOIntExtract> initialResult = srv
				.listExtracts(dtoIntFilterExtract);
		assertNotNull(initialResult);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testListExtractsNullOutputDto() {

		// setUp - expectation
		DTOIntFilterExtract dtoIntFilterExtract = mockDTOIntFilterExtractNoExtractIdEntity();
		when(productsDAO.listExtracts(any(DTOIntFilterExtract.class)))
				.thenReturn(null);

		// Test
		List<DTOIntExtract> initialResult = srv
				.listExtracts(dtoIntFilterExtract);
		assertNotNull(initialResult);
	}

	
//  ------------------ Utils ------------------
	
	private DTOIntProduct mockDTOIntProductEntity() {
		DTOIntProduct dto = new DTOIntProduct();
		dto.setAlias(dataF.getRandomWord(7));
		dto.setId(dataF.getNumberText(20));
		dto.setName(dataF.getRandomWord(6));
		dto.setOperable(true);
		dto.setType("AC");
		return dto;
	}

	private DTOIntExtractOutput mockDTOIntExtractOutputEntity() {
		DTOIntExtractOutput dtoIntExtractOutput = new DTOIntExtractOutput();
		dtoIntExtractOutput.setExtracts(new ArrayList<DTOIntExtract>());
		return dtoIntExtractOutput;
	}
	
	public DTOIntFilterExtract mockDTOIntFilterExtractNoExtractIdEntity() {
		DTOIntFilterExtract filter = new DTOIntFilterExtract();
		filter.setProductId(dataF.getNumberText(20));
		filter.setEndMonth(dataF.getNumberBetween(10,12)+"");
		filter.setStartMonth("01");
		filter.setStartYear(dataF.getNumberBetween(2000,2005)+"");
		filter.setEndYear(dataF.getNumberBetween(2010,2015)+"");
		return filter;
	}
	
	public DTOIntFilterExtract mockDTOIntFilterExtractEntity() {
		DTOIntFilterExtract filter = new DTOIntFilterExtract();
		filter.setProductId(dataF.getNumberText(20));
		filter.setExtractId(dataF.getNumberText(8));
		filter.setEndMonth("01");
		filter.setStartMonth("01");
		filter.setStartYear("2014");
		filter.setEndYear("2014");
		return filter;
	}

}


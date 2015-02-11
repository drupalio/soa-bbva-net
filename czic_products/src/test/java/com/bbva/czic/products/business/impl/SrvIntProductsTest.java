package com.bbva.czic.products.business.impl;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;

import com.bbva.czic.products.business.dto.*;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bbva.czic.products.business.ISrvIntProducts;
import com.bbva.czic.products.dao.IProductsDAO;
import com.bbva.czic.products.facade.v01.impl.SrvProductsV01Test;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;



public class SrvIntProductsTest extends SpringContextBbvaTest {
	
	final static DataFactory dataF = new DataFactory();
	private BusinessServiceException bsn = null;
	
	@Mock
	IProductsDAO productsDAO;

	@InjectMocks
	ISrvIntProducts srv;
	
	@Before
	public void init(){
		srv = new SrvIntProducts();
        MockitoAnnotations.initMocks(this);
		bsn = new BusinessServiceException(EnumError.TECHNICAL_ERROR.getAlias());
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

	//------------getMovement-----------------

	@Test(expected = BusinessServiceException.class)
	public void testGetMovementInvalidFilter(){
		final DTOIntFilterMovements dtoIntFilterMovements = new DTOIntFilterMovements();
		dtoIntFilterMovements.setCustomerId("123");
		srv.getMovement(dtoIntFilterMovements);
	}

	@Test(expected = BusinessServiceException.class)
	public void testGetMovementInvalidAccountId(){
		final DTOIntFilterMovements dtoIntFilterMovements = new DTOIntFilterMovements();
		dtoIntFilterMovements.setProductId("123456789HH234567890");

		srv.getMovement(dtoIntFilterMovements);
	}

	@Test(expected = BusinessServiceException.class)
	public void testGetMovementDaoException(){
		final DTOIntFilterMovements filterMovements = new DTOIntFilterMovements();
		filterMovements.setProductId("12345678901234567890");

		when(productsDAO.getMovement(any(DTOIntFilterMovements.class)))
				.thenThrow(bsn);

		srv.getMovement(filterMovements);
	}

	@Test(expected = BusinessServiceException.class)
	public void testGetMovementOutputException(){
		final DTOIntFilterMovements filterMovement = new DTOIntFilterMovements();
		filterMovement.setProductId("12345678901234567890");

		DTOIntMovement dtoIntMovement = new DTOIntMovement();
		dtoIntMovement.setProductId("01020304050607080900");


		when(productsDAO.getMovement(any(DTOIntFilterMovements.class)))
				.thenReturn(dtoIntMovement);

		srv.getMovement(filterMovement);
	}

	@Test
	public void testGetMovement(){
		final DTOIntFilterMovements filterMovement = new DTOIntFilterMovements();
		filterMovement.setProductId("01020304050607080900");
		filterMovement.setCustomerId("12345678");
		filterMovement.setMovementId("0102030400");
		filterMovement.setPageSize(10);
		filterMovement.setPaginationKey(1);


		DTOIntMovement dtoIntMovement = new DTOIntMovement();
		dtoIntMovement.setProductId("01020304050607080900");
		dtoIntMovement.setTransactionDate(new Date());
		dtoIntMovement.setBalance(new Money());
		dtoIntMovement.setValue(new Money());
		dtoIntMovement.setConcept("Concepto");
		dtoIntMovement.setId("123456");
		dtoIntMovement.setOperation(new DTOIntOperation());
		dtoIntMovement.setOperationDate(new Date());
		dtoIntMovement.setOffice(new DTOIntOffice());


		when(productsDAO.getMovement(any(DTOIntFilterMovements.class)))
				.thenReturn(dtoIntMovement);

		final DTOIntMovement result = srv.getMovement(filterMovement);

		assertNotNull(result);
	}

	// -----------------listMovements---------------------

	@Test(expected = BusinessServiceException.class)
	public void testListMovementsInvalidFilter(){
		final DTOIntFilterMovements dtoIntFilterMovements = new DTOIntFilterMovements();
		dtoIntFilterMovements.setCustomerId("123");
		srv.listMovements(dtoIntFilterMovements);
	}

	@Test(expected = BusinessServiceException.class)
	public void testListMovementsInvalidAccountId(){
		final DTOIntFilterMovements dtoIntFilterMovements = new DTOIntFilterMovements();
		dtoIntFilterMovements.setProductId("123456789HH234567890");

		srv.listMovements(dtoIntFilterMovements);
	}

	@Test(expected = BusinessServiceException.class)
	public void testListMovementsDaoException(){
		final DTOIntFilterMovements filterMovements = new DTOIntFilterMovements();
		filterMovements.setProductId("12345678901234567890");

		when(productsDAO.listMovements(any(DTOIntFilterMovements.class)))
				.thenThrow(bsn);

		srv.listMovements(filterMovements);
	}

	@Test(expected = BusinessServiceException.class)
	public void testListMovementsOutputException(){
		final DTOIntFilterMovements filterMovement = new DTOIntFilterMovements();
		filterMovement.setProductId("12345678901234567890");

		List<DTOIntMovement> listaDTOIntMovement = new ArrayList<DTOIntMovement>();
		DTOIntMovement dtoIntMovement = new DTOIntMovement();
		dtoIntMovement.setProductId("01020304050607080900");
		listaDTOIntMovement.add(dtoIntMovement);


		when(productsDAO.listMovements(any(DTOIntFilterMovements.class)))
				.thenReturn(listaDTOIntMovement);

		srv.listMovements(filterMovement);
	}

	@Test
	public void testListMovements(){
		final DTOIntFilterMovements filterMovement = new DTOIntFilterMovements();
		filterMovement.setProductId("01020304050607080900");
		filterMovement.setCustomerId("12345678");
		filterMovement.setMovementId("0102030400");
		filterMovement.setPageSize(10);
		filterMovement.setPaginationKey(1);

		List<DTOIntMovement> listaDTOIntMovement = new ArrayList<DTOIntMovement>();
		DTOIntMovement dtoIntMovement = new DTOIntMovement();
		dtoIntMovement.setProductId("01020304050607080900");
		dtoIntMovement.setTransactionDate(new Date());
		dtoIntMovement.setBalance(new Money());
		dtoIntMovement.setValue(new Money());
		dtoIntMovement.setConcept("Concepto");
		dtoIntMovement.setId("123456");
		dtoIntMovement.setOperation(new DTOIntOperation());
		dtoIntMovement.setOperationDate(new Date());
		dtoIntMovement.setOffice(new DTOIntOffice());
		listaDTOIntMovement.add(dtoIntMovement);

		when(productsDAO.listMovements(any(DTOIntFilterMovements.class)))
				.thenReturn(listaDTOIntMovement);

		final List<DTOIntMovement> result = srv.listMovements(filterMovement);

		assertNotNull(result);
		assertTrue(result.size()>0);
	}
}


package com.bbva.czic.products.facade.v01.mapper.impl;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bbva.czic.products.business.dto.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.dto.net.Extract;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.products.facade.v01.impl.SrvProductsV01Test;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;


/**
 * Created by Entelgy on 06/02/2015.
 */
public class ProductsMapperTest {


    private ProductsMapper productsMapper;

    @Before
    public void init() {
        productsMapper = new ProductsMapper();
        MockitoAnnotations.initMocks(this);
    }
	
//  ------------------ listExtracts ------------------
	
	@Test
	public void mapOutListExtractsTest(){
		List<DTOIntExtract> listDto = SrvProductsV01Test.mockDTOIntExtractsEntity();
		List<Extract> extract = productsMapper.mapExtracts(listDto);
		assertEquals(listDto.size(),extract.size());
		assertEquals(listDto.get(0).getExtCode(),extract.get(0).getExternalCode());
		assertEquals(listDto.get(0).getMonth(),extract.get(0).getMonth());
		assertEquals(listDto.get(0).getYear(),extract.get(0).getYear());
		assertEquals(listDto.get(0).getUrl(),extract.get(0).getUrl());
	}
	
	@Test
	public void mapInListFilterExtractsTest(){
		String productId = "00130693000100000010";
		String extractId = "123456789";
		String filter = "(extractId=="+extractId+";month==02;year==2014)";
		DTOIntFilterExtract dtoFilter = productsMapper.getDtoIntFilterExtract(productId, filter);
		assertEquals(productId,dtoFilter.getProductId());
		assertEquals(extractId,dtoFilter.getExtractId());
		assertEquals("02",dtoFilter.getMonth());
		assertEquals("2014",dtoFilter.getYear());
	}
	
	@Test
	public void mapInListExtractsTest(){
		String productId = "00130693000100000010";
		String filter = null;
		DTOIntFilterExtract dtoFilter = productsMapper.getDtoIntFilterExtract(productId, filter);
		assertEquals(productId,dtoFilter.getProductId());
	}
	
//  ------------------ getConditions ------------------
	
	@Test
	public void mapOutGetConditionsTest(){
		DTOIntConditions dtoCond = SrvProductsV01Test.mockDTOIntConditionsEntity();
		Conditions conditions = productsMapper.map(dtoCond);
		assertEquals(conditions.getAlias(), conditions.getAlias());
		assertEquals(conditions.getOpeningDate(), conditions.getOpeningDate());
		assertEquals(conditions.getCategory(),dtoCond.getCategory());
		assertEquals(conditions.getDescription(),dtoCond.getDescription());
		assertEquals(conditions.getCommission(), dtoCond.getCommission());
		assertEquals(conditions.getActivities(), conditions.getActivities());
	}
	
	@Test
	public void mapInGetConditionsTest() {
        String productId = "00130693000100000010";
        DTOIntProduct dtoFilter = productsMapper.getDtoIntConditions(productId);
        assertEquals(productId, dtoFilter.getId());
    }

    @Test()
    public void mapMovement() {
        DTOIntMovement dtoIntMovement = new DTOIntMovement();
        Money balance = new Money();
        balance.setAmount(new BigDecimal("1000"));
        dtoIntMovement.setBalance(balance);
        dtoIntMovement.setId("");
        dtoIntMovement.setConcept("");
        DTOIntOffice dtoIntOffice = new DTOIntOffice();
        dtoIntOffice.setName("Oficina chile");
        dtoIntOffice.setPostalAddress("Calle falsa 1 2 3");
        dtoIntMovement.setOffice(dtoIntOffice);
        DTOIntOperation dtoIntOperation = new DTOIntOperation();
        dtoIntOperation.setCode("010203");
        dtoIntOperation.setDescription("Descripcion operation");
        dtoIntMovement.setOperation(dtoIntOperation);
        dtoIntMovement.setOperationDate(new Date());
        dtoIntMovement.setProductId("00000012345523");
        dtoIntMovement.setProductType("TR");
        DTOIntEnumAccountState dtoIntEnumAccountState = new DTOIntEnumAccountState();
        dtoIntEnumAccountState.setEnumValue("AC");
        dtoIntMovement.setStatus("Activo");
        Money value = new Money();
        value.setAmount(new BigDecimal("2000"));
        dtoIntMovement.setValue(value);
        dtoIntMovement.setTransactionDate(new Date());

        Movement movement = new Movement();
        movement = productsMapper.mapMovement(dtoIntMovement);

        assertEquals(  dtoIntMovement.getBalance().getAmount(), movement.getBalance().getAmount());
        assertEquals( dtoIntMovement.getId(),movement.getId());
        assertEquals( dtoIntMovement.getConcept(),movement.getConcept());
        assertEquals( dtoIntMovement.getOffice().getName(),movement.getOffice().getName());
        assertEquals( dtoIntMovement.getOffice().getPostalAddress(),movement.getOffice().getPostalAddress());
        assertEquals(dtoIntMovement.getOperation().getCode(),movement.getOperation().getCode());
        assertEquals( dtoIntMovement.getOperationDate(),movement.getOperationDate().getTime());
        assertEquals(dtoIntMovement.getStatus(),movement.getStatus());
        assertEquals(dtoIntMovement.getValue().getAmount(),movement.getValue().getAmount());
        assertEquals(dtoIntMovement.getTransactionDate(),movement.getTransactionDate().getTime());
    }

    @Test()
    public void mapMovements() {

        List<DTOIntMovement> listDTOIntMovements = new ArrayList<DTOIntMovement>();

        DTOIntMovement dtoIntMovement = new DTOIntMovement();
        Money balance = new Money();
        balance.setAmount(new BigDecimal("1000"));
        dtoIntMovement.setBalance(balance);
        dtoIntMovement.setId("1");
        dtoIntMovement.setConcept("2");
        DTOIntOffice dtoIntOffice = new DTOIntOffice();
        dtoIntOffice.setName("Oficina chile");
        dtoIntOffice.setPostalAddress("Calle falsa 1 2 3");
        dtoIntMovement.setOffice(dtoIntOffice);
        DTOIntOperation dtoIntOperation = new DTOIntOperation();
        dtoIntOperation.setCode("010203");
        dtoIntOperation.setDescription("Descripcion operation");
        dtoIntMovement.setOperation(dtoIntOperation);
        dtoIntMovement.setOperationDate(new Date());
        dtoIntMovement.setProductId("00000012345523");
        dtoIntMovement.setProductType("TR");
        DTOIntEnumAccountState dtoIntEnumAccountState = new DTOIntEnumAccountState();
        dtoIntEnumAccountState.setEnumValue("AC");
        dtoIntMovement.setStatus("Activo");
        Money value = new Money();
        value.setAmount(new BigDecimal("2000"));
        dtoIntMovement.setValue(value);
        dtoIntMovement.setTransactionDate(new Date());

        //DTO numero 2
        DTOIntMovement dtoIntMovement1 = new DTOIntMovement();

        listDTOIntMovements.add(dtoIntMovement1);
        listDTOIntMovements.add(dtoIntMovement);

        List<Movement> listMovement = new ArrayList<Movement>();
        listMovement = productsMapper.mapMovements(listDTOIntMovements);

        assertTrue(listMovement.size()>1);
        assertEquals(dtoIntMovement.getBalance().getAmount(), listMovement.get(1).getBalance().getAmount());
        assertEquals( dtoIntMovement.getId(),listMovement.get(1).getId());
        assertEquals( dtoIntMovement.getConcept(),listMovement.get(1).getConcept());
        assertEquals( dtoIntMovement.getOffice().getName(),listMovement.get(1).getOffice().getName());
        assertEquals( dtoIntMovement.getOffice().getPostalAddress(),listMovement.get(1).getOffice().getPostalAddress());
        assertEquals(dtoIntMovement.getOperation().getCode(),listMovement.get(1).getOperation().getCode());
        assertEquals( dtoIntMovement.getOperationDate(),listMovement.get(1).getOperationDate().getTime());
        assertEquals(dtoIntMovement.getStatus(),listMovement.get(1).getStatus());
        assertEquals(dtoIntMovement.getValue().getAmount(),listMovement.get(1).getValue().getAmount());
        assertEquals(dtoIntMovement.getTransactionDate(),listMovement.get(1).getTransactionDate().getTime());

    }


    @Test()
    public void getDTOIntFilterGetListMovements() {

        DTOIntFilterMovements dtoIntFilterMovements = new DTOIntFilterMovements();
        dtoIntFilterMovements=productsMapper.getDTOIntFilterGetListMovements("01020304050607080900","customerId==0102030405;productType==AH",1,10);


        assertEquals("01020304050607080900",dtoIntFilterMovements.getProductId());
        assertEquals("AH",dtoIntFilterMovements.getProductType());
        assertEquals(new Integer(1),dtoIntFilterMovements.getPaginationKey());
        assertEquals(new Integer(10),dtoIntFilterMovements.getPageSize());
    }


    @Test()
    public void getDTOIntFilterGetMovement() {

        DTOIntFilterMovements dtoIntFilterMovements = new DTOIntFilterMovements();
        dtoIntFilterMovements=productsMapper.getDTOIntFilterGetMovement("01020304050607080900", "012345678", "customerId==0102030405;productType==AH");

        assertEquals("01020304050607080900",dtoIntFilterMovements.getProductId());
        assertEquals("012345678",dtoIntFilterMovements.getMovementId());
        assertEquals("AH",dtoIntFilterMovements.getProductType());
    }

}

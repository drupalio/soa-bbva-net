package com.bbva.czic.products.facade.v01.mapper.impl;

import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.products.business.dto.*;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        dtoIntMovement.setProductType(new DTOIntEnumProductType());
        DTOIntEnumAccountState dtoIntEnumAccountState = new DTOIntEnumAccountState();
        dtoIntEnumAccountState.setEnumValue("AC");
        dtoIntMovement.setStatus(dtoIntEnumAccountState);
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
        assertEquals(dtoIntMovement.getStatus().getEnumValue(),movement.getStatus());
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
        dtoIntMovement.setProductType(new DTOIntEnumProductType());
        DTOIntEnumAccountState dtoIntEnumAccountState = new DTOIntEnumAccountState();
        dtoIntEnumAccountState.setEnumValue("AC");
        dtoIntMovement.setStatus(dtoIntEnumAccountState);
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
        assertEquals(dtoIntMovement.getStatus().getEnumValue(),listMovement.get(1).getStatus());
        assertEquals(dtoIntMovement.getValue().getAmount(),listMovement.get(1).getValue().getAmount());
        assertEquals(dtoIntMovement.getTransactionDate(),listMovement.get(1).getTransactionDate().getTime());

    }


}

package com.bbva.czic.products.facade.v01.mapper.impl;

import com.bbva.czic.dto.net.Executive;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.products.business.dto.*;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.assertEquals;

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
        assertEquals( dtoIntMovement.getOperationDate(),movement.getOperationDate());
        //assertEquals(dtoIntMovement.getProductId(),movement.get);
        //assertEquals(dtoIntMovement.getProductType(),movement.get);
        assertEquals(dtoIntMovement.getStatus(),movement.getStatus());
        assertEquals(dtoIntMovement.getValue(),movement.getValue());
        assertEquals(dtoIntMovement.getTransactionDate(),movement.getTransactionDate());
    }

    @Test()
    public void mapMovements() {


    }


}

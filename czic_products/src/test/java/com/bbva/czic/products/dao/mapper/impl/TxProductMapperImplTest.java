package com.bbva.czic.products.dao.mapper.impl;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import com.bbva.czic.products.business.dto.*;
import com.bbva.czic.products.dao.model.oznl.FormatoOZECNLE0;
import com.bbva.czic.products.dao.model.oznl.FormatoOZECNLS0;
import com.bbva.czic.products.dao.model.oznm.FormatoOZNCENM0;
import com.bbva.czic.products.dao.model.oznm.FormatoOZNCSNM0;
import org.junit.Test;

import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.products.facade.v01.mapper.impl.ProductsMapper;

/**
 * Created by Entelgy on 14/01/2015.
 */
public class TxProductMapperImplTest {

    ProductsMapper productsMapper;
    TxProductMapperImpl txProductMapper;



    public void init() { productsMapper = new ProductsMapper(); txProductMapper=new TxProductMapperImpl();}

    /**
     * Metodo encargado de mapear un DTO interno de tipo DTOIntProduct a un DTO externo de tipo Product
     * @author Andres Rojas
     * @return
     */
    @Test
    public void mapTest(){

        Conditions conditions = new Conditions();

        DTOIntConditions dtoIntConditions = new DTOIntConditions();
        dtoIntConditions.setAlias("Alias");
        dtoIntConditions.setCategory("TC");
        dtoIntConditions.setDescription("Descripcion");
        dtoIntConditions.setOpeningDate(new Date());
        dtoIntConditions.setCommission("1111");
        dtoIntConditions.setOffice(new DTOIntOffice());
        dtoIntConditions.setMobilizationConditions("1111");
        dtoIntConditions.setActivities(new DTOIntActivity());

        conditions= productsMapper.map(dtoIntConditions);

        assertEquals(dtoIntConditions.getCategory(),conditions.getCategory());
        assertEquals(dtoIntConditions.getDescription(),conditions.getDescription());
        assertEquals(dtoIntConditions.getOpeningDate(),conditions.getOpeningDate());
        assertEquals(dtoIntConditions.getCommission(),conditions.getCommission());
        assertEquals(dtoIntConditions.getOffice(),conditions.getOffice());
        assertEquals(dtoIntConditions.getMobilizationConditions(),conditions.getMobilizationConditions());
        assertEquals(dtoIntConditions.getActivities(),conditions.getActivities());

    }

    @Test
    public void mapInOznm() {

        DTOIntFilterMovements filter = new DTOIntFilterMovements();
        filter.setCustomerId("123456789");
        filter.setProductId("01020304050607080900");
        filter.setProductType("AH");
        filter.setMovementId("000011123");

        FormatoOZNCENM0 entrada = txProductMapper.mapInOznm(filter);

        assertEquals(filter.getCustomerId(),entrada.getNumcli());
        assertEquals(filter.getProductId(), entrada.getNocuent());
        assertEquals(filter.getProductType(),entrada.getTiprod());
        assertEquals(filter.getMovementId(),entrada.getNummov());
    }

    @Test
    public void mapOutOznm() {

        FormatoOZNCSNM0 salida = new FormatoOZNCSNM0();
        salida.setValor("10000");
        salida.setFchoper("2015-08-01");
        salida.setTipo("AH");
        salida.setSaldo("10000");
        salida.setResto("5000");
        salida.setBaloper("1350");
        salida.setCtroorg("OFICINA BOGOTA");
        salida.setDescodi("01");
        salida.setPlaza("Av chile");
        salida.setNumecta("01020304050607080900");
        salida.setFchvalr("2014-06-07");

        DTOIntMovement dtoIntMovement = txProductMapper.mapOutOznm(salida);

        assertEquals(salida.getValor(),dtoIntMovement.getValue().getAmount().toString());
        assertEquals(salida.getFchoper(),dtoIntMovement.getTransactionDate().toString());
        assertEquals(salida.getTipo(),dtoIntMovement.getProductType());
        assertEquals(salida.getResto(),dtoIntMovement.getConcept());
        assertEquals(salida.getBaloper(),dtoIntMovement.getBalance().getAmount().toString());
        assertEquals(salida.getDescodi(),dtoIntMovement.getOperation().getDescription());
        assertEquals(salida.getNumecta(),dtoIntMovement.getId());
        assertEquals(salida.getFchvalr(),dtoIntMovement.getOperationDate().toString());
    }

    @Test
    public void mapInOznl() {
        DTOIntFilterMovements filter = new DTOIntFilterMovements();
        filter.setProductId("01020304050607080900");
        filter.setPaginationKey(1);
        filter.setPageSize(10);
        filter.setTransactionDateStart("2015-09-01");
        filter.setTransactionDateEnd("2015-03-03");
        filter.setValueStart("1000");
        filter.setValueEnd("2000");

        FormatoOZECNLE0 entrada = txProductMapper.mapInOznl(filter);

        assertEquals(filter.getProductId(),entrada.getNumprod());
        assertEquals(filter.getPaginationKey(),entrada.getIndpagi());
        assertEquals(filter.getPageSize(),entrada.getTampagi());
        assertEquals(filter.getTransactionDateStart(),entrada.getFecini());
        assertEquals(filter.getTransactionDateEnd(),entrada.getFecfin());
        assertEquals(filter.getValueStart(),entrada.getSalinc());
        assertEquals(filter.getValueEnd(),entrada.getSalfin());
    }

    @Test
    public void mapOutOznl() {
        FormatoOZECNLS0 formatOutput = new FormatoOZECNLS0();
        formatOutput.setValorop("1000000");
        formatOutput.setTipoopr("TR");
        formatOutput.setNumoper(1200304302);
        formatOutput.setFechope(new Date());
        formatOutput.setBalance("5000");
        formatOutput.setConcept("Retiro");
        formatOutput.setDescopr("Retiro dinero cajero");


        DTOIntMovement dtoIntMovement = txProductMapper.mapOutOznl(formatOutput);

        assertEquals(formatOutput.getValorop(),dtoIntMovement.getValue());
        assertEquals(formatOutput.getTipoopr(),dtoIntMovement.getProductType());
        assertEquals(formatOutput.getNumoper(),dtoIntMovement.getOperation().getCode());
        assertEquals(formatOutput.getFechope(),dtoIntMovement.getTransactionDate());
        assertEquals(formatOutput.getBalance(),dtoIntMovement.getBalance());
        assertEquals(formatOutput.getConcept(),dtoIntMovement.getConcept());
        assertEquals(formatOutput.getDescopr(),dtoIntMovement.getOperation().getDescription());
    }


}

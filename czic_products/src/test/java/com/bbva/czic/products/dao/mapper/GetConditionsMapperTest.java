package com.bbva.czic.products.dao.mapper;

import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.products.business.dto.DTOIntActivity;
import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntOffice;
import com.bbva.czic.products.facade.v01.mapper.impl.ProductsMapper;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

/**
 * Created by Entelgy on 14/01/2015.
 */
public class GetConditionsMapperTest {

    ProductsMapper productsMapper;

    public void init() { productsMapper = new ProductsMapper(); }

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

}

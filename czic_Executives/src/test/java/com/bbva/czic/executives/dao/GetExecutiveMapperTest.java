package com.bbva.czic.executives.dao;

import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.EnumCardChargeCategory;
import com.bbva.czic.dto.net.Executive;
import com.bbva.czic.dto.net.Office;
import com.bbva.czic.executives.business.dto.DTOIntExecutive;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by Entelgy on 10/01/2015.
 */
public class GetExecutiveMapperTest {

    @Test()
    public void testMapOuter() {
        Executive executive = null;

        DTOIntExecutive dtoIntExecutive = new DTOIntExecutive();
dtoIntExecutive.setEmail("prueba@hotmail.com");
        dtoIntExecutive.setExecutiveId("1");
        dtoIntExecutive.setName("NombreEjecutivo");
        Office office = new Office();
        office.setName("oficina");
        dtoIntExecutive.setOffice(office);
        dtoIntExecutive.setPhone("");

        assertEquals(executive.getEmail(),dtoIntExecutive.getEmail());
        assertEquals(executive.getName(),dtoIntExecutive.getName());
        assertEquals(executive.getPhone(),dtoIntExecutive.getPhone());
        assertEquals(executive.getOffice().getName(),dtoIntExecutive.getOffice().getName());
        assertEquals(executive.getCustomer()
                ,dtoIntExecutive.getEmail());

    }

}

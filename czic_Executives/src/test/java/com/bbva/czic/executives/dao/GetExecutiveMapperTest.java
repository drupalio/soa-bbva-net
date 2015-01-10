package com.bbva.czic.executives.dao;

import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.EnumCardChargeCategory;
import com.bbva.czic.dto.net.Executive;
import com.bbva.czic.dto.net.Office;
import com.bbva.czic.executives.business.dto.DTOIntExecutive;
import org.junit.Test;
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
        dtoIntExecutive.setPhone("0102030405");

        executive = GetExecutiveMapper.mapOuter(dtoIntExecutive);

        assertEquals(dtoIntExecutive.getEmail(),executive.getEmail());
        assertEquals(dtoIntExecutive.getName(),executive.getName());
        assertEquals(dtoIntExecutive.getPhone(),executive.getPhone());
        assertEquals(dtoIntExecutive.getOffice().getName(),executive.getOffice().getName());
    }

}

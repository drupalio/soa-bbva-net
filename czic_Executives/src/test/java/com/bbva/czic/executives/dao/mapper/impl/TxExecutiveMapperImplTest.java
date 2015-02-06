package com.bbva.czic.executives.dao.mapper.impl;

import com.bbva.czic.dto.net.Executive;
import com.bbva.czic.dto.net.Office;
import com.bbva.czic.executives.business.dto.DTOIntExecutive;
import com.bbva.czic.executives.dao.mapper.impl.TxExecutiveMapperImpl;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by Entelgy on 10/01/2015.
 */
public class TxExecutiveMapperImplTest {

    @Test()
    public void testMapOuter() {
        Executive executive = null;

        DTOIntExecutive dtoIntExecutive = new DTOIntExecutive();
        dtoIntExecutive.setEmail("prueba@hotmail.com");
        dtoIntExecutive.setExecutiveId("1");
        dtoIntExecutive.setName("NombreEjecutivo");
        Office office = new Office();
        office.setName("oficina");
        //dtoIntExecutive.setOffice(office);
        dtoIntExecutive.setPhone("0102030405");

        //executive = TxExecutiveMapperImpl.mapOuter(dtoIntExecutive);

        assertEquals(dtoIntExecutive.getEmail(),executive.getEmail());
        assertEquals(dtoIntExecutive.getName(),executive.getName());
        assertEquals(dtoIntExecutive.getPhone(),executive.getPhone());
        assertEquals(dtoIntExecutive.getOffice().getName(),executive.getOffice().getName());
    }

}

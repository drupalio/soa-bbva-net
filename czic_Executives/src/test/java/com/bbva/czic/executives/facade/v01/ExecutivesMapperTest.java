package com.bbva.czic.executives.facade.v01;

import com.bbva.czic.dto.net.Office;
import com.bbva.czic.executives.business.dto.DTOIntExecutive;
import com.bbva.czic.executives.dao.model.oznr.FormatoOZECNRS0;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Entelgy on 10/01/2015.
 */
public class ExecutivesMapperTest {

    @Test()
    public void mapToOuter() {

        FormatoOZECNRS0 formato = new FormatoOZECNRS0();
        formato.setEmailej("pruebaemail@hotmail.com");
        formato.setIdejecu("id");
        formato.setNomejec("nombreEjectuvio");
        formato.setOfiejec("oficinaEjecutivo");
        formato.setTelejec("7684421");

        DTOIntExecutive dtoIntExecutive = null;
        dtoIntExecutive = ExecutivesMapper.mapToOuter(formato);


        assertEquals(formato.getEmailej(),dtoIntExecutive.getEmail());
        assertEquals(formato.getNomejec(),dtoIntExecutive.getName());
        assertEquals(formato.getTelejec(),dtoIntExecutive.getPhone());
        assertEquals(formato.getOfiejec(),dtoIntExecutive.getOffice().getName());
    }
}

package com.bbva.zic.executives.facade.v01.mapper.impl;

import com.bbva.zic.dto.net.Executive;
import com.bbva.zic.executives.business.dto.DTOIntExecutive;
import com.bbva.zic.executives.business.dto.DTOIntExecutivesFilter;
import com.bbva.zic.executives.business.dto.DTOIntOffice;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

/**
 * Created by Entelgy on 10/01/2015.
 */
public class ExecutivesMapperTest {

    private ExecutivesMapper executivesMapper;

    @Before
    public void init() {
        executivesMapper = new ExecutivesMapper();
        MockitoAnnotations.initMocks(this);
    }

    @Test()
    public void testMapExecutive() {
        DTOIntExecutive dtoIntExecutive = new DTOIntExecutive();
        dtoIntExecutive.setEmail("prueba@hotmail.com");
        dtoIntExecutive.setName("Nombre prueba");
        dtoIntExecutive.setExecutiveId("010203");
        dtoIntExecutive.setPhone("98765432");
        DTOIntOffice dtoIntOffice = new DTOIntOffice();
        dtoIntOffice.setName("Oficina");
        dtoIntOffice.setCode("01020020");
        dtoIntOffice.setPostalAddress("Calle falsa 1 2 3");
        dtoIntExecutive.setOffice(dtoIntOffice);

        Executive executive = new Executive();
        executive = executivesMapper.map(dtoIntExecutive);

        assertEquals(dtoIntExecutive.getName(),executive.getName());
        assertEquals(dtoIntExecutive.getEmail(),executive.getEmail());
        assertEquals(dtoIntExecutive.getExecutiveId(),executive.getId());
        assertEquals(dtoIntExecutive.getPhone(),executive.getPhone());
        assertEquals(dtoIntExecutive.getOffice().getName(),executive.getOffice().getName());
        assertEquals(dtoIntExecutive.getOffice().getCode(),executive.getOffice().getCode());
        assertEquals(dtoIntExecutive.getOffice().getPostalAddress(),executive.getOffice().getPostalAddress());


    }

    @Test
    public void getDTOIntFilter() {

        DTOIntExecutivesFilter dtoIntExecutivesFilter=    executivesMapper.getDTOIntFilter("id==010203405;type==CUSTOMER");
//        assertEquals("010203405",dtoIntExecutivesFilter.getId());
        assertEquals("CUSTOMER",dtoIntExecutivesFilter.getType());

    }
}

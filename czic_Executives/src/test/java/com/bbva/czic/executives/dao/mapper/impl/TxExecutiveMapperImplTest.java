package com.bbva.czic.executives.dao.mapper.impl;

import com.bbva.czic.dto.net.Executive;
import com.bbva.czic.dto.net.Office;
import com.bbva.czic.executives.business.dto.DTOIntExecutive;
import com.bbva.czic.executives.business.dto.DTOIntExecutivesFilter;
import com.bbva.czic.executives.dao.mapper.TxExecutiveMapper;
import com.bbva.czic.executives.dao.mapper.impl.TxExecutiveMapperImpl;
import com.bbva.czic.executives.dao.model.oznr.FormatoOZECNRE0;
import com.bbva.czic.executives.dao.model.oznr.FormatoOZECNRS0;
import com.bbva.czic.executives.facade.v01.mapper.IExecutivesMapper;
import com.bbva.czic.executives.facade.v01.mapper.impl.ExecutivesMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
/**
 * Created by Entelgy on 10/01/2015.
 */
public class TxExecutiveMapperImplTest {

    private TxExecutiveMapperImpl txExecutiveMapperImpl;


    @Before
    public void init() {
        txExecutiveMapperImpl = new TxExecutiveMapperImpl();
    }

    @Test
    public void testMapInOznr() {

        DTOIntExecutivesFilter dtoIntExecutivesFilter = new DTOIntExecutivesFilter();
        dtoIntExecutivesFilter.setType("A");
        dtoIntExecutivesFilter.setId("0100230404");

        FormatoOZECNRE0 formato = new FormatoOZECNRE0();
        formato = txExecutiveMapperImpl.mapInOznr(dtoIntExecutivesFilter);

        assertEquals(dtoIntExecutivesFilter.getId(),formato.getIdusuar());
    }

    @Test
    public void mapOutOznr() {
        FormatoOZECNRS0 formatOutput = new FormatoOZECNRS0();
        formatOutput.setEmailej("emailprueba@hotmail.com");
        formatOutput.setIdejecu("0000002122");
        formatOutput.setNomejec("Nombre ejecutivo 1");
        formatOutput.setOfiejec("Oficina chile");
        formatOutput.setTelejec("98234234");

        DTOIntExecutive dtoIntExecutive = new DTOIntExecutive();
        dtoIntExecutive = txExecutiveMapperImpl.mapOutOznr(formatOutput);

        assertEquals(formatOutput.getNomejec(),dtoIntExecutive.getName());
        assertEquals(formatOutput.getTelejec(),dtoIntExecutive.getPhone());
        assertEquals(formatOutput.getEmailej(),dtoIntExecutive.getEmail());
        assertEquals(formatOutput.getOfiejec(),dtoIntExecutive.getOffice().getName());
        assertEquals(formatOutput.getIdejecu(),dtoIntExecutive.getExecutiveId());
    }



}

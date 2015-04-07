package com.bbva.zic.executives.facade.v01.impl;

import com.bbva.zic.dto.net.Executive;
import com.bbva.zic.executives.business.ISrvIntExecutives;
import com.bbva.zic.executives.business.dto.DTOIntExecutive;
import com.bbva.zic.executives.business.dto.DTOIntExecutivesFilter;
import com.bbva.zic.executives.business.dto.DTOIntOffice;
import com.bbva.zic.executives.facade.v01.mapper.IExecutivesMapper;
import com.bbva.zic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.zic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by Entelgy on 06/02/2015.
 */
public class SrvExecutivesV01Test  extends SpringContextBbvaTest {

    @Mock
    private ISrvIntExecutives srvIntExecutives;

    @Mock
    private IExecutivesMapper iExecutivesMapper;

    @InjectMocks
    private SrvExecutivesV01 srv;

    @Before
    public void init() {
        srv = new SrvExecutivesV01();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetExecutive(){
        DTOIntExecutive exe = new DTOIntExecutive();
        exe.setPhone("01020304");
        exe.setName("Daniela Machado");
        exe.setEmail("executive@hotmail.com");
        exe.setOffice(new DTOIntOffice());

        Executive executive = new Executive();
        executive.setId("");

        when(srvIntExecutives.getExecutive(any(DTOIntExecutivesFilter.class))).thenReturn(exe);
        when(iExecutivesMapper.map(any(DTOIntExecutive.class))).thenReturn(executive);

        final Executive e = srv.getExecutive("id==010203405;type==CUSTOMER",null,null,null);

        assertNotNull(e);
    }


    @Test(expected = BusinessServiceException.class)
    public void testGetExecutiveSrvIntException(){
        BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
        when(srvIntExecutives.getExecutive(any(DTOIntExecutivesFilter.class))).thenThrow(bsn);
        srv.getExecutive("id==010203405;type==CUSTOMER", null, null, null);
    }

    @Test(expected = BusinessServiceException.class)
    public void testGetExecutiveMapperException(){
        BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
        when(iExecutivesMapper.map(any(DTOIntExecutive.class))).thenThrow(bsn);
        srv.getExecutive("id==010203405;type==CUSTOMER",null,null,null);
    }

    @Test(expected = BusinessServiceException.class)
    public void getExecutiveNoFilter(){
        final String filter = "";
        srv.getExecutive(filter,null,null,null);
    }

    @Test(expected = BusinessServiceException.class)
    public void getExecutiveBadFilter(){
        final String filter = "(date==2015-01-10)";
        srv.getExecutive(filter,null,null,null);
    }

    private BusinessServiceException getBsnExeptionByAlias(String alias){
        BusinessServiceException bse =  new BusinessServiceException(alias);
        return bse;
    }

}

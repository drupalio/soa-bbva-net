package com.bbva.czic.accounts.facade.v01;

import com.bbva.czic.accounts.business.ISrvIntAccounts;
import com.bbva.czic.accounts.business.dto.DTOIntAccount;
import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.czic.accounts.facade.v01.impl.SrvAccountsV01;
import com.bbva.czic.accounts.facade.v01.mappers.IAccountsMapper;
import com.bbva.czic.dto.net.Account;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by Entelgy on 05/02/2015.
 */
public class SrvAccountsV01Test extends SpringContextBbvaTest {

    @Mock
    private ISrvIntAccounts srvIntAccounts;

    @Mock
    private IAccountsMapper iAccountsMapper;

    @InjectMocks
    private SrvAccountsV01 srv;

    @Before
    public void init() {
        srv = new SrvAccountsV01();
        MockitoAnnotations.initMocks(this);
    }


    @Test(expected = BusinessServiceException.class)
    public void testGetAccountSrvIntException(){
        BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
        when(srvIntAccounts.getAccount(any(DTOIntFilterAccount.class))).thenThrow(bsn);
        srv.getAccount("123456");
    }

    @Test(expected = BusinessServiceException.class)
    public void testGetAccountMapperException(){
        BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
        when(iAccountsMapper.map(any(DTOIntAccount.class))).thenThrow(bsn);
        srv.getAccount("123456");
    }

//    @Test
//    public void testGetAccount(){
//        DTOIntAccount acc = new DTOIntAccount();
//        acc.setIdAccount("123456");
//
//        when(srvIntAccounts.getAccount(any(DTOIntFilterAccount.class))).thenReturn(acc);
//
//        final Account a = srv.getAccount("123456");
//
//        assertNull(a);
//    }

    private BusinessServiceException getBsnExeptionByAlias(String alias){
        return new BusinessServiceException(alias);
    }
}

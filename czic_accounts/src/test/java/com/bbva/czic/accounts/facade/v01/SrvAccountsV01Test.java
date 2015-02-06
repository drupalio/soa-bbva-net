package com.bbva.czic.accounts.facade.v01;

import com.bbva.czic.accounts.business.ISrvIntAccounts;
import com.bbva.czic.accounts.business.dto.DTOIntAccount;
import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.czic.accounts.business.dto.DTOIntMonthlyBalances;
import com.bbva.czic.accounts.facade.v01.impl.SrvAccountsV01;
import com.bbva.czic.accounts.facade.v01.mappers.IAccountsMapper;
import com.bbva.czic.dto.net.Account;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyObject;
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

    @Test
    public void testGetAccount(){
        DTOIntAccount acc = new DTOIntAccount();
        acc.setIdAccount("123456");
        Account account = new Account();
        account.setId("123");

        when(srvIntAccounts.getAccount(any(DTOIntFilterAccount.class))).thenReturn(acc);
        when(iAccountsMapper.map(any(DTOIntAccount.class))).thenReturn(account);

        final Account a = srv.getAccount("123456");

        assertNotNull(a);
    }

    @Test(expected = BusinessServiceException.class)
    public void getAccountMonthlyBalanceNoFilter(){
        final String filter = "";
        srv.getAccountMonthlyBalance("123456", filter);
    }

    @Test(expected = BusinessServiceException.class)
    public void getAccountMonthlyBalanceBadFilter(){
        final String filter = "(date==2015-01-10)";
        srv.getAccountMonthlyBalance("123456", filter);
    }

    @Test(expected = BusinessServiceException.class)
    public void getAccountMonthlyBalanceSrvIntException(){
        final String filter = "(month=ge=122014;month=le=012015)";
        BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());

        when(srvIntAccounts.getAccountMonthlyBalance(any(DTOIntFilterAccount.class))).thenThrow(bsn);

        srv.getAccountMonthlyBalance("123456", filter);
    }

    @Test(expected = BusinessServiceException.class)
    public void getAccountMonthlyBalanceMapperException(){
        final String filter = "(month=ge=122014;month=le=012015)";
        BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());

        when(iAccountsMapper.mapL(anyList())).thenThrow(bsn);

        srv.getAccountMonthlyBalance("123456", filter);
    }

    private BusinessServiceException getBsnExeptionByAlias(String alias){
        return new BusinessServiceException(alias);
    }
}

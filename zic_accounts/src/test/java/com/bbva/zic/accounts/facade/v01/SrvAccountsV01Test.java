package com.bbva.zic.accounts.facade.v01;

import com.bbva.zic.accounts.business.ISrvIntAccounts;
import com.bbva.zic.accounts.business.dto.*;
import com.bbva.zic.accounts.facade.v01.impl.SrvAccountsV01;
import com.bbva.zic.accounts.facade.v01.mappers.IAccountsMapper;
import com.bbva.zic.dto.net.*;
import com.bbva.zic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.zic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.*;
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

    // ------------------ getAccount ------------------

    @Test(expected = BusinessServiceException.class)
    public void testGetAccountSrvIntException(){
        final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
        when(srvIntAccounts.getAccount(any(DTOIntFilterAccount.class))).thenThrow(bsn);
        srv.getAccount("123456");
    }

    @Test(expected = BusinessServiceException.class)
    public void testGetAccountMapperException(){
        final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
        when(iAccountsMapper.map(any(DTOIntAccount.class))).thenThrow(bsn);
        srv.getAccount("123456");
    }

    @Test
    public void testGetAccount(){
        final DTOIntAccount acc = new DTOIntAccount();
        acc.setIdAccount("123456");
        final Account account = new Account();
        account.setId("123");

        when(srvIntAccounts.getAccount(any(DTOIntFilterAccount.class))).thenReturn(acc);
        when(iAccountsMapper.map(any(DTOIntAccount.class))).thenReturn(account);

        final Account a = srv.getAccount("123456");

        assertNotNull(a);
    }

    // ------------------- getAccountMonthlyBalance -------------------

    @Test(expected = BusinessServiceException.class)
    public void testGetAccountMonthlyBalanceNoFilter(){
        final String filter = "";
        srv.getAccountMonthlyBalance("123456", filter);
    }

    @Test(expected = BusinessServiceException.class)
    public void testGetAccountMonthlyBalanceBadFilter(){
        final String filter = "(date==2015-01-10)";
        srv.getAccountMonthlyBalance("123456", filter);
    }

    @Test(expected = BusinessServiceException.class)
    public void testGetAccountMonthlyBalanceSrvIntException(){
        final String filter = "(month=ge=122014;month=le=012015)";
        final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());

        when(srvIntAccounts.getAccountMonthlyBalance(any(DTOIntFilterAccount.class))).thenThrow(bsn);

        srv.getAccountMonthlyBalance("123456", filter);
    }

    @Test(expected = BusinessServiceException.class)
    public void testGetAccountMonthlyBalanceMapperException(){
        final String filter = "(month=ge=122014;month=le=012015)";
        final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());

        when(iAccountsMapper.mapL(anyList())).thenThrow(bsn);

        srv.getAccountMonthlyBalance("123456", filter);
    }

    @Test
    public void testGetAccountMonthlyBalance(){
        final String filter = "(month=ge=122014;month=le=012015)";
        final List<DTOIntMonthlyBalances> balances = new ArrayList<DTOIntMonthlyBalances>();
        final List<MonthlyBalances> balancesList = new ArrayList<MonthlyBalances>();

        when(srvIntAccounts.getAccountMonthlyBalance(any(DTOIntFilterAccount.class))).thenReturn(balances);
        when(iAccountsMapper.mapL(anyList())).thenReturn(balancesList);

        final List<MonthlyBalances> monthlyBalanceses = srv.getAccountMonthlyBalance("123456", filter);
        assertNotNull(monthlyBalanceses);
    }

    // ------------------- getAccMovementResume -------------------

    @Test(expected = BusinessServiceException.class)
    public void testGetAccMovementResumeBadFilter(){
        final String filter = "(date==2015-01-10)";
        srv.getAccMovementResume("123456", filter);
    }

    @Test(expected = BusinessServiceException.class)
    public void testGetAccMovementResumeSrvIntException(){
        final String filter = "(month=ge=12)";
        final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());

        when(srvIntAccounts.getAccMovementResume(any(DTOIntFilterMovResumes.class))).thenThrow(bsn);

        srv.getAccMovementResume("123456", filter);
    }

    @Test(expected = BusinessServiceException.class)
    public void testGetAccMovementResumeMapperException(){
        final String filter = "(month=ge=12)";
        final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());

        when(iAccountsMapper.map(anyListOf(DTOIntAccMovementsResume.class))).thenThrow(bsn);

        srv.getAccMovementResume("123456", filter);
    }

    @Test
    public void testGetAccMovementResume(){
        final String filter = "(month=ge=122014;month=le=012015)";
        final List<DTOIntAccMovementsResume> resumes = new ArrayList<DTOIntAccMovementsResume>();
        final List<AccMovementsResume> resumesList = new ArrayList<AccMovementsResume>();

        when(srvIntAccounts.getAccMovementResume(any(DTOIntFilterMovResumes.class))).thenReturn(resumes);
        when(iAccountsMapper.map(anyList())).thenReturn(resumesList);

        final List<AccMovementsResume> accMovementsResume = srv.getAccMovementResume("123456", filter);
        assertNotNull(accMovementsResume);
    }

    // ------------------- listCheck -------------------

    @Test(expected = BusinessServiceException.class)
    public void testListCheckNoFilter(){
        final String filter = "";
        srv.listCheck("12345600", filter, 1, 10);
    }

    @Test(expected = BusinessServiceException.class)
    public void testListCheckSrvIntException(){
        final String filter = "((issueDate=ge=2014-12-01;issueDate=le=2015-01-10),status==1)";
        final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());

        when(srvIntAccounts.listCheck(any(DTOIntFilterChecks.class))).thenThrow(bsn);

        srv.listCheck("123456", filter, 1, 10);
    }

    @Test(expected = BusinessServiceException.class)
    public void testListCheckMapperException(){
        final String filter = "((issueDate=ge=2014-12-01;issueDate=le=2015-01-10),status==1)";
        final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());

        when(iAccountsMapper.mapChecks(anyListOf(DTOIntCheck.class))).thenThrow(bsn);

        srv.listCheck("123456", filter, 1, 10);
    }

    @Test
    public void testListCheck(){
        final String filter = "((issueDate=ge=2014-12-01;issueDate=le=2015-01-10),status==1)";
        final DTOIntFilterChecks checkFilter = new DTOIntFilterChecks();
        final List<DTOIntCheck> resumes = new ArrayList<DTOIntCheck>();
        final List<Check> resumesList = new ArrayList<Check>();

        when(iAccountsMapper.getDtoIntFilterChecks(anyString(), anyString(), anyInt(), anyInt())).thenReturn(checkFilter);
        when(srvIntAccounts.listCheck(any(DTOIntFilterChecks.class))).thenReturn(resumes);
        when(iAccountsMapper.mapChecks(anyList())).thenReturn(resumesList);

        final List<Check> checks = srv.listCheck("123456", filter, 1, 10);
        assertNotNull(checks);
    }

    // ------------------- getCheckbook -------------------

    @Test(expected = BusinessServiceException.class)
    public void testGetCheckbookMappingRequestException(){
        final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());

        when(iAccountsMapper
                .getDtoIntCheckbook(anyString(), anyString())).thenThrow(bsn);

        srv.getCheckbook("123456","987654");
    }

    @Test(expected = BusinessServiceException.class)
    public void testGetCheckbookSrvIntException(){
        final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());

        when(srvIntAccounts.getCheckbooks(any(DTOIntFilterCheckbooks.class))).thenThrow(bsn);

        srv.getCheckbook("123456","987654");
    }

    @Test(expected = BusinessServiceException.class)
    public void testGetCheckbookMapperException(){
        final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());

        when(iAccountsMapper.mapCheckbooks(anyList())).thenThrow(bsn);

        srv.getCheckbook("123456", "987654");
    }

    @Test
    public void testGetCheckbook(){
        final DTOIntFilterCheckbooks checkbook = new DTOIntFilterCheckbooks();
        List<DTOIntCheckbook> bookList = new ArrayList<DTOIntCheckbook>();
        final List<Checkbook> answer = new ArrayList<Checkbook>();

        when(iAccountsMapper.getDtoIntCheckbook(anyString(), anyString())).thenReturn(checkbook);
        when(srvIntAccounts.getCheckbooks(any(DTOIntFilterCheckbooks.class))).thenReturn(bookList);
        when(iAccountsMapper.mapCheckbooks(anyList())).thenReturn(answer);

        List<Checkbook> books = srv.getCheckbook("123456", "987654");
        assertNotNull(books);
    }

    // ------------------- getCheck -------------------

    @Test(expected = BusinessServiceException.class)
    public void testGetCheckMappingRequestException(){
        final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());

        when(iAccountsMapper.getDTOIntFilterChecks(anyString(), anyString())).thenThrow(bsn);

        srv.getCheck("123456","987654");
    }

    @Test(expected = BusinessServiceException.class)
    public void testGetCheckSrvIntException(){
        final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());

        when(srvIntAccounts.getChecks(any(DTOIntCheckFilter.class))).thenThrow(bsn);

        srv.getCheck("123456","987654");
    }

    @Test(expected = BusinessServiceException.class)
    public void testGetCheckMapperException(){
        final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());

        when(iAccountsMapper.map(any(DTOIntCheck.class))).thenThrow(bsn);

        srv.getCheck("123456", "987654");
    }

    @Test
    public void testGetCheck(){
        final DTOIntCheckFilter filter = new DTOIntCheckFilter();
        final DTOIntCheck Check = new DTOIntCheck();
        final Check answer = new Check();

        when(iAccountsMapper.getDTOIntFilterChecks(anyString(), anyString())).thenReturn(filter);
        when(srvIntAccounts.getChecks(any(DTOIntCheckFilter.class))).thenReturn(Check);
        when(iAccountsMapper.map(any(DTOIntCheck.class))).thenReturn(answer);

       Check books = srv.getCheck("123456", "987654");
        assertNotNull(books);
    }

    private BusinessServiceException getBsnExeptionByAlias(String alias){
        return new BusinessServiceException(alias);
    }
}

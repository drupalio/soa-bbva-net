package com.bbva.czic.accounts.dao.impl;

import com.bbva.czic.accounts.business.dto.*;
import com.bbva.czic.accounts.dao.tx.*;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by Entelgy on 11/02/2015.
 */
public class AccountsDAOImplTest extends SpringContextBbvaTest {

    @Mock
    private TxGetAccount txtGetAccount;
    @Mock
    private TxGetAccountMonthlyBalance txGetAccountMonthlyBalance;
    @Mock
    private TxGetAccountMovementResume txGetAccountMovementResume;
    @Mock
    private TxListChecks txListCheck;
    @Mock
    private TxGetCheckbook txGetCheckbook;
    @Mock
    private TxGetCheck txGetCheck;

    private BusinessServiceException bsn = null;

    @InjectMocks
    AccountsDAOImpl dao;

    @Before
    public void init() {
        dao = new AccountsDAOImpl();
        MockitoAnnotations.initMocks(this);
        bsn = new BusinessServiceException(EnumError.TECHNICAL_ERROR.getAlias());
    }

    @Test(expected = BusinessServiceException.class)
    public void testGetChecksTxException() {
        DTOIntCheckFilter filter = new DTOIntCheckFilter();

        when(txGetCheck.invoke(any(DTOIntCheckFilter.class))).thenThrow(bsn);
        dao.getChecks(filter);
    }

    @Test
    public void testGetChecks(){
        DTOIntCheckFilter filter = new DTOIntCheckFilter();
        DTOIntCheck check = new DTOIntCheck();

        when(txGetCheck.invoke(any(DTOIntCheckFilter.class))).thenReturn(check);

        DTOIntCheck result = dao.getChecks(filter);
        assertNotNull(result);
    }

    @Test(expected = BusinessServiceException.class)
    public void testGetAccountMonthlyBalanceTxException() {
        DTOIntFilterAccount filter = new DTOIntFilterAccount();

        when(txGetAccountMonthlyBalance.invoke(any(DTOIntFilterAccount.class))).thenThrow(bsn);
        dao.getAccountMonthlyBalance(filter);
    }

    @Test
    public void testGetAccountMonthlyBalance(){
        DTOIntFilterAccount filter = new DTOIntFilterAccount();
        List<DTOIntMonthlyBalances> balances = new ArrayList<DTOIntMonthlyBalances>();

        when(txGetAccountMonthlyBalance.invoke(any(DTOIntFilterAccount.class))).thenReturn(balances);

        List<DTOIntMonthlyBalances> result = dao.getAccountMonthlyBalance(filter);
        assertNotNull(result);
    }

    @Test(expected = BusinessServiceException.class)
    public void testGetAccountMovementResumeTxException() {
        DTOIntFilterMovResumes filter = new DTOIntFilterMovResumes();

        when(txGetAccountMovementResume.invoke(any(DTOIntFilterMovResumes.class))).thenThrow(bsn);
        dao.getAccountMovementResume(filter);
    }

    @Test
    public void testGetAccountMovementResume(){
        DTOIntFilterMovResumes filter = new DTOIntFilterMovResumes();
        List<DTOIntAccMovementsResume> resumes = new ArrayList<DTOIntAccMovementsResume>();

        when(txGetAccountMovementResume.invoke(any(DTOIntFilterMovResumes.class))).thenReturn(resumes);

        List<DTOIntAccMovementsResume> result = dao.getAccountMovementResume(filter);
        assertNotNull(result);
    }

    @Test(expected = BusinessServiceException.class)
    public void testGetAccountTxException() {
        DTOIntFilterAccount filter = new DTOIntFilterAccount();

        when(txtGetAccount.invoke(any(DTOIntFilterAccount.class))).thenThrow(bsn);
        dao.getAccount(filter);
    }

    @Test
    public void testGetAccount(){
        DTOIntFilterAccount filter = new DTOIntFilterAccount();
        DTOIntAccount resumes = new DTOIntAccount();

        when(txtGetAccount.invoke(any(DTOIntFilterAccount.class))).thenReturn(resumes);

        DTOIntAccount result = dao.getAccount(filter);
        assertNotNull(result);
    }

    @Test(expected = BusinessServiceException.class)
    public void testGetListCheckTxException() {
        DTOIntFilterChecks filter = new DTOIntFilterChecks();

        when(txListCheck.invoke(any(DTOIntFilterChecks.class))).thenThrow(bsn);
        dao.getListCheck(filter);
    }

    @Test
    public void testGetListCheck(){
        DTOIntFilterChecks filter = new DTOIntFilterChecks();
        List<DTOIntCheck> resumes = new ArrayList<DTOIntCheck>();

        when(txListCheck.invoke(any(DTOIntFilterChecks.class))).thenReturn(resumes);

        List<DTOIntCheck> result = dao.getListCheck(filter);
        assertNotNull(result);
    }

    @Test(expected = BusinessServiceException.class)
    public void testGetCheckbooksTxException() {
        DTOIntFilterCheckbooks filter = new DTOIntFilterCheckbooks();

        when(txGetCheckbook.invoke(any(DTOIntFilterCheckbooks.class))).thenThrow(bsn);
        dao.getCheckbook(filter);
    }

    @Test
    public void testGetCheckbooks(){
        DTOIntFilterCheckbooks filter = new DTOIntFilterCheckbooks();
        DTOIntCheckbook book = new DTOIntCheckbook();

        when(txGetCheckbook.invoke(any(DTOIntFilterCheckbooks.class))).thenReturn(book);

        DTOIntCheckbook result = dao.getCheckbook(filter);
        assertNotNull(result);
    }
}

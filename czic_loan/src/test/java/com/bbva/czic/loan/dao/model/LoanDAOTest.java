package com.bbva.czic.loan.dao.model;

import com.bbva.czic.loan.business.dto.*;
import com.bbva.czic.loan.dao.LoanDAOImpl;
import com.bbva.czic.loan.dao.tx.TxGetRotaryQuota;
import com.bbva.czic.loan.dao.tx.TxGetRotaryQuotaMovement;
import com.bbva.czic.loan.dao.tx.TxListRotaryQuotaMovements;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by Entelgy on 05/02/2015.
 */
public class LoanDAOTest extends SpringContextBbvaTest {

    /**
     * OZNJ
     */
    @Mock
    private TxGetRotaryQuota txGetRotaryQuota;

    /**
     * OZNI
     */
    @Mock
    private TxListRotaryQuotaMovements txListRotaryQuotaMovements;

    /**
     * OZNK
     */
    @Mock
    private TxGetRotaryQuotaMovement txGetRotaryQuotaMovement;

    @InjectMocks
    private LoanDAOImpl loanDAOImpl;

    @Before
    public void init(){
        loanDAOImpl = new LoanDAOImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getRotaryQuotaDaoTest(){

        DTOIntLoan dtoIntLoan = new DTOIntLoan();

        when(txGetRotaryQuota.invoke(anyString())).thenReturn(dtoIntLoan);

        DTOIntLoan result = loanDAOImpl.getRotaryQuota(anyString());

        Mockito.verify(txGetRotaryQuota).invoke(anyString());

        Assert.assertNotNull(result);
    }

    @Test
    public void listRotaryQuotaMovementsDaoTest(){
        List<DTOIntMovement> dtoIntMovementList = new ArrayList<DTOIntMovement>();
        DTOIntFilterLoan dtoIntFilterLoan = new DTOIntFilterLoan();

        when(txListRotaryQuotaMovements.invoke(any(DTOIntFilterLoan.class))).thenReturn(dtoIntMovementList);

        List<DTOIntMovement> result =loanDAOImpl.listRotaryQuotaMovements(dtoIntFilterLoan);

        Mockito.verify(txListRotaryQuotaMovements).invoke(any(DTOIntFilterLoan.class));

        Assert.assertNotNull(result);
    }

    @Test
    public void getRotaryQuotaMovementDaoTest(){

        DTOIntRotaryQuotaMove dtoIntRotaryQuotaMove = new DTOIntRotaryQuotaMove();
        DTOIntFilterRotaryMovement dtoIntFilterRotaryMovement = new DTOIntFilterRotaryMovement();

        when(txGetRotaryQuotaMovement.invoke(any(DTOIntFilterRotaryMovement.class))).thenReturn(dtoIntRotaryQuotaMove);

        DTOIntRotaryQuotaMove result = loanDAOImpl.getRotaryQuotaMovement(dtoIntFilterRotaryMovement);

        Mockito.verify(txGetRotaryQuotaMovement).invoke(any(DTOIntFilterRotaryMovement.class));

        Assert.assertNotNull(result);
    }
}

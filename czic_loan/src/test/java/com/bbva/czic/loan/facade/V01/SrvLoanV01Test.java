package com.bbva.czic.loan.facade.V01;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.dto.net.RotaryQuotaMove;
import com.bbva.czic.loan.business.ISrvIntLoan;
import com.bbva.czic.loan.business.dto.*;
import com.bbva.czic.loan.facade.v01.impl.SrvLoanV01;
import com.bbva.czic.loan.facade.v01.mappers.ILoanMapper;
import com.bbva.czic.loan.facade.v01.utils.impl.LoanFilterConverter;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.when;

/**
 * Created by Entelgy on 06/02/2015.
 */
public class SrvLoanV01Test extends SpringContextBbvaTest {

    @Mock
    private ILoanMapper iLoanMapper;

    @Mock
    private ISrvIntLoan iSrvIntLoan;

    @Mock
    private LoanFilterConverter loanFilterConverter;

    @InjectMocks
    private SrvLoanV01 srvLoanV01;

    @Before
    public void init(){
        srvLoanV01 = new SrvLoanV01();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getRotaryQuotaTest(){

        final DTOIntLoan dtoIntLoan = new DTOIntLoan();
        dtoIntLoan.setId("1234");

        final Loan loan = new Loan();
        loan.setId("1123556");

        when(iSrvIntLoan.getRotaryQuota("123")).thenReturn(dtoIntLoan);
        when(iLoanMapper.map(any(DTOIntLoan.class))).thenReturn(loan);

        final Loan l = srvLoanV01.getRotaryQuota("123");

        Assert.assertNotNull(l);
    }

    @Test
    public void listRotaryQuotaMovementsTest(){

        final List<DTOIntMovement> dtoIntMovementList = new ArrayList<DTOIntMovement>();
        final List<Movement> movementList = new ArrayList<Movement>();

        DTOIntFilterLoan dtoIntFilterLoan = new DTOIntFilterLoan();

        String filter = "(transactionDate=ge=2014-01-12;transactionDate=le=02015-01-10)";

        Movement movement = new Movement();
        movement.setId("1234");

        final DTOIntMovement dtoIntMovement = new DTOIntMovement();
        dtoIntMovement.setId("1234");

        dtoIntMovementList.add(dtoIntMovement);

        when(iSrvIntLoan.listRotaryQuotaMovements(any(DTOIntFilterLoan.class))).thenReturn(dtoIntMovementList);
        when(loanFilterConverter.getDTOIntFilter("00816641", 5, 4, filter)).thenReturn(dtoIntFilterLoan);
        when(iLoanMapper.map(anyList())).thenReturn(movementList);

        final List<Movement> m = srvLoanV01.listRotaryQuotaMovements("00816641", 5, 4, filter);

        Assert.assertNotNull(m);
    }

    @Test
    public void getRotaryQuotaMovementTest(){

        final DTOIntRotaryQuotaMove dtoIntRotaryQuotaMove = new DTOIntRotaryQuotaMove();
        dtoIntRotaryQuotaMove.setId("1234");

        final RotaryQuotaMove rotaryQuotaMove = new RotaryQuotaMove();
        rotaryQuotaMove.setId("123456");

        when(iSrvIntLoan.getRotaryQuotaMovement(any(DTOIntFilterRotaryMovement.class))).thenReturn(dtoIntRotaryQuotaMove);
        when(iLoanMapper.map(any(DTOIntRotaryQuotaMove.class))).thenReturn(rotaryQuotaMove);

        final RotaryQuotaMove r = srvLoanV01.getRotaryQuotaMovement("1234", "4567");

        Assert.assertNotNull(r);

    }

    @Test(expected = BusinessServiceException.class)
    public void getRotaryQuotaMapperException() {

        BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());

        when(iLoanMapper.map(any(DTOIntLoan.class))).thenThrow(bsn);

        srvLoanV01.getRotaryQuota("1234");
    }

    @Test(expected = BusinessServiceException.class)
    public void listRotaryQuotaMovementsMapperException() {

        BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());

        String filter = "(transactionDate=ge=2014-01-12;transactionDate=le=02015-01-10)";

        when(iLoanMapper.map(anyList())).thenThrow(bsn);

        srvLoanV01.listRotaryQuotaMovements("00816641", 5, 4, filter);
    }

    @Test(expected = BusinessServiceException.class)
    public void getRotaryQuotaMovementException(){

        BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());

        when(iLoanMapper.map(any(DTOIntRotaryQuotaMove.class))).thenThrow(bsn);

        srvLoanV01.getRotaryQuotaMovement("1234", "56789");
    }

    private BusinessServiceException getBsnExeptionByAlias(String alias){
        return new BusinessServiceException(alias);
    }


}


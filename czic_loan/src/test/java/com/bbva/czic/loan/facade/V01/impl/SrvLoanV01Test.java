package com.bbva.czic.loan.facade.v01.impl;

import com.bbva.czic.dto.net.*;
import com.bbva.czic.loan.business.ISrvIntLoan;
import com.bbva.czic.loan.business.dto.*;
import com.bbva.czic.loan.facade.v01.ISrvLoanV01;
import com.bbva.czic.loan.facade.v01.mappers.ILoanMapper;
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
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by Entelgy on 06/02/2015.
 */
public class SrvLoanV01Test extends SpringContextBbvaTest {


    @Mock
    private ILoanMapper loanMapper;

    @Mock
    private ISrvIntLoan iSrvIntLoan;


    @InjectMocks
    private ISrvLoanV01 srvLoanV01;

    @Before
    public void init(){
        srvLoanV01 = new SrvLoanV01();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void callGetRotaryQuotaWithAllParametersOkTest(){

        final Loan loan = new Loan();
        loan.setId("1123556");

        final DTOIntLoan dtoIntLoan = new DTOIntLoan();
        dtoIntLoan.setId("1234");

        when(iSrvIntLoan.getRotaryQuota(anyString())).thenReturn(dtoIntLoan);
        when(loanMapper.map(any(DTOIntLoan.class))).thenReturn(loan);

        final Loan result = srvLoanV01.getRotaryQuota(anyString());

        Assert.assertNotNull(result);
    }

    @Test
    public void callListRotaryQuotaMovementsWithParametersAllOkTest(){

        final List<DTOIntMovement> dtoIntMovementList = new ArrayList<DTOIntMovement>();
        final List<Movement> movementList = new ArrayList<Movement>();

        String filter = "(transactionDate=ge=2014-01-12;transactionDate=le=02015-01-10)";

        Movement movement = new Movement();
        movement.setId("1234");

        movementList.add(movement);

        final DTOIntMovement dtoIntMovement = new DTOIntMovement();
        dtoIntMovement.setId("1234");

        dtoIntMovementList.add(dtoIntMovement);

        when(iSrvIntLoan.listRotaryQuotaMovements(any(DTOIntFilterLoan.class))).thenReturn(dtoIntMovementList);
        when(loanMapper.map(anyList())).thenReturn(movementList);

        final List<Movement> m = srvLoanV01.listRotaryQuotaMovements("00816641", 5, 4, filter);

        Assert.assertNotNull(m);
    }



    @Test
    public void callGetRotaryQuotaMovementWithParametersAllOkTest(){

        final DTOIntRotaryQuotaMove dtoIntRotaryQuotaMove = new DTOIntRotaryQuotaMove();
        dtoIntRotaryQuotaMove.setId("1234");

        final RotaryQuotaMove rotaryQuotaMove = new RotaryQuotaMove();
        rotaryQuotaMove.setId("123456");

        when(iSrvIntLoan.getRotaryQuotaMovement(any(DTOIntFilterRotaryMovement.class))).thenReturn(dtoIntRotaryQuotaMove);
        when(loanMapper.map(any(DTOIntRotaryQuotaMove.class))).thenReturn(rotaryQuotaMove);

        final RotaryQuotaMove result = srvLoanV01.getRotaryQuotaMovement("1234", "4567");

        Assert.assertNotNull(result);
    }

    @Test(expected = BusinessServiceException.class)
    public void converterDTOIntLoanToLoanMapperException() {

        BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());

        when(loanMapper.map(any(DTOIntLoan.class))).thenThrow(bsn);

        srvLoanV01.getRotaryQuota("1234");
    }

    @Test(expected = BusinessServiceException.class)
    public void mapperDTOIntMovementToMovementListException() {

        BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());

        String filter = "(transactionDate=ge=2014-01-12;transactionDate=le=02015-01-10)";

        when(loanMapper.map(anyList())).thenThrow(bsn);

        srvLoanV01.listRotaryQuotaMovements("00816641", 5, 4, filter);
    }

    @Test(expected = BusinessServiceException.class)
    public void filterWrongException() {

        BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());

        String filter = "(transactionDate=ge=2014-01-12";

        when(iSrvIntLoan.listRotaryQuotaMovements(any(DTOIntFilterLoan.class))).thenThrow(bsn);

        srvLoanV01.listRotaryQuotaMovements("00816641", 5, 4, filter);
    }



    private BusinessServiceException getBsnExeptionByAlias(String alias){
        return new BusinessServiceException(alias);
   }
}


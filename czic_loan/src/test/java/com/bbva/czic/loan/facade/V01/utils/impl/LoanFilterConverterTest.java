package com.bbva.czic.loan.facade.v01.utils.impl;

import com.bbva.czic.loan.business.dto.DTOIntFilterLoan;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by Entelgy on 11/02/2015.
 */
public class LoanFilterConverterTest {

    @Mock
    private LoanFilterConverter loanFilterConverter;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void callListRotaryQuotaMovementsWithParametersAllOkTest(){

        final DTOIntFilterLoan dtoIntFilterLoan = new DTOIntFilterLoan();

        String filter = "(transactionDate=ge=2014-01-12;transactionDate=le=02015-01-10)";

        when(loanFilterConverter.getDTOIntFilter("00816641", 5, 4, filter)).thenReturn(dtoIntFilterLoan);

        final DTOIntFilterLoan result = loanFilterConverter.getDTOIntFilter("00816641", 5, 4, filter);

        Assert.assertNotNull(result);




    }

}

package com.bbva.czic.globalposition.dao.utils.converters;

import com.bbva.czic.globalposition.business.dto.DTOIntBalance;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class FormatBalanceToDTOBalanceConverterTest {

    @InjectMocks
    private FormatBalanceToDTOBalanceConverter formatBalanceToDTOBalanceConverter;

    @Before
    public void init(){
        formatBalanceToDTOBalanceConverter = new FormatBalanceToDTOBalanceConverter();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void callConvert(){

        DTOIntBalance result = formatBalanceToDTOBalanceConverter.convert("1234", "56789");

        Assert.assertNotNull(result);
    }

}
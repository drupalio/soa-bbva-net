package com.bbva.czic.globalposition.dao.tx;

import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProductFilter;
import com.bbva.czic.globalposition.dao.mappers.ITxGlobalPositionMapper;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1E0;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1S0;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.any;

/**
 * @author Entelgy Colombia.
 */

public class TxGetExtractGlobalBalanceTest  {

    @Mock
    public ITxGlobalPositionMapper txGlobalPositionMapper;

    @InjectMocks
    public TxGetExtractGlobalBalanceNoTC txGetExtractGlobalBalanceNoTC;

    @Before
    public void init(){
        txGetExtractGlobalBalanceNoTC = new TxGetExtractGlobalBalanceNoTC();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void callMapDtoInToRequestFormatTest(){

        final FormatoOZECN1E0 formatoOZECN1E0 = new FormatoOZECN1E0();
        formatoOZECN1E0.setNumclie("2345678");
        formatoOZECN1E0.setTipprod("QA");

        final DTOIntProductFilter dtoIntProductFilter = new DTOIntProductFilter();
        dtoIntProductFilter.setProductType("QA");

        Mockito.when(txGetExtractGlobalBalanceNoTC.mapDtoInToRequestFormat(any(DTOIntProductFilter.class)))
                .thenReturn(formatoOZECN1E0);

        final FormatoOZECN1E0 result = txGetExtractGlobalBalanceNoTC.mapDtoInToRequestFormat(new DTOIntProductFilter());

        Assert.assertEquals(result.getTipprod(), dtoIntProductFilter.getProductType());
    }

    @Test
    public void callMapResponseFormatToDtoOutTest(){

        final DTOIntProduct dtoIntProduct = new DTOIntProduct();
        dtoIntProduct.setId("3456787543");
        dtoIntProduct.setName("Credito");
        dtoIntProduct.setAlias("Credito");
        dtoIntProduct.setProductType("QA");

        final FormatoOZECN1S0 formatoOZECN1S0 = new FormatoOZECN1S0();
        formatoOZECN1S0.setNomprod("Credito");
        formatoOZECN1S0.setTipprod("QA");
        formatoOZECN1S0.setAlias("Credito");
        formatoOZECN1S0.setNumprod("3456787543");

        Mockito.when(txGetExtractGlobalBalanceNoTC.mapResponseFormatToDtoOut(formatoOZECN1S0,
                any(DTOIntProductFilter.class)))
                .thenReturn(dtoIntProduct);

        final DTOIntProduct result = txGetExtractGlobalBalanceNoTC.mapResponseFormatToDtoOut(formatoOZECN1S0, new DTOIntProductFilter());

        Assert.assertEquals(result.getAlias(), formatoOZECN1S0.getAlias());
        Assert.assertEquals(result.getName(), formatoOZECN1S0.getNomprod());
        Assert.assertEquals(result.getId(), formatoOZECN1S0.getNumprod());
        Assert.assertEquals(result.getProductType(), formatoOZECN1S0.getTipprod());
    }

    @Test
    public void InvocadorTransaccionTest(){
        txGetExtractGlobalBalanceNoTC.getTransaction();
    }


}

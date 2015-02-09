package com.bbva.czic.products.facade.v01.impl;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.dto.net.Office;
import com.bbva.czic.products.business.ISrvIntProducts;
import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntOffice;
import com.bbva.czic.products.business.dto.DTOIntProduct;
import com.bbva.czic.products.facade.v01.mapper.IProductsMapper;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

/**
 * Created by Entelgy on 06/02/2015.
 * @author Daniel
 */
public class SrvProductsV01Test extends SpringContextBbvaTest{
	
	@Mock
    private ISrvIntProducts srvIntProducts;

    @Mock
    private IProductsMapper iProductsMapper;

    @InjectMocks
    private SrvProductsV01 srv;
    
    @Before
    public void init() {
        srv = new SrvProductsV01();
        MockitoAnnotations.initMocks(this);
    }
    
//    ------------------ getConditions ------------------
    
    @Test(expected = BusinessServiceException.class)
    public void testGetConditionsSrvIntException(){
        final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
        when(srvIntProducts.getConditions(any(DTOIntProduct.class))).thenThrow(bsn);
        srv.getConditions("12345678");
    }

    @Test(expected = BusinessServiceException.class)
    public void testGetConditionsMapperException(){
        final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
        when(iProductsMapper.map(any(DTOIntConditions.class))).thenThrow(bsn);
        srv.getConditions("12345678");
    }

    @Test
    public void testGetConditions(){
        final DTOIntConditions cond = mockDTOIntConditionsEntity();
        final Conditions conditions = mockConditionsEntity();

        when(srvIntProducts.getConditions(any(DTOIntProduct.class))).thenReturn(cond);
        when(iProductsMapper.map(any(DTOIntConditions.class))).thenReturn(conditions);

        final Conditions c = srv.getConditions("12345678");

        assertNotNull(c);
    }



//    ------------------ Utils ------------------
    
    private BusinessServiceException getBsnExeptionByAlias(String alias){
        return new BusinessServiceException(alias);
    }
    
    private Conditions mockConditionsEntity() {
		Conditions condition = new Conditions();
		condition.setOpeningDate(new GregorianCalendar());
		condition.setCategory("");
		condition.setDescription("");
		condition.setOffice(new Office());
		condition.setCommission("");
		condition.setMobilizationConditions("");
		return condition;
	}
    
	private DTOIntConditions mockDTOIntConditionsEntity() {
		DTOIntConditions condition = new DTOIntConditions();
		condition.setOpeningDate(new Date());
		condition.setCategory("");
		condition.setDescription("");
		condition.setOffice(new DTOIntOffice());
		condition.setCommission("");
		condition.setMobilizationConditions("");
		return condition;
	}    
    
    
    
}

package com.bbva.czic.products.facade.v01.impl;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bbva.czic.dto.net.AccMoveDetail;
import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.dto.net.Extract;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.dto.net.Office;
import com.bbva.czic.products.business.ISrvIntProducts;
import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntExtract;
import com.bbva.czic.products.business.dto.DTOIntFilterExtract;
import com.bbva.czic.products.business.dto.DTOIntFilterMovements;
import com.bbva.czic.products.business.dto.DTOIntMovement;
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
    public void testGetConditionsSrvIntEmptyProductId(){
        final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
        when(srvIntProducts.getConditions(any(DTOIntProduct.class))).thenThrow(bsn);
        srv.getConditions("  ");
    }
    
    @Test(expected = BusinessServiceException.class)
    public void testGetConditionsSrvIntNoProductId(){
        final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
        when(srvIntProducts.getConditions(any(DTOIntProduct.class))).thenThrow(bsn);
        srv.getConditions(null);
    }
    
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

//  ------------------ listExtracts ------------------
    
	@Test
	public void testListExtractsSrvIntNoFilter() {
		List<Extract> extracts = srv.listExtracts("00130693000100000010", "");
		assertEquals(0,extracts.size());
	}
	
	@Test(expected = BusinessServiceException.class)
	public void testListExtractsSrvIntBadDate() {
		srv.listExtracts("00130693000100000010", "(extractId=123456789;month==01;year==2016)");
	}

	@Test(expected = BusinessServiceException.class)
	public void testListExtractsSrvIntException() {
		final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
		when(srvIntProducts.listExtracts(any(DTOIntFilterExtract.class))).thenThrow(bsn);
		srv.listExtracts("00130693000100000010","(extractId=123456789;month==01;year==2015)");
	}

	@Test(expected = BusinessServiceException.class)
	public void testListExtractsMapperException() {
		final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
		when(iProductsMapper.mapExtracts(anyList())).thenThrow(bsn);
		srv.listExtracts("00130693000100000010","(extractId=123456789;month==01;year==2015)");
	}

  @Test
  public void testListExtracts(){
      final List<DTOIntExtract> dtoIntExtracts = mockDTOIntExtractsEntity();
      final List<Extract> extracts = mockExtractsEntity();

      when(srvIntProducts.listExtracts(any(DTOIntFilterExtract.class))).thenReturn(dtoIntExtracts);
      when(iProductsMapper.mapExtracts(anyList())).thenReturn(extracts);

      final List<Extract> result = srv.listExtracts("00130693000100000010","(extractId=123456789;month==01;year==2014)");

      assertNotNull(result);
  }

//    ------------------ Utils ------------------
    
	public static BusinessServiceException getBsnExeptionByAlias(String alias) {
		return new BusinessServiceException(alias);
	}

	public static Conditions mockConditionsEntity() {
		Conditions condition = new Conditions();
		condition.setOpeningDate(new GregorianCalendar());
		condition.setCategory("");
		condition.setDescription("");
		condition.setOffice(new Office());
		condition.setCommission("");
		condition.setMobilizationConditions("");
		return condition;
	}

	public static DTOIntConditions mockDTOIntConditionsEntity() {
		DTOIntConditions condition = new DTOIntConditions();
		condition.setAlias("");
		condition.setOpeningDate(new Date());
		condition.setCategory("");
		condition.setDescription("");
		condition.setOffice(new DTOIntOffice());
		condition.setCommission("");
		condition.setMobilizationConditions("");
		return condition;
	}

	public static List<Extract> mockExtractsEntity() {
		ArrayList<Extract> extracts = new ArrayList<Extract>();
		extracts.add(new Extract());
		return extracts;
	}

	public static List<DTOIntExtract> mockDTOIntExtractsEntity() {
		ArrayList<DTOIntExtract> extracts = new ArrayList<DTOIntExtract>();
		extracts.add(new DTOIntExtract());
		return extracts;
	}

    @Test
    public void testGetMovement(){
        AccMoveDetail movement = new AccMoveDetail();
        movement.setId("00000122233");

        DTOIntMovement intMovement = new DTOIntMovement();

        when(srvIntProducts.getMovement(any(DTOIntFilterMovements.class))).thenReturn(intMovement);
        when(iProductsMapper.mapMovement(any(DTOIntMovement.class))).thenReturn(movement);

        final Movement m = srv.getMovement("01020304050607080900","012345678","customerId==0102030405;productType==AH");

        assertNotNull(m);
    }

    @Test
    public void testListMovement(){
        List<Movement> listMovement = new ArrayList<Movement>();
        listMovement.add(new Movement());
        listMovement.add(new Movement());

        List<DTOIntMovement> listIntMovement = new ArrayList<DTOIntMovement>();

        when(srvIntProducts.listMovements(any(DTOIntFilterMovements.class))).thenReturn(listIntMovement);
        when(iProductsMapper.mapMovements(anyList())).thenReturn(listMovement);

        final List<Movement> listM = srv.listMovements("01020304050607080900","customerId==0102030405;productType==AH",1,10);
        assertNotNull(listM);
        assertTrue(listM.size()>1);
    }


    @Test(expected = BusinessServiceException.class)
    public void testGetMovementSrvIntException(){
        BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
        when(srvIntProducts.getMovement(any(DTOIntFilterMovements.class))).thenThrow(bsn);
        srv.getMovement("01020304050607080900", "012345678", "customerId==0102030405;productType==AH");
    }

    @Test(expected = BusinessServiceException.class)
    public void testListMovementsSrvIntException(){
        BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
        when(srvIntProducts.listMovements(any(DTOIntFilterMovements.class))).thenThrow(bsn);
        srv.listMovements("01020304050607080900", "customerId==0102030405;productType==AH",1,10);
    }

    @Test(expected = BusinessServiceException.class)
    public void testGetMovementMapperException(){
        BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
        when(iProductsMapper.mapMovement(any(DTOIntMovement.class))).thenThrow(bsn);
        srv.getMovement("01020304050607080900", "012345678", "customerId==0102030405;productType==AH");
    }

    @Test(expected = BusinessServiceException.class)
    public void testListMovementsMapperException(){
        BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
        when(iProductsMapper.mapMovements(anyList())).thenThrow(bsn);
        srv.listMovements("01020304050607080900", "customerId==0102030405;productType==AH", 1, 10);
    }

    @Test(expected = BusinessServiceException.class)
    public void testGetMovementNoFilter(){
        final String filter = "";
        srv.getMovement(null, null, filter);
    }

    @Test(expected = BusinessServiceException.class)
    public void testListMovementNoFilter(){
        final String filter = "";
        srv.listMovements("01020304050607080900", filter, 1, 10);
    }

    @Test(expected = BusinessServiceException.class)
    public void testGetMovementBadFilter(){
        final String filter = "(date==2015-01-10)";
        srv.getMovement( null, null, filter);
    }

    @Test(expected = BusinessServiceException.class)
    public void testListMovementBadFilter(){
        final String filter = "(date==2015-01-10)";
        srv.listMovements("01020304050607080900", filter, 1, 10);
    }
}

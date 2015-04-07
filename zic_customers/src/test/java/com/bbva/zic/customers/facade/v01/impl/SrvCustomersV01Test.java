package com.bbva.zic.customers.facade.v01.impl;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.bbva.zic.customers.business.dto.DTOIntCustomer;
import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bbva.zic.customers.business.ISrvIntCustomers;
import com.bbva.zic.customers.business.dto.DTOIntCardCharge;
import com.bbva.zic.customers.business.dto.DTOIntCardChargeFilter;
import com.bbva.zic.customers.business.dto.DTOIntCustomerFilter;
import com.bbva.zic.customers.facade.v01.mappers.ICustomerMapper;
import com.bbva.zic.dto.net.CardCharge;
import com.bbva.zic.dto.net.ContactInfo;
import com.bbva.zic.dto.net.Customer;
import com.bbva.zic.dto.net.Document;
import com.bbva.zic.dto.net.EnumDwelingType;
import com.bbva.zic.dto.net.EnumSegmentType;
import com.bbva.zic.dto.net.Place;
import com.bbva.zic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.zic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

/**
 * Created by Entelgy on 06/02/2015.
 * @author Daniel
 */
public class SrvCustomersV01Test extends SpringContextBbvaTest{
	
	final DataFactory dataF = new DataFactory();
	
	@Mock
    private ISrvIntCustomers srvIntCustomer;

    @Mock
    private ICustomerMapper iProductsMapper;

    @InjectMocks
    private SrvCustomersV01 srv;
    
    @Before
    public void init() {
        srv = new SrvCustomersV01();
        MockitoAnnotations.initMocks(this);
    }
    
//    ------------------ getCustomer ------------------
    
    @Test(expected = BusinessServiceException.class)
    public void testGetCustomerSrvIntEmptyCustomerId(){
        final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
        when(srvIntCustomer.getCustomer(any(DTOIntCustomerFilter.class))).thenThrow(bsn);
        srv.getCustomer("  ");
    }
    
    @Test(expected = BusinessServiceException.class)
    public void testGetCustomerSrvIntNoCustomerId(){
    	final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
        when(srvIntCustomer.getCustomer(any(DTOIntCustomerFilter.class))).thenThrow(bsn);
        srv.getCustomer(null);
    }
    
    @Test(expected = BusinessServiceException.class)
    public void testGetCustomerSrvIntException(){
    	final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
        when(srvIntCustomer.getCustomer(any(DTOIntCustomerFilter.class))).thenThrow(bsn);
        srv.getCustomer("12345678");
    }

    @Test(expected = BusinessServiceException.class)
    public void testGetCustomerMapperException(){
        final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
        when(iProductsMapper.mapCustomer(any(DTOIntCustomer.class))).thenThrow(bsn);
        srv.getCustomer("12345678");
    }

    @Test
    public void testGetCustomer(){
        final DTOIntCustomer cond = mockDTOIntCustomerEntity();
        final Customer conditions = mockCustomerEntity();

        when(srvIntCustomer.getCustomer(any(DTOIntCustomerFilter.class))).thenReturn(cond);
        when(iProductsMapper.mapCustomer(any(DTOIntCustomer.class))).thenReturn(conditions);

        final Customer c = srv.getCustomer("12345678");

        assertNotNull(c);
    }

//  ------------------ listCreditCardsCharges ------------------
    
    @Test(expected = BusinessServiceException.class)
    public void testListCreditCardChargesSrvIntEmptyCustomerId(){
        final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
        when(srvIntCustomer.listCreditCharges(any(DTOIntCardChargeFilter.class))).thenThrow(bsn);
        srv.listCreditCardsCharges("(chargeDate=ge=2015-12-24;chargeDate=le=2016-01-10)");
    }
    
    @Test(expected = BusinessServiceException.class)
    public void testListCreditCardChargesSrvIntCustomerId(){
    	final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
        when(srvIntCustomer.listCreditCharges(any(DTOIntCardChargeFilter.class))).thenThrow(bsn);
        srv.listCreditCardsCharges("");
    }
    
    @Test(expected = BusinessServiceException.class)
    public void testListCreditCardChargesSrvIntBadfilterFutureDate(){
        final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
        when(srvIntCustomer.listCreditCharges(any(DTOIntCardChargeFilter.class))).thenThrow(bsn);
        srv.listCreditCardsCharges("(chargeDate=ge=2015-12-24;chargeDate=le=2016-01-10)");
    }
    
    @Test(expected = BusinessServiceException.class)
    public void testListCreditCardChargesSrvIntBadfilterDateInterval(){
        final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
        when(srvIntCustomer.listCreditCharges(any(DTOIntCardChargeFilter.class))).thenThrow(bsn);
        srv.listCreditCardsCharges("(chargeDate=ge=2015-12-24;chargeDate=le=2014-01-10)");
    }
    
    @Test(expected = BusinessServiceException.class)
    public void testListCreditCardChargesNoFilter(){
    	final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
        when(srvIntCustomer.listCreditCharges(any(DTOIntCardChargeFilter.class))).thenThrow(bsn);
        srv.listCreditCardsCharges(null);
    }
    
    @Test(expected = BusinessServiceException.class)
    public void testListCreditCardChargesSrvIntException(){
    	final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
        when(srvIntCustomer.listCreditCharges(any(DTOIntCardChargeFilter.class))).thenThrow(bsn);
        srv.listCreditCardsCharges("(chargeDate=ge=2014-12-24;chargeDate=le=2015-01-10)");
    }

    @SuppressWarnings("unchecked")
	@Test(expected = BusinessServiceException.class)
    public void testListCreditCardChargesMapperException(){
        final BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());
        when(iProductsMapper.mapCardCharges(anyList())).thenThrow(bsn);
        srv.listCreditCardsCharges("(chargeDate=ge=2014-12-24;chargeDate=le=2015-01-10)");
    }

    @SuppressWarnings("unchecked")
	@Test
    public void testListCreditCardCharges(){
        final List<DTOIntCardCharge> dtoIntCardCharges = mockDTOIntCardChargeFilterEntity();
        final List<CardCharge> cardCharges = mockCardChargeEntity();

        when(srvIntCustomer.listCreditCharges(any(DTOIntCardChargeFilter.class))).thenReturn(dtoIntCardCharges);
        when(iProductsMapper.mapCardCharges(anyList())).thenReturn(cardCharges);

        final List<CardCharge> c = srv.listCreditCardsCharges("(chargeDate=ge=2014-12-24;chargeDate=le=2015-01-10)");

        assertNotNull(c);
    }

//    ------------------ Utils ------------------
    
	public static BusinessServiceException getBsnExeptionByAlias(String alias) {
		return new BusinessServiceException(alias);
	}

	private Customer mockCustomerEntity() {
		Customer customer = new Customer();
		customer.setId(dataF.getNumberText(8));
		customer.setName(dataF.getName());
		customer.setDocument(new Document());
		customer.setUsername(dataF.getRandomWord(7));
		customer.setContactInfo(new ContactInfo());
		customer.setStratum(dataF.getNumberBetween(1, 6));
		customer.setHomeMembers(dataF.getNumberBetween(0, 6));
		customer.setLastAccessDate(dataF.getDate(2015, 1, 1).toString());
		customer.setHomeLocation(new Place());
		customer.setOfficeLocation(new Place());
		customer.setDwelingType("6");
		customer.setResidenceYears(dataF.getNumberBetween(0, 10));
		customer.setSegment("CORPORATIVO");
		return customer;
	}

	private DTOIntCustomer mockDTOIntCustomerEntity() {
		DTOIntCustomer customer = new DTOIntCustomer();
		customer.setId(dataF.getNumberText(8));
		customer.setName(dataF.getName());
		customer.setDocument(new Document());
		customer.setUsername(dataF.getRandomWord(7));
		customer.setStratum(dataF.getNumberBetween(1, 6));
		customer.setHomeMembers(dataF.getNumberBetween(0, 6));
		customer.setLastConnectionTime(dataF.getDate(2015, 1, 1).toString());
		customer.setHomeLocation(new Place());
		customer.setOfficeLocation(new Place());
		customer.setDwelingType(EnumDwelingType.VALIDAR.toString());
		customer.setResidenceYears(dataF.getNumberBetween(0, 10));
		customer.setSegment(EnumSegmentType.CORPORATIVO.toString());
		return customer;
	}

	private List<DTOIntCardCharge> mockDTOIntCardChargeFilterEntity() {
		List<DTOIntCardCharge> list = new ArrayList<DTOIntCardCharge>();
		list.add(new DTOIntCardCharge());
		return list;
	}

	private List<CardCharge> mockCardChargeEntity() {
		List<CardCharge> list = new ArrayList<CardCharge>();
		list.add(new CardCharge());
		return list;
	}

}

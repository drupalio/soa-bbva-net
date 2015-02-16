package com.bbva.czic.customers.dao.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.bbva.czic.customers.dao.mappers.impl.TxCustomerMapper;
import com.bbva.czic.dto.net.*;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.bbva.czic.customers.business.SrvIntCustomersTest;
import com.bbva.czic.customers.business.dto.DTOIntCustomer;
import com.bbva.czic.customers.dao.model.oznb.FormatoOZNCSNB0;
import com.bbva.czic.customers.dao.model.oznp.FormatoOZECNPS0;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;

/**
 * Created by Entelgy on 15/01/2015.
 */

public class CustomerMapperTest {

	private TxCustomerMapper customerMapper;

	public void testMapToDTOIntCardCharge() {
		// SetUp
		FormatoOZECNPS0 formatoOZECNPS0;
		// Setup expectation

		// SUT execution

		// Validation
	}

	private FormatoOZECNPS0 mockOZECNPS0() {
		FormatoOZECNPS0 mock = new FormatoOZECNPS0();
		mock.setCategor("Categoria");
		mock.setValcate(new BigDecimal(100));
		return mock;
	}

	@Test
	public void enumTest() {
		EnumSegmentType a = EnumSegmentType.valueOf("PERSONA");
		Assert.assertNotNull(a);
	}
	
	@Test
	public void formatoOZNBSalidaADTOIntCustomerTest(){
		customerMapper = new TxCustomerMapper();
		DTOIntCustomer customer = customerMapper.mapOutOznb(mockFormatoOZNBSalida());
		Assert.assertEquals(mockDTOCustomer().getDwelingType(),customer.getDwelingType());
		Assert.assertEquals(mockDTOCustomer().getSegment(),customer.getSegment());
	}

	private FormatoOZNCSNB0 mockFormatoOZNBSalida() {
		FormatoOZNCSNB0 formatoS = new FormatoOZNCSNB0();
		formatoS.setNomclie("Cliente de prueba");
		formatoS.setSegment("PERSONA");
		formatoS.setCorreo("prueba@bbva.com");
		formatoS.setEstrato("4");
		formatoS.setAnosvda("1");
		formatoS.setTpovvda("VALIDAR");
		formatoS.setCiudvia("city");
		formatoS.setDepavia("State");
		formatoS.setPaisvia("Country");
		formatoS.setDescvia("BBVA");
		formatoS.setCiudofi("city");
		formatoS.setDepaofi("State");
		formatoS.setPaisofi("Country");
		formatoS.setDescofi("BBVA");
		formatoS.setNropnas("1");
		return formatoS;
	}

	private static DTOIntCustomer mockDTOCustomer() {
		DTOIntCustomer customer = new DTOIntCustomer();

//		Document documento = new Document();
//		documento.setNumber("1234567890");
//		documento.setType(EnumDocumentType.CEDULACIUDADANIA);

		ContactInfo contacto = new ContactInfo();
		List<Email> emails = new ArrayList<Email>();
		Email email = new Email();
		email.setActive(true);
		email.setAddress("prueba@bbva.com");
		email.setPrimary(true);
		email.setSource(EnumContactSourceType.WEB);
		emails.add(email);
		contacto.setEmails(emails);
		contacto.setPhoneNumbers(new ArrayList<PhoneNumber>());

		Place homeLocation= new Place();
		homeLocation.setCityName("city");
		homeLocation.setCountryName("Country");
		homeLocation.setStateName("State");
		homeLocation.setPostalAddress("BBVA");

		customer.setId("1");
//		customer.setDocument(documento);
		customer.setSegment(EnumSegmentType.PERSONA.toString());
		customer.setName("Cliente de prueba");
		customer.setEmails(contacto);
		customer.setHomeLocation(homeLocation);
		customer.setOfficeLocation(homeLocation);
		customer.setStratum(4);
		customer.setResidenceYears(1);
		customer.setHomeMembers(1);
		customer.setDwelingType(EnumDwelingType.VALIDAR.toString());
		return customer;
	}
}

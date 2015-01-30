package com.bbva.czic.customers.dao.mappers;

import java.math.BigDecimal;

import javax.annotation.Resource;

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
import com.bbva.czic.dto.net.EnumSegmentType;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;

/**
 * Created by Entelgy on 15/01/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = BusinessServiceTestContextLoader.class, locations = {
		"classpath*:/META-INF/spring/applicationContext-*.xml",
		"classpath:/META-INF/spring/business-service.xml",
		"classpath:/META-INF/spring/business-service-test.xml" })
@TestExecutionListeners(listeners = {
MockInvocationContextTestExecutionListener.class,
DependencyInjectionTestExecutionListener.class })
public class CustomerMapperTest {

	@Resource(name = "txCustomerMapper")
	private ITxCustomerMapper customerMapper;

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
		DTOIntCustomer customer = customerMapper.mapOutOznb(mockFormatoOZNBSalida());
		Assert.assertEquals(SrvIntCustomersTest.mockDTOCustomer().getDwelingType(),customer.getDwelingType());
		Assert.assertEquals(SrvIntCustomersTest.mockDTOCustomer().getSegment(),customer.getSegment());
	}

	private FormatoOZNCSNB0 mockFormatoOZNBSalida() {
		FormatoOZNCSNB0 formatoS = new FormatoOZNCSNB0();
		formatoS.setNumclie("1");
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
}

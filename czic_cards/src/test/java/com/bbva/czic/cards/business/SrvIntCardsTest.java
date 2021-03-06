package com.bbva.czic.cards.business;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.bbva.czic.cards.business.dto.DTOIntCardCharge;
import com.bbva.czic.cards.dao.CardsDAO;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = BusinessServiceTestContextLoader.class, locations = {
		"classpath*:/META-INF/spring/applicationContext-*.xml",
		"classpath:/META-INF/spring/business-service.xml",
		"classpath:/META-INF/spring/business-service-test.xml" })
@ActiveProfiles(profiles = "dev")
@TestExecutionListeners(listeners = {
MockInvocationContextTestExecutionListener.class,
DependencyInjectionTestExecutionListener.class })
public class SrvIntCardsTest {

	@Mock
	CardsDAO cardsDAO;

	@InjectMocks
	@Autowired
	ISrvIntCards srv;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

//	@Test(expected = BusinessServiceException.class)
//	public void testFilterFormatoFechasIncorrectos() {
//		srv.getCreditCardCharges("1",
//				"chargeDate=ge=fecha1;chargeDate=le=fecha2");
//	}
//
//	@Test(expected = BusinessServiceException.class)
//	public void testFilterErrorSintaxis() {
//		srv.getCreditCardCharges("1", "chargeDate=ge=10/01/2014");
//	}
//
//	@Test(expected = BusinessServiceException.class)
//	public void testThrowExceptionIsFilterNull() {
//		srv.getCreditCardCharges(null, null);
//	}
//
//	@Test(expected = BusinessServiceException.class)
//	public void testNombreParametrosInvalidos() {
//		srv.getCreditCardCharges("1", "fakeParameter=ge=10/01/2014");
//	}
//
//	@Test
//	public void testGetCreditCardChargesSucces() {
//		// setUp - data
//		List<DTOIntCardCharge> initialResultList = new ArrayList<DTOIntCardCharge>();
//		DTOIntCardCharge dtoIntCardCharge = new DTOIntCardCharge();
//		initialResultList.add(dtoIntCardCharge);
//
//		// setUp - expectation
//		when(cardsDAO.getCreditCardCharges("1", new Date(), new Date()))
//				.thenReturn(initialResultList);
//
//		// SUT's excecution
//		List<DTOIntCardCharge> carChargeList = srv.getCreditCardCharges("1",
//				"chargeDate=ge=2014-10-01;chargeDate=le=2014-11-01");
//
//		// validation
//		assertNotNull(carChargeList);
//	}
}

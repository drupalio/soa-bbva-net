package com.bbva.czic.cards.facade.v01;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.bbva.czic.cards.business.ISrvIntCards;
import com.bbva.czic.cards.business.dto.DTOIntCardCharge;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = BusinessServiceTestContextLoader.class, locations = { "classpath*:/META-INF/spring/applicationContext-*.xml",
		"classpath:/META-INF/spring/business-service.xml", "classpath:/META-INF/spring/business-service-test.xml" })
@TestExecutionListeners(listeners = {
MockInvocationContextTestExecutionListener.class,
DependencyInjectionTestExecutionListener.class })
public class SrvCardsV01Test {

	@Mock
	ISrvIntCards srvIntMock;

	@InjectMocks
	@Autowired
	SrvCardsV01Mock srv;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test()
	public void testSrvCardsV01() {
//		List<DTOIntCardCharge> listaDtoIntCardCharge = new ArrayList<DTOIntCardCharge>();
//		listaDtoIntCardCharge.add(new DTOIntCardCharge());
//		listaDtoIntCardCharge.add(new DTOIntCardCharge());
//
//		List<CardCharge> listaDTOCardCharge = null;
//
//		// setUp - expectation
//
////		when(srvIntMock.getCreditCardCharges("1", "1")).thenReturn(listaDtoIntCardCharge);
////
////		doReturn(listaDtoIntCardCharge).when(srvIntMock).getCreditCardCharges("1", "1");
//
//		// SUT's excecution
//		listaDTOCardCharge = srv.getCreditCardCharges("1", "1", null, null, null);
//
//		// validation
//		assertEquals(2, listaDTOCardCharge.size());
	}
}

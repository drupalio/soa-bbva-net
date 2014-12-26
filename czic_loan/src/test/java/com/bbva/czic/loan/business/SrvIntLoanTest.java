package com.bbva.czic.loan.business;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = BusinessServiceTestContextLoader.class, locations = {"classpath*:/META-INF/spring/applicationContext-*.xml", "classpath:/META-INF/spring/business-service.xml", "classpath:/META-INF/spring/business-service-test.xml"})
@TestExecutionListeners(listeners = {MockInvocationContextTestExecutionListener.class, DependencyInjectionTestExecutionListener.class})
public class SrvIntLoanTest {
	
	@Autowired
	ISrvIntLoan srv;

		
	@Test
	public void testGetRotaryQuotaMovements() {
		//TODO: call srv.getRotaryQuotaMovements
	}

		
	@Test
	public void testGetRotaryQuota() {
		//TODO: call srv.getRotaryQuota
	}

		
	@Test
	public void testGetRotaryQuotaMovement() {
		//TODO: call srv.getRotaryQuotaMovement
	}

	
	
}


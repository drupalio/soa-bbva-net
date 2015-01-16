package com.bbva.czic.loan.business.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;

/**
 *  
 * @author Sebastian Gamba - Entelgy Col. 
 * @since 8/01/2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = BusinessServiceTestContextLoader.class, locations = {
		"classpath*:/META-INF/spring/applicationContext-*.xml", "classpath:/META-INF/spring/business-service.xml",
		"classpath:/META-INF/spring/business-service-test.xml" })
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class })
public class LoanDAOImplTest {
	
	
	@Test
	public void getRotaryQuotaTest(){
		
	}
}

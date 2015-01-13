package com.bbva.czic.accounts.business;

import com.bbva.czic.accounts.dao.AccountsDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = BusinessServiceTestContextLoader.class, locations = {
		"classpath*:/META-INF/spring/applicationContext-*.xml", "classpath:/META-INF/spring/business-service.xml",
		"classpath:/META-INF/spring/business-service-test.xml" })
@TestExecutionListeners(listeners = { // MockInvocationContextTestExecutionListener.class,
		DependencyInjectionTestExecutionListener.class })
public class SrvIntAccountsTest {
	
	@Mock
	AccountsDAO accountDAO;

	@InjectMocks
	@Autowired
	ISrvIntAccounts srv;

	@Test(expected = BusinessServiceException.class)
	public void testThrowExceptionIfAccountIDNull() {
		
		//Configurar Datos
		String id = null;
		//srv.getAccount(id);
	}

	
	
	
	
	
	
	
	@Test
	public void testGetAccount() {
		// TODO: call srv.getAccount
	}

	@Test
	public void testGetMovement() {
		// TODO: call srv.getMovement
	}

}

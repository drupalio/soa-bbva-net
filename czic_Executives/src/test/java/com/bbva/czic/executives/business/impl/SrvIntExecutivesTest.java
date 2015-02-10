package com.bbva.czic.executives.business.impl;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bbva.czic.executives.business.ISrvIntExecutives;
import com.bbva.czic.executives.business.dto.DTOIntExecutive;
import com.bbva.czic.executives.dao.ExecutivesDAO;
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
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;

public class SrvIntExecutivesTest {

	@Mock
	ExecutivesDAO executivesDAO;

	@InjectMocks
	@Autowired
	ISrvIntExecutives iSrvIntExecutives;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected = BusinessServiceException.class)
	public void testFilterFormatoParametrosFilterIncorrectos() {
//		iSrvIntExecutives.getExecutive("id==1108;type==ge)");
	}

	@Test(expected = BusinessServiceException.class)
	public void testFilterFormatoParametrosFilterNullos() {
		//iSrvIntExecutives.getExecutive("id==null;type==null)");
	}

	@Test()
	public void testGetExecutiveSucces() {
		DTOIntExecutive initialResult =null;

		// setUp - expectation
	//	when(executivesDAO.getExecutive("1108"))
	//			.thenReturn(new DTOIntExecutive());

	//	initialResult= iSrvIntExecutives.getExecutive("id==1108;type==CUSTOMER");
		assertNotNull(initialResult);
	}
}


package com.bbva.czic.executives.business.impl;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;

import com.bbva.czic.executives.business.ISrvIntExecutives;
import com.bbva.czic.executives.business.dto.DTOIntExecutive;
import com.bbva.czic.executives.business.dto.DTOIntExecutivesFilter;
import com.bbva.czic.executives.business.dto.DTOIntOffice;
import com.bbva.czic.executives.dao.ExecutivesDAO;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
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

public class SrvIntExecutivesTest extends SpringContextBbvaTest {

	@Mock
	ExecutivesDAO executivesDAO;

	@InjectMocks
	SrvIntExecutives srv;


	private BusinessServiceException bsn = null;

	@Before
	public void init() {
		srv = new SrvIntExecutives();
		MockitoAnnotations.initMocks(this);
		bsn = new BusinessServiceException(EnumError.TECHNICAL_ERROR.getAlias());
	}

	@Test(expected = BusinessServiceException.class)
	public void testGetExecutiveInvalidFilter(){
		final DTOIntExecutivesFilter filterExecutive = new DTOIntExecutivesFilter();
		filterExecutive.setId("123456");

		srv.getExecutive(filterExecutive);
	}

	@Test(expected = BusinessServiceException.class)
	public void testGetExecutiveInvalidExecutiveId(){
		final DTOIntExecutivesFilter filterExecutive = new DTOIntExecutivesFilter();
		filterExecutive.setId("ABCDE");

		srv.getExecutive(filterExecutive);
	}

	@Test(expected = BusinessServiceException.class)
	public void testGetExecutiveDaoException(){
		final DTOIntExecutivesFilter filterExecutive = new DTOIntExecutivesFilter();
		filterExecutive.setId("ABCDE");

		when(executivesDAO.getExecutive(any(DTOIntExecutivesFilter.class)))
				.thenThrow(bsn);

		srv.getExecutive(filterExecutive);
	}

	@Test(expected = BusinessServiceException.class)
	public void testGetExecutiveOutputException(){
		final DTOIntExecutivesFilter filterExecutive = new DTOIntExecutivesFilter();
		filterExecutive.setId("ABCDE");

		final DTOIntExecutive dtoIntExecutive = new DTOIntExecutive();
		dtoIntExecutive.setName("Rodolfo Mesa");


		when(executivesDAO.getExecutive(any(DTOIntExecutivesFilter.class)))
				.thenReturn(dtoIntExecutive);

		srv.getExecutive(filterExecutive);
	}

	@Test
	public void testGetExecutive(){
		final DTOIntExecutivesFilter filterExecutive = new DTOIntExecutivesFilter();
		filterExecutive.setId("123456");
		filterExecutive.setType("CUSTOMER");

		final DTOIntExecutive dtoIntExecutive = new DTOIntExecutive();
		dtoIntExecutive.setName("Rodolfo Mesa");
		dtoIntExecutive.setOffice(new DTOIntOffice());
		dtoIntExecutive.setPhone("7685544");
		dtoIntExecutive.setExecutiveId("123456");
		dtoIntExecutive.setEmail("ejecutivo@email.com");


		when(executivesDAO.getExecutive(any(DTOIntExecutivesFilter.class)))
				.thenReturn(dtoIntExecutive);

	DTOIntExecutive respuesta = 	srv.getExecutive(filterExecutive);

		assertNotNull(respuesta);
		assertEquals(respuesta.getName(),dtoIntExecutive.getName());
		assertEquals(respuesta.getPhone(),dtoIntExecutive.getPhone());
		assertEquals(respuesta.getExecutiveId(),dtoIntExecutive.getExecutiveId());
		assertEquals(respuesta.getEmail(),dtoIntExecutive.getEmail());
	}
}


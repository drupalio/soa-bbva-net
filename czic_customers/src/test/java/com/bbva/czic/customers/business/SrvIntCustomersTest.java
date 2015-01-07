package com.bbva.czic.customers.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntEnumMonth;
import com.bbva.czic.customers.business.dto.DTOIntProduct;
import com.bbva.czic.customers.business.impl.SrvIntCustomers;
import com.bbva.czic.customers.dao.CustomersDAO;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = BusinessServiceTestContextLoader.class, 
locations = {"classpath*:/META-INF/spring/applicationContext-*.xml",
	"classpath:/META-INF/spring/business-service.xml",
	"classpath:/META-INF/spring/business-service-test.xml"})

@TestExecutionListeners(listeners = {MockInvocationContextTestExecutionListener.class, DependencyInjectionTestExecutionListener.class})
public class SrvIntCustomersTest {
	

		@Mock
		CustomersDAO cutomersDAO;
		

		@InjectMocks
		public List<DTOIntAccMovementsResume> getlistAccountsMovementsResume;
		
		@Autowired
		SrvIntCustomers srv;

		@Before
		public void init() {
			MockitoAnnotations.initMocks(this);
		}

	@Test
	public void getListMovements () {
		//setUp - data
		List<DTOIntAccMovementsResume> accMovementsResumes = getListAccountMovements();

		//setUp - expectation
		when(cutomersDAO.getlistAccountsMovementsResume(anyString(), null, null)).thenReturn(accMovementsResumes);
		//SUT's excecution
		final List<AccMovementsResume> Result = srv.getlistAccountsMovementsResume("idclie",null);
		

		//validation
		assertEquals(5, Result.size());
	}
	//aplicacion de filtro income para movimientos 
	

	@Test
	public void testFilterMovements(){
		//setUp - data
		final List<DTOIntAccMovementsResume> AccMovementsResume = getListAccountMovements();

		//setUp - expectation
		//when(CustomersDAO.getlistAccountsMovementsResume(anyString(), String)).thenReturn(AccMovementsResume);
		when(cutomersDAO.getlistAccountsMovementsResume(anyString(), null, null)).thenReturn(AccMovementsResume);

		//SUT's excecution
		final List<AccMovementsResume> Result = srv.getlistAccountsMovementsResume("111", "(income==6776)");

		//validation
		assertEquals(1, Result.size());
	}

	@Test(expected = BusinessServiceException.class)
	public void testFilterErrorShouldThrowABusinessException() {
		//setUp - data
		final List<DTOIntAccMovementsResume> AccMovementsResume = getListAccountMovements();

		//setUp - expectation
		when(cutomersDAO.getlistAccountsMovementsResume(anyString(),null, null)).thenReturn(AccMovementsResume);

		//SUT's excecution
		final List<AccMovementsResume> Result = srv.getlistAccountsMovementsResume("111", "(uberTroter==ED)");
	}

	@Test
	public void testModifyProduct() {

	}

	private List<DTOIntAccMovementsResume> getListAccountMovements() {

		List<DTOIntAccMovementsResume> intMovements = new ArrayList<DTOIntAccMovementsResume>();
		

		DTOIntAccMovementsResume intacc = new DTOIntAccMovementsResume();
	/*	final Money availableMoney = new Money(Currency.getInstance("COP"),new BigDecimal(availableBalance));
		final Money availableMoney2 = new Money(Currency.getInstance("COP"),new BigDecimal(availableBalance));
		intacc.setIncome(availableMoney);
		intacc.setBalance(availableMoney2);
		intacc.setOutcome(availableMoney);
		intacc.setMonth(DTOIntEnumMonth.DECEMBER);
		 
		
		getlistAccountsMovementsResume.add(intacc);
		*/
		return intMovements;
	
}
}





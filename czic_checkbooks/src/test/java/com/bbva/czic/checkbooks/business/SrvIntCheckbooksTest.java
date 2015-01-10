package com.bbva.czic.checkbooks.business;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.staticmock.MockStaticEntityMethods;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.dao.CheckbooksDAO;
import com.bbva.czic.checkbooks.dao.CheckbooksDAOImpl;
import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;
import com.bbva.czic.dto.net.EnumCheckStatus;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = BusinessServiceTestContextLoader.class, locations = {
		"classpath*:/META-INF/spring/applicationContext-*.xml",
		"classpath:/META-INF/spring/business-service.xml",
		"classpath:/META-INF/spring/business-service-test.xml" })
@TestExecutionListeners(listeners = {
		//MockInvocationContextTestExecutionListener.class,
		DependencyInjectionTestExecutionListener.class })
public class SrvIntCheckbooksTest {

	@Mock
	CheckbooksDAO checkbooksDao;
    
	@InjectMocks
	@Autowired
	ISrvIntCheckbooks ch;
	
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test(expected= BusinessServiceException.class)
	public void testGetExcepctionIfCheckbookNull () {
		
		//setUp -data
		String id =null;

		// SUT's excecution
		ch.getCheckbooks(id);
		
	}
	
	//final List<Checkbook> cheques= ch.getCheckbooks(null);
/*
	@Test
	public void testGetChecksIfNoFilter() {
		// setUp - data
		// List<DTOIntCheck> chequ = getList();

		// setUp - expectation
		// when (checkbooksDao.getChecks(anyString(), null, null, null, null,
		// null)).thenReturn(chequ);
		// when(CheckbooksDAO(anyString())).thenReturn(products);

		// SUT's excecution
	//	final List<Check> Result = srv.getChecks("5686", "12", 1, 10);

		// validation
		assertEquals(0, Result.size());
	}
	*/
	
	

	/*
	 * private List<DTOIntCheck> getList() {
	 * 
	 * List<DTOIntCheck> cheques = new ArrayList<DTOIntCheck>();
	 * 
	 * DTOIntCheck cheque = new DTOIntCheck(); cheque.setId("53");
	 * cheque.setIssueDate(issueDate); cheque.setModifiedDate(modifiedDate);
	 * cheque.setStatus(status); cheque.setValue(value);
	 * 
	 * //intProduct.setProductType("PC");
	 * //intProduct.setProductType(DTOIntEnumProductType.PC.name());
	 * 
	 * intProducts.add(cheques);
	 * 
	 * 
	 * }
	 */
	
	
	
}

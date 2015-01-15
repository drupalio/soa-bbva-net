package com.bbva.czic.customers.dao.mapper;


import com.bbva.czic.customers.dao.model.oznp.FormatoOZECNPS0;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * Created by Entelgy on 15/01/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = BusinessServiceTestContextLoader.class, locations = {"classpath*:/META-INF/spring/applicationContext-*.xml", "classpath:/META-INF/spring/business-service.xml", "classpath:/META-INF/spring/business-service-test.xml"})
@TestExecutionListeners(listeners = {
//		MockInvocationContextTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class
})
public class CustomerMapperTest {

    @Resource(name = "customerMapper")
    private ICustomerMapper customerMapper;

    public void testMapToDTOIntCardCharge(){
        //SetUp
        FormatoOZECNPS0 formatoOZECNPS0;
        //Setup expectation

        // SUT execution

        // Validation
    }

    private FormatoOZECNPS0 mockOZECNPS0(){
        FormatoOZECNPS0 mock = new FormatoOZECNPS0();
        mock.setCategor("Categoria");
        mock.setValcate(new BigDecimal(100));
        return mock;
    }
}


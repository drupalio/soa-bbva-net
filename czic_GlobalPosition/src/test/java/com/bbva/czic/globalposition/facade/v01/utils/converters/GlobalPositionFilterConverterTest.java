package com.bbva.czic.globalposition.facade.v01.utils.converters;

import com.bbva.czic.globalposition.business.dto.DTOIntFilterProduct;
import com.bbva.czic.globalposition.facade.v01.utils.converters.GlobalPositionFilterConverter;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import org.apache.cxf.Bus;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = BusinessServiceTestContextLoader.class, locations = {"classpath*:/META-INF/spring/applicationContext-*.xml", "classpath:/META-INF/spring/business-service.xml", "classpath:/META-INF/spring/business-service-test.xml"})
@TestExecutionListeners(listeners = {
//		MockInvocationContextTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class
})
public class GlobalPositionFilterConverterTest {

    @Resource(name = "global-position-filter-converter")
    GlobalPositionFilterConverter gpFilterConverter;

    @Test(expected = BusinessServiceException.class)
    public void testThrowExceptionIfCustomerIdIsNull() {
        // Setup data
        final String customerId = "";
        final String filter = "(productType==TC)";

        // SUT execution
        gpFilterConverter.getDTOIntFilter(customerId, filter);

    }

    @Test
    public void testEmptyProductTypeIfFilterIsNull() {
        // Setup data
        final String customerId = "1234";
        final String filter = null;

        // SUT execution
        final DTOIntFilterProduct filterProduct = gpFilterConverter.getDTOIntFilter(customerId, filter);

        // Validation
        assertEquals("", filterProduct.getProductType());
    }

    @Test(expected = BusinessServiceException.class)
    public void testThrowExceptionIfFilterIsMalformed() {
        // Setup data


        // Setup expectation


        // SUT execution

    }

}

package com.bbva.czic.customers.facade.v01.utils.converters;

import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.czic.customers.business.dto.DTOIntFilterCustomerResumes;
import com.bbva.czic.customers.facade.v01.utils.converters.impl.CustResumesFilterConverter;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;
import org.apache.cxf.jaxrs.ext.search.ConditionType;
import org.apache.cxf.jaxrs.ext.search.PrimitiveStatement;
import org.apache.cxf.jaxrs.ext.search.SearchCondition;
import org.apache.cxf.jaxrs.ext.search.SearchParseException;
import org.apache.cxf.jaxrs.ext.search.fiql.FiqlParser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by Entelgy on 11/01/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = BusinessServiceTestContextLoader.class, locations = {"classpath*:/META-INF/spring/applicationContext-*.xml", "classpath:/META-INF/spring/business-service.xml", "classpath:/META-INF/spring/business-service-test.xml"})
@TestExecutionListeners(listeners = {
//		MockInvocationContextTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class
})
public class CustResumesFilterConverterTest {

    @Resource(name = "customer-resumes-filter-converter")
    CustResumesFilterConverter converter;

    @Test
    public void testToCustomerResumesFilter(){
        //SetUp

        //Setup expectation

        // SUT execution
        DTOIntFilterCustomerResumes resumeFilter = converter.
                toCustomerResumesFilter("(chargeDate=ge=2014-12-24;chargeDate=le=2015-01-10)");

        //Validation
        assertNotNull(resumeFilter);
    }

    @Test(expected = BusinessServiceException.class)
    public void testToCustomerResumesFilterInvalidFilterFormat(){
        //SetUp

        //Setup expectation

        // SUT execution
        DTOIntFilterCustomerResumes resumeFilter = converter.
                toCustomerResumesFilter("(chargeDate=ge=2014/12/24;chargeDate=le=2015/01/10)");
    }

    @Test(expected = BusinessServiceException.class)
    public void testToCustomerResumesInvalidFilter(){
        //SetUp

        //Setup expectation

        // SUT execution
        DTOIntFilterCustomerResumes resumeFilter = converter.
                toCustomerResumesFilter("(chargeDate=le=2015-01-10)");
    }

    @Test
    public void testToCustomerResumesFilterNoEndDate(){
        //SetUp

        //Setup expectation

        // SUT execution
        DTOIntFilterCustomerResumes resumeFilter = converter.
                toCustomerResumesFilter("(chargeDate=ge=2014-12-24)");

        //Validation
        assertNotNull(resumeFilter);
    }
}

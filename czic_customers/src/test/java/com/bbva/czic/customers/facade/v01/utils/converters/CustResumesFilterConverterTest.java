package com.bbva.czic.customers.facade.v01.utils.converters;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResumesFilter;
import com.bbva.czic.customers.facade.v01.utils.converters.impl.CustResumesFilterConverter;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import javax.annotation.Resource;

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

    /** toCardChargeFilter */
    @Test
    public void testToCardChargeFilter(){
        //SetUp

        //Setup expectation

        // SUT execution
        DTOIntAccMovementsResumesFilter resumeFilter = converter.
                toCardChargeFilter("(chargeDate=ge=2014-12-24;chargeDate=le=2015-01-10)");

        //Validation
        assertNotNull(resumeFilter);
    }

    @Test(expected = BusinessServiceException.class)
    public void testToCardChargeFilterInvalidFilterFormat(){
        //SetUp

        //Setup expectation

        // SUT execution
        DTOIntAccMovementsResumesFilter resumeFilter = converter.
                toCardChargeFilter("(chargeDate=ge=2014/12/24;chargeDate=le=2015/01/10)");
    }

    @Test(expected = BusinessServiceException.class)
    public void testToCardChargeFilterInvalidFilter(){
        //SetUp

        //Setup expectation

        // SUT execution
        DTOIntAccMovementsResumesFilter resumeFilter = converter.
                toCardChargeFilter("(chargeDate=le=2015-01-10)");
    }

    @Test
    public void testToCardChargeFilterNoEndDate(){
        //SetUp

        //Setup expectation

        // SUT execution
        DTOIntAccMovementsResumesFilter resumeFilter = converter.
                toCardChargeFilter("(chargeDate=ge=2014-12-24)");

        //Validation
        assertNotNull(resumeFilter);
    }
}

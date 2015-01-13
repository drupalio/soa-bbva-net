package com.bbva.czic.accounts.facade.v01.utils.impl;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
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

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = BusinessServiceTestContextLoader.class, locations = {
        "classpath*:/META-INF/spring/applicationContext-*.xml",
        "classpath:/META-INF/spring/business-service.xml",
        "classpath:/META-INF/spring/business-service-test.xml" })
@TestExecutionListeners(listeners = {
// MockInvocationContextTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class })
public class AccountFilterConverterTest {

    @Resource(name = "accounts-filter-converter")
    AccountFilterConverter accountFilterConverter;

    @Test(expected = BusinessServiceException.class)
    public void testThrowExceptionIfCustomerIdIsEmpty() {
        // Setup data
        final String customerId = "";
        final String filter = "(productType==TC)";

        // SUT execution
        //gpFilterConverter.getDTOIntFilter(customerId, filter);

    }

    @Test(expected = BusinessServiceException.class)
    public void testThrowExceptionIfCustomerIdIsNull() {
        // Setup data
        final String customerId = null;
        final String filter = "(productType==TC)";

        // SUT execution
        //      gpFilterConverter.getDTOIntFilter(customerId, filter);

    }

    @Test(expected = BusinessServiceException.class)
    public void testThrowExceptionIfCustomerIdIsStringNull() {
        // Setup data
        final String customerId = "null";
        final String filter = "(productType==TC)";

        // SUT execution
        //  gpFilterConverter.getDTOIntFilter(customerId, filter);

    }

    @Test
    public void testEmptyProductTypeIfFilterIsNull() {
        // Setup data
        final String customerId = "1234";
        final String filter = null;

        // SUT execution
        //     final DTOIntFilterProduct filterProduct = gpFilterConverter.getDTOIntFilter(customerId, filter);

        // Validation
        //    assertEquals(null, filterProduct.getProductType());
    }

    @Test(expected = BusinessServiceException.class)
    public void testThrowExceptionIfFilterIsMalformed() {
        // Setup data
        final String customerId = "1234";
        final String filter = "(productType=)TR";

        // SUT execution
        //   final DTOIntFilterProduct filterProduct = gpFilterConverter.getDTOIntFilter(customerId, filter);
    }

    @Test(expected = BusinessServiceException.class)
    public void testThrowExceptionIfFilterAttrDoesntExistInDTOIntFilter() {
        // Setup data
        final String customerId = "1234";
        final String filter = "(excalibur==TC)";

        // SUT execution
        //  final DTOIntFilterProduct filterProduct = gpFilterConverter.getDTOIntFilter(customerId, filter);
    }

    @Test(expected = BusinessServiceException.class)
    public void testThrowExceptionIfProductTypeDoesntExistInEnumProductType() {
        // Setup data
        final String customerId = "1234";
        final String filter = "(productType==3MO4)";

        // SUT execution
        //   final DTOIntFilterProduct filterProduct = gpFilterConverter.getDTOIntFilter(customerId, filter);
    }

    @Test
    public void testDTOIntFilterProductIfCustomerIdAndFilterWellSet() {
        // Setup data
        final String customerId = "1234";
        final String filter = "(productType==TC)";

        // SUT execution
        //   final DTOIntFilterProduct filterProduct = gpFilterConverter.getDTOIntFilter(customerId, filter);

        //Validation
        //  assertEquals(customerId, filterProduct.getIdCustomer());
        // assertEquals("TC", filterProduct.getProductType());
    }

}

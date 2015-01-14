package com.bbva.czic.accounts.facade.v01.utils.impl;


import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import javax.annotation.Resource;

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
    public void testThrowExceptionIfAccountIdIsEmpty() {
        // Setup data
        final String accountId = "";
        final String filter = "(month=ge==1994/10/11)";

        accountFilterConverter.getDTOIntFilter(accountId,filter);
    }


    @Test(expected = BusinessServiceException.class)
    public void testUriIncorrecta() {
        // Setup data
        final String accountId = "";
        final String filter = "(mes=ge==1994/10/11)";

        accountFilterConverter.getDTOIntFilter(accountId,filter);

    }

    @Test(expected = BusinessServiceException.class)
    public void testFormatosFechaIncorrectos() {
        // Setup data
        final String customerId = "1234";
        final String filter = "(mes=ge==1994/10/11)";


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
        //    assertEquals(customerId, filterProduct.getIdCustomer());
        //  assertEquals("TC", filterProduct.getProductType());
    }

}

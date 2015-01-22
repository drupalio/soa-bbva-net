package com.bbva.czic.checkbooks.facade.v01.mappers;

import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckbook;
import com.bbva.czic.checkbooks.facade.v01.mappers.impl.CheckbooksMapper;
import com.bbva.czic.dto.net.*;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * @author Entelgy Colombia.
 */
public class CheckbooksMapperTest {

    CheckbooksMapper mapper;

    @Before
    public void init() {
        mapper = new CheckbooksMapper();
    }



    @Test
    public void testMapDtoIntCheckToCheck() {
        // Setup data
        final Check check;

        final DTOIntCheck intCheck = new DTOIntCheck();

        intCheck.setId("123");
        intCheck.setIssueDate(new Date());
        intCheck.setValue(new Money(java.util.Currency.getInstance("COP"), new BigDecimal(12341234)));
        intCheck.setStatus("HABILITADO");
        intCheck.setModifiedDate(new Date());

        // SUT execution
        check = mapper.map(intCheck);

        //Validation
        assertEquals(intCheck.getId(),check.getId());
        assertEquals(intCheck.getIssueDate(),check.getIssueDate().getTime());
        assertEquals(intCheck.getValue(),check.getValue());
        assertEquals(intCheck.getStatus(),check.getStatus());
        assertEquals(intCheck.getModifiedDate(),check.getModifiedDate().getTime());
    }

}

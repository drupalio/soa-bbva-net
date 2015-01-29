package com.bbva.czic.customers.facade.v01.mappers.impl;

import com.bbva.czic.customers.business.dto.DTOIntFilterCustomerResumes;
import com.bbva.czic.customers.facade.v01.mappers.ICustomersMapper;
import com.bbva.czic.routine.commons.rm.utils.fiql.FiqlType;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaConfigurableMapper;
import com.bbva.czic.routine.mapper.converter.builtin.DateToStringConverter;
import org.springframework.stereotype.Component;

/**
 * @author Entelgy Colombia.
 */
@Component("customerMapper")
public class CustomerMapper extends AbstractBbvaConfigurableMapper implements ICustomersMapper{

    @Override
    public DTOIntFilterCustomerResumes getDTOIntMovementResumesFilter(final String customerId, final String filter) {
        final String startDate = this.getGeValue(filter, FiqlType.month.name());
        final String endDate = this.getLeValue(filter, FiqlType.month.name());

        final DTOIntFilterCustomerResumes intFilterCustomerResumes = new DTOIntFilterCustomerResumes();
        intFilterCustomerResumes.setStartDate(new DateToStringConverter());

        return intFilterCustomerResumes;
    }
}

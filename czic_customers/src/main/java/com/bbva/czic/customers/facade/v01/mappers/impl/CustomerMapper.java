package com.bbva.czic.customers.facade.v01.mappers.impl;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResumesFilter;
import com.bbva.czic.customers.facade.v01.mappers.ICustomerMapper;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.routine.commons.rm.utils.fiql.FiqlType;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaConfigurableMapper;
import com.bbva.czic.routine.mapper.MapperFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Entelgy Colombia.
 */
@Component("customerMapper")
public class CustomerMapper extends AbstractBbvaConfigurableMapper implements ICustomerMapper {

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        // map DTOIntFilterCustomerResumes <-> AccMovementsResume
        factory.classMap(DTOIntAccMovementsResume.class, AccMovementsResume.class)
                .field("income", "income")
                .field("outcome", "outcome")
                .field("balance", "balance")
                .field("month", "month")
                .byDefault().register();

    }

    @Override
    public DTOIntAccMovementsResumesFilter getDTOIntMovementResumesFilter(final String customerId, final String filter) {
        final String startDate = this.getGeValue(filter, FiqlType.month.name());
        final String endDate = this.getLeValue(filter, FiqlType.month.name());

        final DTOIntAccMovementsResumesFilter intFilterCustomerResumes = new DTOIntAccMovementsResumesFilter();

        intFilterCustomerResumes.setStartDate(startDate);
        intFilterCustomerResumes.setEndDate(endDate);

        intFilterCustomerResumes.setCustomerId(customerId);

        return intFilterCustomerResumes;
    }

    @Override
    public List<AccMovementsResume> map(List<DTOIntAccMovementsResume> accMovementsResumes) {
        return mapAsList(accMovementsResumes, AccMovementsResume.class);
    }

}

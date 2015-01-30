package com.bbva.czic.customers.facade.v01.mappers;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResumesFilter;
import com.bbva.czic.customers.business.dto.DTOIntCustomerOperation;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CustomerOperation;

import java.util.List;

/**
 * @author Entelgy Colombia.
 */
public interface ICustomerMapper {
    DTOIntAccMovementsResumesFilter getDTOIntMovementResumesFilter(String customerId, String filter);

    List<AccMovementsResume> map(List<DTOIntAccMovementsResume> accMovementsResumes);

    DTOIntCustomerOperation map(CustomerOperation operation);
}

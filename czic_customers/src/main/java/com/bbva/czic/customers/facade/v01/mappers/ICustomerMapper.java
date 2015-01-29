package com.bbva.czic.customers.facade.v01.mappers;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResumesFilter;
import com.bbva.czic.dto.net.AccMovementsResume;

import java.util.List;

/**
 * @author Entelgy Colombia.
 */
public interface ICustomerMapper {
    DTOIntAccMovementsResumesFilter getDTOIntMovementResumesFilter(String customerId, String filter);

    List<AccMovementsResume> map(List<DTOIntAccMovementsResume> accMovementsResumes);
}

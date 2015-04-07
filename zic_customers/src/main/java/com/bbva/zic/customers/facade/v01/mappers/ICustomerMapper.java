package com.bbva.zic.customers.facade.v01.mappers;

import com.bbva.zic.customers.business.dto.DTOIntCustomerFilter;
import com.bbva.zic.dto.net.AccMovementsResume;
import com.bbva.zic.dto.net.CardCharge;
import com.bbva.zic.dto.net.Customer;
import com.bbva.zic.dto.net.CustomerOperation;
import com.bbva.zic.customers.business.dto.*;

import java.util.List;

/**
 * @author Entelgy Colombia.
 */
public interface ICustomerMapper {
    DTOIntAccMovementsResumesFilter getDTOIntMovementResumesFilter(String filter);

    List<AccMovementsResume> mapAccMovementsResume(List<DTOIntAccMovementsResume> accMovementsResumes);

    List<CardCharge> mapCardCharges(List<DTOIntCardCharge> intCardCharges);

    DTOIntCardChargeFilter getCreditCardChargesFilter(String filter);

    DTOIntCustomerOperation map(CustomerOperation operation);

    Customer mapCustomer(DTOIntCustomer intCustomer);

    DTOIntCustomerFilter mapDTOIntCustomerFilter(String filter);
}

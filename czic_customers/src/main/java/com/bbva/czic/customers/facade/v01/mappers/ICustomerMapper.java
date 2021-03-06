package com.bbva.czic.customers.facade.v01.mappers;

import com.bbva.czic.customers.business.dto.*;
import com.bbva.czic.customers.business.dto.DTOIntCustomerFilter;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.Customer;
import com.bbva.czic.dto.net.CustomerOperation;

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

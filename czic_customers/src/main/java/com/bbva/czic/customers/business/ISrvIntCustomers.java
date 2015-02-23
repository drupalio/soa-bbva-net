package com.bbva.czic.customers.business;

import java.util.List;

import com.bbva.czic.customers.business.dto.*;
import com.bbva.czic.customers.business.dto.DTOIntCustomerFilter;

public interface ISrvIntCustomers {

	List<DTOIntAccMovementsResume> getListAccountsMovementsResume(DTOIntAccMovementsResumesFilter accMovementResumeFilter);

	List<DTOIntCardCharge> listCreditCharges(DTOIntCardChargeFilter cardChargeFilter);

	DTOIntCustomer getCustomer(DTOIntCustomerFilter customerFilter);

	void addChannel(final DTOIntAddChannel dtoIntAddChannel);
	
	void verifyCustomer(DTOIntCustomerOperation customerOperation);
}
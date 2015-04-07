package com.bbva.zic.customers.business;

import java.util.List;

import com.bbva.zic.customers.business.dto.DTOIntCustomerFilter;
import com.bbva.zic.customers.business.dto.*;

public interface ISrvIntCustomers {

	List<DTOIntAccMovementsResume> getListAccountsMovementsResume(DTOIntAccMovementsResumesFilter accMovementResumeFilter);

	List<DTOIntCardCharge> listCreditCharges(DTOIntCardChargeFilter cardChargeFilter);

	DTOIntCustomer getCustomer(DTOIntCustomerFilter customerFilter);

	void addChannel(final DTOIntAddChannel dtoIntAddChannel);
	
	void verifyCustomer(DTOIntCustomerOperation customerOperation);
}
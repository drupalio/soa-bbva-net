package com.bbva.czic.customers.business;

import java.util.List;

import com.bbva.czic.customers.business.dto.DTOIntAddChannel;
import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResumesFilter;
import com.bbva.czic.customers.business.dto.DTOIntCustomerOperation;
import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.czic.customers.business.dto.DTOIntCardChargeFilter;
import com.bbva.czic.dto.net.Customer;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

import java.util.List;

public interface ISrvIntCustomers {
 	

	List<DTOIntAccMovementsResume> getListAccountsMovementsResume(DTOIntAccMovementsResumesFilter accMovementResumeFilter);

	List<DTOIntCardCharge> listCreditCharges(DTOIntCardChargeFilter cardChargeFilter);

	Customer getCustomer(String customerId);

	void addChannel(final DTOIntAddChannel dtoIntAddChannel);
	
	void verifyCustomer(DTOIntCustomerOperation customerOperation);
}
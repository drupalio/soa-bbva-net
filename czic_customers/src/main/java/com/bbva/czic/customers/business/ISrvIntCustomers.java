package com.bbva.czic.customers.business;

import java.util.List;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResumesFilter;
import com.bbva.czic.customers.business.dto.DTOIntCustomerOperation;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.Customer;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public interface ISrvIntCustomers {
 	

	List<DTOIntAccMovementsResume> getListAccountsMovementsResume(DTOIntAccMovementsResumesFilter accMovementResumeFilter) throws BusinessServiceException;

	List<CardCharge> getlistCreditCharges(String customerId, DTOIntAccMovementsResumesFilter filter)
			throws BusinessServiceException;

	Customer getCustomer(String customerId) throws BusinessServiceException;


	void verifyCustomer(DTOIntCustomerOperation customerOperation);
}
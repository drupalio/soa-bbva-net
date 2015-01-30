package com.bbva.czic.customers.dao;

import java.util.List;

import com.bbva.czic.customers.business.dto.*;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public interface CustomersDAO {

	List<DTOIntAccMovementsResume> getlistAccountsMovementsResume(
			DTOIntAccMovementsResumesFilter filter) throws BusinessServiceException;

	List<DTOIntCardCharge> getlistCreCardCharges(
			DTOIntAccMovementsResumesFilter filter) throws BusinessServiceException;

	DTOIntCustomer getCustomer(String customerId)
			throws BusinessServiceException;

	void verifyCustomer(DTOIntCustomerOperation customerOperation);
}


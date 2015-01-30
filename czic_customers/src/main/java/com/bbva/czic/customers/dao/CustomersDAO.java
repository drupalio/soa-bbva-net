package com.bbva.czic.customers.dao;

import java.util.List;

import com.bbva.czic.customers.business.dto.*;
import com.bbva.czic.dto.net.Customer;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public interface CustomersDAO {

	List<DTOIntAccMovementsResume> getlistAccountsMovementsResume(
			DTOIntFilterCustomerResumes filter) throws BusinessServiceException;

	List<DTOIntCardCharge> getlistCreCardCharges(
			DTOIntFilterCustomerResumes filter) throws BusinessServiceException;

	DTOIntCustomer getCustomer(String customerId)
			throws BusinessServiceException;

	void addChannel(final DTOIntAddChannel dtoIntAddChannel);
}


package com.bbva.czic.customers.dao;

import java.util.List;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.czic.customers.business.dto.DTOIntCustomer;
import com.bbva.czic.customers.business.dto.DTOIntFilterCustomerResumes;
import com.bbva.czic.dto.net.Customer;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public interface CustomersDAO {

	List<DTOIntAccMovementsResume> getlistAccountsMovementsResume(
			DTOIntFilterCustomerResumes filter) throws BusinessServiceException;

	List<DTOIntCardCharge> getlistCreCardCharges(
			DTOIntFilterCustomerResumes filter) throws BusinessServiceException;

	DTOIntCustomer getCustomer(String customerId)
			throws BusinessServiceException;

	DTOIntCustomer addChannel(final String customerId, final String channelId);
}


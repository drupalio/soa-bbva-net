package com.bbva.czic.customers.dao;

import java.util.List;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.czic.customers.business.dto.DTOIntCustomer;
import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResumesFilter;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public interface CustomersDAO {

	public List<DTOIntAccMovementsResume> getlistAccountsMovementsResume(
			DTOIntAccMovementsResumesFilter filter) throws BusinessServiceException;

	public List<DTOIntCardCharge> getlistCreCardCharges(
			DTOIntAccMovementsResumesFilter filter) throws BusinessServiceException;

	public DTOIntCustomer getCustomer(String customerId)
			throws BusinessServiceException;

	DTOIntCustomer addChannel(final String customerId, final String channelId);
}


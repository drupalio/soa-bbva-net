package com.bbva.czic.customers.dao;

import com.bbva.czic.customers.business.dto.*;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

import java.util.List;

public interface CustomersDAO {

	public List<DTOIntAccMovementsResume> listAccountsMovementsResume(DTOIntAccMovementsResumesFilter filter);

	public List<DTOIntCardCharge> listCreditCardCharges(DTOIntCardChargeFilter cardChargeFilter);

	public DTOIntCustomer getCustomer(String customerId);

	DTOIntCustomer addChannel(final String customerId, final String channelId);
}


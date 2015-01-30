package com.bbva.czic.customers.dao;

import com.bbva.czic.customers.business.dto.*;
import java.util.List;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public interface CustomersDAO {

	List<DTOIntAccMovementsResume> listAccountsMovementsResume(DTOIntAccMovementsResumesFilter filter);

	List<DTOIntCardCharge> listCreditCardCharges(DTOIntCardChargeFilter cardChargeFilter);

	DTOIntCustomer getCustomer(String customerId);

	DTOIntCustomer addChannel(final String customerId, final String channelId);

	void verifyCustomer(DTOIntCustomerOperation customerOperation);
}


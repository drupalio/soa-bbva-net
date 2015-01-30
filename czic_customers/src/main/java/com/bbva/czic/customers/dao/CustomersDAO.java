package com.bbva.czic.customers.dao;

import com.bbva.czic.customers.business.dto.*;

import java.util.List;

public interface CustomersDAO {

	List<DTOIntAccMovementsResume> listAccountsMovementsResume(DTOIntAccMovementsResumesFilter filter);

	List<DTOIntCardCharge> listCreditCardCharges(DTOIntCardChargeFilter cardChargeFilter);

	DTOIntCustomer getCustomer(String customerId);

	void addChannel(final DTOIntAddChannel dtoIntAddChannel);

	void verifyCustomer(DTOIntCustomerOperation customerOperation);
}


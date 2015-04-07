package com.bbva.zic.customers.dao;

import com.bbva.zic.customers.business.dto.DTOIntCustomerFilter;
import com.bbva.zic.customers.business.dto.*;

import java.util.List;

public interface CustomersDAO {

	List<DTOIntAccMovementsResume> listAccountsMovementsResume(DTOIntAccMovementsResumesFilter filter);

	List<DTOIntCardCharge> listCreditCardCharges(DTOIntCardChargeFilter cardChargeFilter);

	DTOIntCustomer getCustomer(DTOIntCustomerFilter customerFilter);

	void addChannel(final DTOIntAddChannel dtoIntAddChannel);

	void verifyCustomer(DTOIntCustomerOperation customerOperation);
}


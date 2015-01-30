package com.bbva.czic.customers.business;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResumesFilter;
import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.czic.customers.business.dto.DTOIntCardChargeFilter;
import com.bbva.czic.dto.net.Customer;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

import java.util.List;

public interface ISrvIntCustomers {

	List<DTOIntAccMovementsResume> getListAccountsMovementsResume(DTOIntAccMovementsResumesFilter accMovementResumeFilter);

	List<DTOIntCardCharge> listCreditCharges(DTOIntCardChargeFilter cardChargeFilter);

	Customer getCustomer(String customerId) throws BusinessServiceException;

	Customer addChannel(final String customerId, final String channelId);

}
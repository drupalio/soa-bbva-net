package com.bbva.czic.customers.business;

import java.util.List;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public interface ISrvIntCustomers {
 	

List<AccMovementsResume> getlistAccountsMovementsResume(String idUser,
		String filter) throws BusinessServiceException;

List<CardCharge> getlistCreditCharges(String numproduct, String filter)
		throws BusinessServiceException;

	
}
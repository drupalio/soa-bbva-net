package com.bbva.czic.customers.dao;

import java.util.Date;
import java.util.List;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public interface CustomersDAO {
	

	

	List<DTOIntCardCharge> getlistCreCardCharges(String idUser, String filter);
			//throws BusinessServiceException;

	List<DTOIntAccMovementsResume> getlistAccountsMovementsResume(
			String idUser, String filter);

	

	//TODO: method signatures for DAO
	
	//public List<CreditCard> getlistCreditCardsCharges(String idUser);
}


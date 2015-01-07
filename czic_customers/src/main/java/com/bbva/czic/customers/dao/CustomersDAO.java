package com.bbva.czic.customers.dao;

import java.util.Date;
import java.util.List;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public interface CustomersDAO {
	


	public List<DTOIntAccMovementsResume> getlistAccountsMovementsResume(
			String idUser, String fechaini, String fechafin)
			throws BusinessServiceException;

	public List<DTOIntCardCharge> getlistCreCardCharges(String idUser, String fechain,
			String fechafi) throws BusinessServiceException;

	

	//TODO: method signatures for DAO
	
	//public List<CreditCard> getlistCreditCardsCharges(String idUser);
}


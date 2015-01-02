package com.bbva.czic.customers.business;

import java.util.List;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public interface ISrvIntCustomers {
 	//public List<DTOIntCreditCard> getlistCreditCardsCharges(String idUser);
  public List<AccMovementsResume> getlistAccountsMovementsResume(String idUser,
		String fechain, String fechafi) throws BusinessServiceException;

  List<CardCharge> getlistCreditCharges(String idUser, String fechain, String fechafi);

	
}
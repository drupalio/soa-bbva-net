package com.bbva.czic.customers.facade.v01;

import java.util.List;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.Customer;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;


public interface ISrvCustomersV01 {
	public List<CardCharge> listCreditCardsCharges( String customerId, String filter);

 	public List<AccMovementsResume> listAccountsMovementsResume( String customerId, String filter);

 	public Customer getCustomer(String customerId);
}
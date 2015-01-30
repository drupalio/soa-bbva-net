package com.bbva.czic.customers.facade.v01;

import java.util.List;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.Customer;

public interface ISrvCustomersV01 {

	List<CardCharge> listCreditCardsCharges( String customerId, String filter);

 	List<AccMovementsResume> listAccountsMovementsResume( String customerId, String filter);

 	Customer getCustomer(String customerId);

	void addChannel(String customerId, String channelId);
}
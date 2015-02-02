package com.bbva.czic.customers.facade.v01;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.Customer;
import com.bbva.czic.dto.net.CustomerOperation;

import javax.ws.rs.core.Response;
import java.util.List;


public interface ISrvCustomersV01 {

	List<CardCharge> listCreditCardsCharges( String customerId, String filter);

 	List<AccMovementsResume> listAccountsMovementsResume( String customerId, String filter);

 	Customer getCustomer(String customerId);

	Response addChannel(String customerId, String channelId);

	Response verifyCustomer(String channelId, CustomerOperation operation);
}
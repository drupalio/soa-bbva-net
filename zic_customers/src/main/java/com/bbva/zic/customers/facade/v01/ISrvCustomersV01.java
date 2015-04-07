package com.bbva.zic.customers.facade.v01;

import com.bbva.zic.dto.net.AccMovementsResume;
import com.bbva.zic.dto.net.CardCharge;
import com.bbva.zic.dto.net.Customer;
import com.bbva.zic.dto.net.CustomerOperation;

import javax.ws.rs.core.Response;
import java.util.List;


public interface ISrvCustomersV01 {

	List<CardCharge> listCreditCardsCharges(String filter);

 	List<AccMovementsResume> listAccountsMovementsResume(String filter);

 	Customer getCustomer(String filter);

	Response addChannel(String customerId, String chanel);

	Response verifyCustomer(String channelId, CustomerOperation operation);
}
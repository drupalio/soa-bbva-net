package com.bbva.czic.customers.facade.v01;

import java.util.List;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.Customer;
import com.bbva.czic.dto.net.CustomerOperation;
import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.apache.cxf.jaxrs.model.wadl.ElementClass;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


public interface ISrvCustomersV01 {
	public List<CardCharge> listCreditCardsCharges( String customerId, String filter);

 	public List<AccMovementsResume> listAccountsMovementsResume( String customerId, String filter);

	Response verifyCustomer(String channelId, CustomerOperation operation);

	public Customer getCustomer(String customerId);
}
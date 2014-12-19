package com.bbva.czic.cardcharge.facade.v01;

import java.util.List;
import javax.ws.rs.core.Response;

import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.Excecutive;


public interface ISrvCardChargeV01 {
 	public Response getCreditCardCharges(String filter, String fields, String expands, String orderby);

	
}
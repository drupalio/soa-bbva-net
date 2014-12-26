package com.bbva.czic.cardcharge.facade.v01;

import javax.ws.rs.core.Response;

public interface ISrvCardChargeV01 {
 	public Response getCreditCardCharges(String filter, String fields, String expands, String orderby);
	
}
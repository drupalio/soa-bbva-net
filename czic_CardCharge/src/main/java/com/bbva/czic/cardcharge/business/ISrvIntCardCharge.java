package com.bbva.czic.cardcharge.business;

import java.util.List;
import javax.ws.rs.core.Response;


import com.bbva.czic.cardcharge.business.dto.DTOIntCardCharge;
import com.bbva.czic.cardcharge.business.dto.DTOIntExcecutive;



public interface ISrvIntCardCharge {
 	public List<DTOIntCardCharge> getCreditCardCharges();

	
}
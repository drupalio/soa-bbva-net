package com.bbva.czic.cardcharge.business;

import java.util.List;


import com.bbva.czic.cardcharge.business.dto.DTOIntCardCharge;


public interface ISrvIntCardCharge {
 	public List<DTOIntCardCharge> getCreditCardCharges();

	
}
package com.bbva.czic.cards.business;

import java.util.Date;
import java.util.List;

import com.bbva.czic.cards.business.dto.DTOIntCardCharge;
import com.bbva.czic.cards.business.dto.DTOIntFilterCards;

public interface ISrvIntCards {
	public List<DTOIntCardCharge> getCreditCardCharges(DTOIntFilterCards filter);
}
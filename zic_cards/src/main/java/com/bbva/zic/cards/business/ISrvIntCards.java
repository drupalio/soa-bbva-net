package com.bbva.zic.cards.business;

import java.util.List;

import com.bbva.zic.cards.business.dto.DTOIntCardCharge;
import com.bbva.zic.cards.business.dto.DTOIntFilterCards;

public interface ISrvIntCards {
	public List<DTOIntCardCharge> getCreditCardCharges(DTOIntFilterCards filter);
}
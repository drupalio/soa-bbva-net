package com.bbva.zic.cards.dao;

import java.util.List;

import com.bbva.zic.cards.business.dto.DTOIntCardCharge;
import com.bbva.zic.cards.business.dto.DTOIntFilterCards;

public interface CardsDAO {

	public List<DTOIntCardCharge> getCreditCardCharges(DTOIntFilterCards filter);
}

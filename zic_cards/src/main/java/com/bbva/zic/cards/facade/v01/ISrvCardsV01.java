package com.bbva.zic.cards.facade.v01;

import java.util.List;

import com.bbva.zic.dto.net.CardCharge;

public interface ISrvCardsV01 {
	public List<CardCharge> getCreditCardCharges(String cardId, String filter, String fields, String expands, String sort);
}
package com.bbva.czic.cards.facade.v01;

import com.bbva.czic.dto.net.CardCharge;

import java.util.List;

public interface ISrvCardsV01 {
 	public List<CardCharge> getCreditCardCharges(String id, String filter, String fields, String expands, String orderby);
	
}
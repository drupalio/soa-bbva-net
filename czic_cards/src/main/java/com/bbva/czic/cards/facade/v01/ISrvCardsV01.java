package com.bbva.czic.cards.facade.v01;

import java.util.List;
import javax.ws.rs.core.Response;

import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.Executive;


public interface ISrvCardsV01 {
	public List<CardCharge> getCreditCardCharges(String cardId, String filter, String fields, String expands, String sort);
}
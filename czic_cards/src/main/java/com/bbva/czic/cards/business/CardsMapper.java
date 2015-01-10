package com.bbva.czic.cards.business;

import com.bbva.czic.cards.business.dto.DTOIntCardCharge;
import com.bbva.czic.dto.net.CardCharge;

public class CardsMapper {

	/**
	 * Metodo encargado de hacer el mapeo de un DTO interno de tipo
	 * DTOIntCardCharge a un DTO externo de tipo CardCharge
	 * 
	 * @author David Tafur
	 * @param dtoIntCardCharge
	 * @return
	 */
	public static CardCharge mapOuter(DTOIntCardCharge dtoIntCardCharge) {
		CardCharge cardCharge = new CardCharge();
		cardCharge.setAmount(dtoIntCardCharge.getAmount());
		cardCharge.setCategory(dtoIntCardCharge.getCategory());
		return cardCharge;
	}

}

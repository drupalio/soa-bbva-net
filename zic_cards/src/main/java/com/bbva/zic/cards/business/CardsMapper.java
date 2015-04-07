package com.bbva.zic.cards.business;

import com.bbva.zic.cards.business.dto.DTOIntCardCharge;
import com.bbva.zic.dto.net.CardCharge;
import com.bbva.zic.dto.net.EnumCardChargeCategory;

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
		cardCharge.setCategory(EnumCardChargeCategory.valueOf(dtoIntCardCharge.getCategory()));
		return cardCharge;
	}

}

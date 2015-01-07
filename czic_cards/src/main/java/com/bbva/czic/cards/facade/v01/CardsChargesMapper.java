package com.bbva.czic.cards.facade.v01;

import com.bbva.czic.cards.business.dto.DTOIntCardCharge;
import com.bbva.czic.cards.dao.model.ozno.FormatoOZECNOS0;
import com.bbva.czic.dto.net.EnumCardChargeCategory;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

public class CardsChargesMapper {

	/**
	 * Metodo encargado de mapear un objeto de salida a un DTO interno
	 * 
	 * @author David Tafur
	 * @param formato
	 * @return
	 */
	public static DTOIntCardCharge mapToOuter(FormatoOZECNOS0 formato) {
		DTOIntCardCharge dtoIntCardCharge = new DTOIntCardCharge();
		// Money
		Money money = new Money();
		money.setAmount(formato.getValcate());
		dtoIntCardCharge.setAmount(money);
		dtoIntCardCharge.setCategory(EnumCardChargeCategory.valueOf(formato
				.getCategor()));
		return dtoIntCardCharge;
	}
}

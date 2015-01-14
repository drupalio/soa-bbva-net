package com.bbva.czic.cards.facade.v01;

import com.bbva.czic.cards.business.dto.DTOIntCardCharge;
import com.bbva.czic.cards.dao.model.ozno.FormatoOZECNOS0;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import com.bbva.czic.dto.net.*;
import com.hazelcast.impl.base.SystemObjectLog;

public class CardsChargesMapper {

	private static I18nLog log = I18nLogFactory
			.getLogI18n(CardsChargesMapper.class, "META-INF/spring/i18n/log/mensajesLog");

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
		log.info("Informacion recibida de categorias: "+formato.getCategor());
		dtoIntCardCharge.setCategory(formato.getCategor());
		return dtoIntCardCharge;
	}
}

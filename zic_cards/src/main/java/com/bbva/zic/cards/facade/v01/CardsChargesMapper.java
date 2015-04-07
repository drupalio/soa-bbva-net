package com.bbva.zic.cards.facade.v01;

import com.bbva.zic.cards.business.dto.DTOIntCardCharge;
import com.bbva.zic.cards.dao.model.ozno.FormatoOZECNOS0;
import com.bbva.zic.routine.commons.rm.utils.converter.UtilsConverter;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

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
		dtoIntCardCharge.setAmount(UtilsConverter.getMoneyDTO(formato.getValcate()));
		log.info("Informacion recibida de categorias: "+formato.getCategor());
		dtoIntCardCharge.setCategory(formato
				.getCategor());
		return dtoIntCardCharge;
	}
}

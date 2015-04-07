package com.bbva.zic.cards.business.impl;

import java.util.List;

import com.bbva.zic.routine.commons.rm.utils.EDateFormat;
import com.bbva.zic.routine.commons.rm.utils.validator.DtoValidator;
import com.bbva.zic.routine.commons.rm.utils.validator.impl.DateValidator;
import com.bbva.zic.routine.commons.rm.utils.validator.impl.StringValidator;
import com.bbva.zic.cards.business.dto.DTOIntCardCharge;
import com.bbva.zic.cards.business.dto.DTOIntFilterCards;
import com.bbva.zic.cards.dao.CardsDAO;
import org.springframework.stereotype.Service;

import com.bbva.zic.cards.business.ISrvIntCards;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

import javax.annotation.Resource;

@Service
public class SrvIntCards implements ISrvIntCards {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvIntCards.class,
			"META-INF/spring/i18n/log/mensajesLog");

	@Resource(name = "cards-dao")
	CardsDAO cardsDAO;

	/**
	 * Metodo encargado de traer el listado de los cargos para una tarjeta de
	 * credito
	 * 
	 * @author David Tafur
	 */
	public List<DTOIntCardCharge> getCreditCardCharges(DTOIntFilterCards filter) {
		log.info(" Inicio de servicio interno SMC : getCreditCardCharges SN Cards ");

		DtoValidator.validate(filter);
		new StringValidator().isNumericText(filter.getProductId()).validate();
		new DateValidator().validDateRange(filter.getStartDate(), filter.getEndDate(), EDateFormat.ANIO_MES_DIA).validate();

		List<DTOIntCardCharge> result = cardsDAO.getCreditCardCharges(filter);

		DtoValidator.validate(result);

		return result;
	}
}

package com.bbva.czic.cards.business.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.validator.DtoValidator;
import org.apache.cxf.jaxrs.ext.search.ConditionType;
import org.apache.cxf.jaxrs.ext.search.PrimitiveStatement;
import org.apache.cxf.jaxrs.ext.search.SearchCondition;
import org.apache.cxf.jaxrs.ext.search.SearchParseException;
import org.apache.cxf.jaxrs.ext.search.fiql.FiqlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.cards.business.ISrvIntCards;
import com.bbva.czic.cards.business.dto.DTOIntCardCharge;
import com.bbva.czic.cards.business.dto.DTOIntFilterCards;
import com.bbva.czic.cards.dao.CardsDAO;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

@Service
public class SrvIntCards implements ISrvIntCards {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvIntCards.class,
			"META-INF/spring/i18n/log/mensajesLog");

	@Autowired
	CardsDAO cardsDAO;
	private static final String FILTERERROR = "FilterError";

	/**
	 * Metodo encargado de traer el listado de los cargos para una tarjeta de
	 * credito
	 * 
	 * @author David Tafur
	 */
	public List<DTOIntCardCharge> getCreditCardCharges(DTOIntFilterCards filter) {
		log.info(" Inicio de servicio interno SMC : getCreditCardCharges SN Cards ");

		DtoValidator.validate(filter);

		return null;
	}
}

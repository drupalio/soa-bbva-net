package com.bbva.czic.cards.business.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	BusinessServicesToolKit bussinesToolKit;
	@Autowired
	CardsDAO cardsDAO;
	private static final String FILTERERROR = "FilterError";

	/**
	 * Metodo encargado de traer el listado de los cargos para una tarjeta de
	 * credito
	 * 
	 * @author David Tafur
	 */
	public List<DTOIntCardCharge> getCreditCardCharges(String id, String filter) {
		log.info(" Inicio de servicio interno SMC : getCreditCardCharges SN Cards ");

		List<DTOIntCardCharge> initialResultList = new ArrayList<DTOIntCardCharge>();
		String startDate = "";
		String endDate = "";

		log.info(" Manejo del filter SMC : getCreditCardCharges SN Cards ");
		if (filter != null && !filter.contentEquals("null") && id != null
				&& !id.equals("")) {
			log.info("A query string (filter) has been sended: " + filter);
			SearchCondition<DTOIntFilterCards> sc;
			String property = null;
			String condition = null;
			String value = null;

			try {
				/*
				 * Manejo de la cadena del filter para sacar los valores de las
				 * propiedades
				 */
				sc = new FiqlParser<DTOIntFilterCards>(DTOIntFilterCards.class)
						.parse(filter);

				final List<PrimitiveStatement> splitDataFilter = bussinesToolKit
						.getDataFromFilter(sc);
				for (PrimitiveStatement st : splitDataFilter) {
					property = st.getProperty();
					condition = st.getCondition().toString();
					value = st.getValue().toString();

					if (property.toLowerCase().equals("chargedate")
							&& condition.equals(ConditionType.GREATER_OR_EQUALS
									.toString())) {
						startDate = value;
					} else if (property.toLowerCase().equals("chargedate")
							&& condition.equals(ConditionType.LESS_OR_EQUALS
									.toString())) {
						endDate = value;
					}
				}

				/*
				 * Se hace la comprobacion de que los dos parametros del filtros
				 * tengan valor
				 */
				if (startDate == null || endDate == null
						|| startDate.equals("") || endDate.equals("")) {
					throw new BusinessServiceException(
							"getCreditCardCharges - Los parametros del filtro son obligatorios");
				}

				/*
				 * Transformacion de fechas
				 */
				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
				Date startDateFilter = null;
				Date endDateFilter = null;
				try {
					startDateFilter = formato.parse(startDate);
					endDateFilter = formato.parse(endDate);
				} catch (ParseException ex) {
					throw new BusinessServiceException(
							"getCreditCardCharges - ParseException - error conviertiendo las fechas a Date.");
				}

				log.info(" Pasó las validaciones, se hace el llamado al DAO SMC : getCreditCardCharges SN Cards ");
				initialResultList = cardsDAO.getCreditCardCharges(id,
						startDateFilter, endDateFilter);

			} catch (SearchParseException e) {
				log.error("SearchParseException - The query string (filter) has failed: "
						+ e);
				throw new BusinessServiceException(FILTERERROR, filter,
						e.getMessage());
			}

		} else {
			throw new BusinessServiceException(
					"getCreditCardCharges - Los parametros Filter y Id son obligatorios.");
		}

		return initialResultList;
	}
}

package com.bbva.czic.cards.business.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.cxf.jaxrs.ext.search.PrimitiveStatement;
import org.apache.cxf.jaxrs.ext.search.SearchCondition;
import org.apache.cxf.jaxrs.ext.search.SearchParseException;
import org.apache.cxf.jaxrs.ext.search.fiql.FiqlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.cards.business.ISrvIntCards;
import com.bbva.czic.cards.business.dto.DTOIntCardCharge;
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
	 * @param String
	 *            id
	 * @param String
	 *            filter
	 */
	public List<DTOIntCardCharge> getCreditCardCharges(String id, String filter) {
		log.info(" getCreditCardCharges ");

		List<DTOIntCardCharge> initialResultList = new ArrayList<DTOIntCardCharge>();
		String startDate = "";
		String endDate = "";

		if (filter != null && !filter.contentEquals("null")) {
			log.info("A query string (filter) has been sended: " + filter);
			SearchCondition<DTOIntCardCharge> sc;
			String property = null;
			String condition = null;
			String value = null;

			try {
				/*
				 * Manejo de la cadena del filter para sacar los valores de las
				 * propiedades
				 */
				sc = new FiqlParser<DTOIntCardCharge>(DTOIntCardCharge.class)
						.parse(filter);

				final List<PrimitiveStatement> splitDataFilter = bussinesToolKit
						.getDataFromFilter(sc);
				for (PrimitiveStatement st : splitDataFilter) {
					property = st.getProperty();
					condition = st.getCondition().toString();
					value = st.getValue().toString();

					if (property.equals("chargeDate") && condition.equals("ge")) {
						startDate = value;
					}

					if (property.equals("chargeDate") && condition.equals("le")) {
						startDate = value;
					}
				}

				/*
				 * Transformacion de fechas
				 */
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				Date startDateFilter = null;
				Date endDateFilter = null;
				try {
					startDateFilter = formato.parse(startDate);
					endDateFilter = formato.parse(endDate);
				} catch (ParseException ex) {
					System.out.println(ex);
				}

				initialResultList = cardsDAO.getCreditCardCharges(id,
						startDateFilter, endDateFilter);

			} catch (SearchParseException e) {
				log.error("SearchParseException - The query string (filter) has failed: "
						+ e);
				throw new BusinessServiceException(FILTERERROR, filter,
						e.getMessage());
			}

		}

		return initialResultList;
	}

}

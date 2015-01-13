package com.bbva.czic.executives.business.impl;

import java.util.List;

import com.bbva.czic.executives.business.dto.DTOIntExecutivesFilter;
import org.apache.cxf.jaxrs.ext.search.PrimitiveStatement;
import org.apache.cxf.jaxrs.ext.search.SearchCondition;
import org.apache.cxf.jaxrs.ext.search.SearchParseException;
import org.apache.cxf.jaxrs.ext.search.fiql.FiqlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.dto.net.EnumThirdPartyType;
import com.bbva.czic.executives.business.ISrvIntExecutives;
import com.bbva.czic.executives.business.dto.DTOIntExecutive;
import com.bbva.czic.executives.dao.ExecutivesDAO;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

@Service
public class SrvIntExecutives implements ISrvIntExecutives {

	private static I18nLog log = I18nLogFactory.getLogI18n(
			SrvIntExecutives.class, "META-INF/spring/i18n/log/mensajesLog");
	private static final String FILTERERROR = "FilterError";

	@Autowired
	BusinessServicesToolKit bussinesToolKit;
	@Autowired
	private ExecutivesDAO executivesDAO;

	/**
	 * Metodo encargado de traer el ejecutivo
	 * 
	 * @author David Tafur
	 * @param
	 *            filter
	 */
	public DTOIntExecutive getExecutive(String filter) {
		log.info(" Inicio de servicio interno SMC : getExecutive SN Executives ");

		DTOIntExecutive initialResult = new DTOIntExecutive();
		String thirdPartyId = "";
		String thirdPartyType = "";
		log.info(" Manejo del filter SMC : getExecutive SN Executives ");
		if (filter != null && !filter.contentEquals("null")) {
			log.info("A query string (filter) has been sended: " + filter);
			SearchCondition<DTOIntExecutivesFilter> sc;
			String property = null;
			String condition = null;
			String value = null;

			try {
				/*
				 * Manejo de la cadena del filter para sacar los valores de las
				 * propiedades
				 */
				sc = new FiqlParser<DTOIntExecutivesFilter>(DTOIntExecutivesFilter.class)
						.parse(filter);

				final List<PrimitiveStatement> splitDataFilter = bussinesToolKit
						.getDataFromFilter(sc);
				for (PrimitiveStatement st : splitDataFilter) {
					property = st.getProperty();
					condition = st.getCondition().toString();
					value = st.getValue().toString();

					if (property.equals("id")) {
						thirdPartyId = value;
					}

					if (property.equals("type")) {
						thirdPartyType = value;
					}
				}

				if(thirdPartyId==null || thirdPartyId.equals("")&& thirdPartyType==null || thirdPartyType.equals("")){
					throw new BusinessServiceException("getExecutive - los parametros del filtro son obligatorios.");
				}

				log.info(" Filter:thirdPartyId: "+thirdPartyId+" SMC : getExecutive SN Executives ");
				log.info(" Filter:thirdPartyType: "+thirdPartyType+" SMC : getExecutive SN Executives ");

				if (thirdPartyType.equals(EnumThirdPartyType.CUSTOMER.toString())) {

					log.info(" Pasó las validaciones, se hace el llamado al DAO SMC : getExecutive SN Executives ");

					initialResult = executivesDAO.getExecutive(thirdPartyId);
				}

			} catch (SearchParseException e) {
				log.error("SearchParseException - The query string (filter) has failed: "
						+ e);
				throw new BusinessServiceException(FILTERERROR, filter,
						e.getMessage());
			}

		}

		return initialResult;
	}
}

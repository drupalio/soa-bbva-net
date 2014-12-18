package com.bbva.czic.globalposition.business.impl;

import java.util.List;

import com.bbva.czic.globalposition.dao.GlobalPositionDAO;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import org.apache.cxf.jaxrs.ext.search.PrimitiveStatement;
import org.apache.cxf.jaxrs.ext.search.SearchCondition;
import org.apache.cxf.jaxrs.ext.search.SearchParseException;
import org.apache.cxf.jaxrs.ext.search.fiql.FiqlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.business.ISrvIntGlobalPosition;


@Service
public class SrvIntGlobalPosition implements ISrvIntGlobalPosition {
	
	private static I18nLog log = I18nLogFactory.getLogI18n(SrvIntGlobalPosition.class,"META-INF/spring/i18n/log/mensajesLog");

	private static final String FILTERERROR = "FilterError";
	private static final String SERVICENAME = "SrvGlobalPositionV01";

	@Autowired
	BusinessServicesToolKit bussinesToolKit;

	@Autowired
	GlobalPositionDAO globalPositionDAO;

	@Override
	public List<DTOIntProduct> getExtractGlobalBalance(String customerId, String filter) {
		log.info(" getExtractGlobalBalance product ");

		List<DTOIntProduct> initialResult = globalPositionDAO.getExtractGlobalBalance(customerId);

		if (filter != null && !filter.contentEquals("null")) {
			log.info("A query string (filter) has been sended: " + filter);
			SearchCondition<DTOIntProduct> sc;

			try {
				sc = new FiqlParser<DTOIntProduct>(DTOIntProduct.class).parse(filter);

				List<PrimitiveStatement> splitDataFilter = bussinesToolKit.getDataFromFilter(sc);
				for (PrimitiveStatement st: splitDataFilter) {
					log.info("The property is: " + st.getProperty());
					log.info("The condition is: " + st.getCondition().toString());
					log.info("The value is: " + st.getValue().toString());
				}

				String pattern = bussinesToolKit.matchesPatternFromFilter(SERVICENAME, filter);
				if (pattern != null) {
					log.info("The pattern is: " + pattern);
				}
			} catch (SearchParseException e) {
				throw new BusinessServiceException(FILTERERROR, filter, e.getMessage());
			}

			List<DTOIntProduct> found = sc.findAll(initialResult);
			return found;
		}

		return initialResult;
	}

	@Override
	public void updateProductVisibility(String idProduct, DTOIntProduct infoProduct) {

	}

	@Override
	public void updateProductOperability(String idProduct, DTOIntProduct infoProduct){

	}
}

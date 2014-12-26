package com.bbva.czic.globalposition.business.impl;

import com.bbva.czic.dto.net.Product;
import com.bbva.czic.globalposition.business.ISrvIntGlobalPosition;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.dao.GlobalPositionDAO;
import com.bbva.czic.globalposition.facade.v01.mapper.Mapper;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;
import org.apache.cxf.jaxrs.ext.search.PrimitiveStatement;
import org.apache.cxf.jaxrs.ext.search.SearchCondition;
import org.apache.cxf.jaxrs.ext.search.SearchParseException;
import org.apache.cxf.jaxrs.ext.search.fiql.FiqlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SrvIntGlobalPosition implements ISrvIntGlobalPosition {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvIntGlobalPosition.class,"META-INF/spring/i18n/log/mensajesLog");

	private static final String FILTERERROR = "FilterError";

	@Autowired
	BusinessServicesToolKit bussinesToolKit;

	@Autowired
	GlobalPositionDAO globalPositionDAO;

	@Override
	public List<Product> getExtractGlobalBalance(final String customerId, final String filter) {
		log.info(" getExtractGlobalBalance product ");

		List<DTOIntProduct> initialResult = new ArrayList<DTOIntProduct>();
		initialResult = globalPositionDAO.getExtractGlobalBalance(customerId);
		if (filter != null && !filter.contentEquals("null")) {
			log.info("A query string (filter) has been sended: " + filter);
			SearchCondition<DTOIntProduct> sc;
			String property = null;
			String condition = null;
			String value = null;

			try {
				sc = new FiqlParser<DTOIntProduct>(DTOIntProduct.class).parse(filter);

				final List<PrimitiveStatement> splitDataFilter = bussinesToolKit.getDataFromFilter(sc);
				for (PrimitiveStatement st: splitDataFilter) {
					property = st.getProperty();
					condition = st.getCondition().toString();
					value = st.getValue().toString();
				}

				/*
				final String pattern = bussinesToolKit.matchesPatternFromFilter(SERVICENAME, filter);
				if (pattern != null) {
					log.info("The pattern is: " + pattern);
				}
				*/
			} catch (SearchParseException e) {
				log.error("SearchParseException - The query string (filter) has failed: " + e);
				throw new BusinessServiceException(FILTERERROR, filter, e.getMessage());
			}

			final List<DTOIntProduct> intFound = sc.findAll(initialResult);

			final List<Product> found = Mapper.productListMap(intFound);
			return found;
		}

		return Mapper.productListMap(initialResult);
	}

	@Override
	public void updateProductVisibility(final String idProduct, final Product infoProduct) {
		globalPositionDAO.updateProductVisibility(idProduct, infoProduct.getVisible());
	}

	@Override
	public void updateProductOperability(final String idProduct, final Product infoProduct){
		globalPositionDAO.updateProductVisibility(idProduct, infoProduct.getOperable());
	}
}

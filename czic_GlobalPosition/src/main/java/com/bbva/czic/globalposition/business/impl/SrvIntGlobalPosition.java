package com.bbva.czic.globalposition.business.impl;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.czic.globalposition.business.ISrvIntGlobalPosition;
import com.bbva.czic.globalposition.business.dto.DTOIntFilterProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.dao.GlobalPositionDAO;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
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

import java.util.List;


@Service
public class SrvIntGlobalPosition implements ISrvIntGlobalPosition {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvIntGlobalPosition.class,"META-INF/spring/i18n/log/mensajesLog");

	@Autowired
	BusinessServicesToolKit businessToolKit;

	@Autowired
	GlobalPositionDAO globalPositionDAO;

	@Override
	public List<DTOIntProduct> getExtractGlobalBalance(final String customerId, final String filter) {
		log.info(" getExtractGlobalBalance product ");

		final List<DTOIntProduct> initialResult;
		final DTOIntFilterProduct filterProduct = getFilterProduct(customerId, filter);

		initialResult = globalPositionDAO.getExtractGlobalBalance(filterProduct).getProducts();

		return initialResult;
	}

	@Override
	public void updateProductVisibility(DTOIntProduct productInt) {
		globalPositionDAO.updateProductVisibility(productInt);
	}

	@Override
	public void updateProductOperability(DTOIntProduct productInt){
		globalPositionDAO.updateProductVisibility(productInt);
	}

	private DTOIntFilterProduct getFilterProduct(String customerId, String filter) {

		final DTOIntFilterProduct filterProduct = new DTOIntFilterProduct();
		filterProduct.setProductType(null);

		if (filter != null && !filter.contentEquals("null")) {
			log.info("A query string (filter) has been sended: " + filter);
			SearchCondition<DTOIntProduct> sc;
			try {
				sc = new FiqlParser<DTOIntProduct>(DTOIntProduct.class).parse(filter);

				final List<PrimitiveStatement> splitDataFilter = businessToolKit.getDataFromFilter(sc);
				for (PrimitiveStatement st : splitDataFilter) {
					if (st.getProperty().equals("productType")) {
						filterProduct.setProductType(EnumProductType.valueOf(st.getValue().toString()));
					}
				}

			} catch (SearchParseException e) {
				log.error("SearchParseException - The query string (filter) has failed: " + e);
				throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias(), filter, e.getMessage());
			} catch (IllegalArgumentException e) {
				log.error("IllegalArgumentException - The product type is an invalid type - does not exist: " + e);
				throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias(), filter, e.getMessage());
			}
		}

		filterProduct.setIdCustomer(customerId);

		return filterProduct;

	}

}

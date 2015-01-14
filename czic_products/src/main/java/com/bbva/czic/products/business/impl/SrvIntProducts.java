package com.bbva.czic.products.business.impl;

import com.bbva.czic.products.business.ISrvIntProducts;
import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.dao.IProductsDAO;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class SrvIntProducts implements ISrvIntProducts {
	
	private static I18nLog log = I18nLogFactory.getLogI18n(SrvIntProducts.class,"META-INF/spring/i18n/log/mensajesLog");

	@Autowired
	BusinessServicesToolKit bussinesToolKit;

	@Resource(name = "products-dao")
	IProductsDAO productsDAO;

	@Override
	public DTOIntConditions getConditions(String productId) {
		log.info(" getConditions Conditions ");
		if(productId == null || productId.equals("null") || productId.isEmpty()) {
			log.info(" getConditions invalids parameters");
			throw new BusinessServiceException(EnumError.PARAMETER_MISSING.getAlias());
		}
		final DTOIntConditions result;

		result = productsDAO.getConditions(productId);

		return result;
	}

	

}

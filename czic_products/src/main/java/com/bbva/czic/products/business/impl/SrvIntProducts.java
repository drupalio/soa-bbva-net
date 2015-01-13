package com.bbva.czic.products.business.impl;

import com.bbva.czic.products.business.ISrvIntProducts;
import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.dao.IProductsDAO;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SrvIntProducts implements ISrvIntProducts {
	
	private static I18nLog log = I18nLogFactory.getLogI18n(SrvIntProducts.class,"META-INF/spring/i18n/log/mensajesLog");

	@Autowired
	BusinessServicesToolKit bussinesToolKit;

	@Resource(name = "products-dao")
	IProductsDAO productsDAO;

	@Override
	public DTOIntConditions getConditions(DTOIntConditions) {
		log.info(" getConditions Conditions ");

		final DTOIntConditions result;

		result = productsDAO.getConditions(DTOIntConditions);

		return result;
	}

	

}

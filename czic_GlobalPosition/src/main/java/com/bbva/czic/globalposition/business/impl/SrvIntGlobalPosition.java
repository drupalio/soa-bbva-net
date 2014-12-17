package com.bbva.czic.globalposition.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.dto.canonicaldto.Product;
import com.bbva.czic.globalposition.business.ISrvIntGlobalPosition;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.utils.OrikaMapper;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

@Service
public class SrvIntGlobalPosition implements ISrvIntGlobalPosition {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvIntGlobalPosition.class,
			"META-INF/spring/i18n/log/mensajesLog");

	@Autowired
	BusinessServicesToolKit bussinesToolKit;

	@Override
	public List<DTOIntProduct> getExtractGlobalBalance(String customerId) {

		Product product = new Product();
		product.setProductId(customerId);
		return null;
	}

	@Override
	public void update(String idProduct, DTOIntProduct infoProduct) {
		// Se hace el mapper de DTOIntProduct a Product
		Product product = (Product)new OrikaMapper().getMapperObject(infoProduct, Product.class);

	}
}

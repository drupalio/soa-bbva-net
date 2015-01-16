package com.bbva.czic.globalposition.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbva.czic.globalposition.business.ISrvIntGlobalPosition;
import com.bbva.czic.globalposition.business.dto.DTOIntFilterProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.dao.IGlobalPositionDAO;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

@Service
public class SrvIntGlobalPosition implements ISrvIntGlobalPosition {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvIntGlobalPosition.class,
			"META-INF/spring/i18n/log/mensajesLog");

	@Resource(name = "global-position-dao")
	private IGlobalPositionDAO globalPositionDAO;

	@Override
	public List<DTOIntProduct> getExtractGlobalBalance(DTOIntFilterProduct filterProduct) {
		log.info(" getExtractGlobalBalance product ");

		final List<DTOIntProduct> initialResult;

		initialResult = globalPositionDAO.getExtractGlobalBalance(filterProduct).getProducts();

		return initialResult;
	}

	@Override
	public void updateProductVisibility(DTOIntProduct productInt) {
		globalPositionDAO.updateProductVisibility(productInt);
	}

	@Override
	public void updateProductOperability(DTOIntProduct productInt) {
		globalPositionDAO.updateProductOperability(productInt);
	}

}

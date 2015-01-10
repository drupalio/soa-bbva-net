package com.bbva.czic.globalposition.business.impl;

import com.bbva.czic.globalposition.business.ISrvIntGlobalPosition;
import com.bbva.czic.globalposition.business.dto.DTOIntFilterProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.dao.GlobalPositionDAO;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class SrvIntGlobalPosition implements ISrvIntGlobalPosition {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvIntGlobalPosition.class,"META-INF/spring/i18n/log/mensajesLog");

	@Resource(name = "global-position-dao")
	GlobalPositionDAO globalPositionDAO;

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
	public void updateProductOperability(DTOIntProduct productInt){
		globalPositionDAO.updateProductVisibility(productInt);
	}

}

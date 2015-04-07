package com.bbva.zic.globalposition.business.impl;

import com.bbva.zic.globalposition.business.ISrvIntGlobalPosition;
import com.bbva.zic.globalposition.business.dto.DTOIntProductFilter;
import com.bbva.zic.globalposition.business.dto.DTOIntProduct;
import com.bbva.zic.globalposition.business.dto.DTOIntProductOperability;
import com.bbva.zic.globalposition.business.dto.DTOIntProductVisibility;
import com.bbva.zic.globalposition.dao.IGlobalPositionDAO;
import com.bbva.zic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.zic.routine.commons.rm.utils.validator.DtoValidator;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;


@Service
public class SrvIntGlobalPosition implements ISrvIntGlobalPosition {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvIntGlobalPosition.class,"META-INF/spring/i18n/log/mensajesLog");

	@Resource(name = "global-position-dao")
	IGlobalPositionDAO globalPositionDAO;

	@Override
	public List<DTOIntProduct> getExtractGlobalBalance(DTOIntProductFilter filterProduct) {
		log.info("SrvIntGlobalPosition#getExtractGlobalBalance");

		DtoValidator.validate(filterProduct);

		List<DTOIntProduct> intProducts = globalPositionDAO.getExtractGlobalBalance(filterProduct);

		//DtoValidator.validate(intProducts);

		if (CollectionUtils.isEmpty(intProducts)) {
			throw new BusinessServiceException(EnumError.NO_DATA.getAlias());
		}
		return intProducts;
	}

	@Override
	public void updateProductVisibility(DTOIntProductVisibility intProduct) {
		DtoValidator.validate(intProduct);
		globalPositionDAO.updateProductVisibility(intProduct);
	}

	@Override
	public void updateProductOperability(DTOIntProductOperability intProduct){
		DtoValidator.validate(intProduct);
		globalPositionDAO.updateProductOperability(intProduct);
	}

}

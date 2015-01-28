package com.bbva.czic.checkbooks.business.impl;

import com.bbva.czic.checkbooks.business.ISrvIntCheckbooks;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckFilter;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckbook;
import com.bbva.czic.checkbooks.dao.ICheckbooksDAO;
import com.bbva.czic.routine.commons.rm.utils.validator.DtoValidator;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SrvIntCheckbooks implements ISrvIntCheckbooks {

	private static I18nLog log = I18nLogFactory.getLogI18n(
			SrvIntCheckbooks.class, "META-INF/spring/i18n/log/mensajesLog");

	@Resource(name = "checkbooks-dao")
	private ICheckbooksDAO checkbooksDAO;

	@Override
	public DTOIntCheck getChecks(DTOIntCheckFilter dtoIntCheckFilter) {

		// 1. Validate DtoIntFilterAccount
		DtoValidator.validate(dtoIntCheckFilter);

		// 2. Get response
		final DTOIntCheck result = checkbooksDAO.getChecks(dtoIntCheckFilter);

		// 3. Validate output
		DtoValidator.validate(result);

		log.info(" getAccountMonthlyBalance monthlyBalance ");
		return result;
	}
}

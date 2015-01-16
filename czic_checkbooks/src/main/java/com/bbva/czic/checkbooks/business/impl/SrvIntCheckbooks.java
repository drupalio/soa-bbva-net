package com.bbva.czic.checkbooks.business.impl;

import com.bbva.czic.checkbooks.business.ISrvIntCheckbooks;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckbook;
import com.bbva.czic.checkbooks.dao.ICheckbooksDAO;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SrvIntCheckbooks implements ISrvIntCheckbooks {

	private static I18nLog log = I18nLogFactory.getLogI18n(
			SrvIntCheckbooks.class, "META-INF/spring/i18n/log/mensajesLog");

	@Resource(name = "checkbooks-dao")
	private ICheckbooksDAO checkbooksDAO;

	@Override
	public DTOIntCheck getChecks(DTOIntCheck intCheck) {

		return checkbooksDAO.getChecks(intCheck);
	}

	@Override
	public DTOIntCheckbook getCheckbooks(DTOIntCheckbook intCheckbook) {

		return checkbooksDAO.getCheckbooks(intCheckbook);
	}
}

package com.bbva.czic.accounts.business.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bbva.czic.accounts.business.dto.*;
import com.bbva.czic.routine.commons.rm.utils.validator.impl.DateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.accounts.business.ISrvIntAccounts;
import com.bbva.czic.accounts.dao.AccountsDAO;
import com.bbva.czic.routine.commons.rm.utils.validator.DtoValidator;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

@Service
public class SrvIntAccounts implements ISrvIntAccounts {

	private static I18nLog log = I18nLogFactory
			.getLogI18n(SrvIntAccounts.class, "META-INF/spring/i18n/log/mensajesLog");

	@Autowired
	private BusinessServicesToolKit bussinesToolKit;

	@Resource(name = "accounts-dao")
	private AccountsDAO accountsDAO;

	@Override
	public List<DTOIntMonthlyBalances> getAccountMonthlyBalance(DTOIntFilterAccount dtoIntFilterAccount) {

		// 1. Validate DtoIntFilterAccount
		DtoValidator.validate(dtoIntFilterAccount);

		// 2. Get response
		final List<DTOIntMonthlyBalances> result = accountsDAO.getAccountMonthlyBalance(dtoIntFilterAccount);

		// 3. Validate output
		DtoValidator.validate(result);

		log.info(" getExtractGlobalBalance product ");
		return result;
	}

	@Override
	public List<DTOIntAccMovementsResume> getAccMovementResume(DTOIntFilterMovResumes filter) {
		log.info(" getAccMovementResume ");

		DtoValidator.validate(filter);

		List<DTOIntAccMovementsResume> result = accountsDAO.getAccountMovementResume(filter);

		DtoValidator.validate(result);

		return result;
	}

	@Override
	public DTOIntAccount getAccount(DTOIntFilterAccount dtoIntFilterAccount) {

		DtoValidator.validate(dtoIntFilterAccount);
		log.info(" getAccount ");
		// Validar filtro

		// Mapear del filtro al dto

		// Validar el dto de filtrado
		return accountsDAO.getAccount(dtoIntFilterAccount);
	}

	@Override
	public List<DTOIntCheck> listCheck(DTOIntFilterChecks filter) {
		log.info("Into SrvIntAccounts.listCheck...");
		// Validacion del dto de filtro
		DtoValidator.validate(filter);

		List<DTOIntCheck> result = accountsDAO.getListCheck(filter);

		DtoValidator.validate(result);

		return result;
	}

	@Override
	public DTOIntCheckbook getCheckbooks(DTOIntCheckbook intCheckbook) {

		return accountsDAO.getCheckbooks(intCheckbook);
	}

}

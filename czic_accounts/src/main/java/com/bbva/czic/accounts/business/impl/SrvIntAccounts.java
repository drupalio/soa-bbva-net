package com.bbva.czic.accounts.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.accounts.business.ISrvIntAccounts;
import com.bbva.czic.accounts.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.accounts.business.dto.DTOIntAccount;
import com.bbva.czic.accounts.business.dto.DTOIntCheck;
import com.bbva.czic.accounts.business.dto.DTOIntCheckbook;
import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.czic.accounts.business.dto.DTOIntFilterChecks;
import com.bbva.czic.accounts.business.dto.DTOIntMonthlyBalances;
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
		log.info(" getExtractGlobalBalance product ");
		return accountsDAO.getAccountMonthlyBalance(dtoIntFilterAccount);
	}

	@Override
	public List<DTOIntAccMovementsResume> getAccMovementResume(DTOIntFilterAccount dtoIntFilterAccount) {
		log.info(" getAccMovementResume ");
		return accountsDAO.getAccountMovementResume(dtoIntFilterAccount);
	}

	@Override
	public DTOIntAccount getAccount(DTOIntFilterAccount dtoIntFilterAccount) {

		DtoValidator.validate(dtoIntFilterAccount);

		return accountsDAO.getAccount(dtoIntFilterAccount);
	}

	@Override
	public DTOIntCheck listCheck(DTOIntFilterChecks dtoIntFilterChecks) {
		return accountsDAO.getListCheck(dtoIntFilterChecks);
	}

	@Override
	public DTOIntCheckbook getCheckbooks(DTOIntCheckbook intCheckbook) {

		return accountsDAO.getCheckbooks(intCheckbook);
	}

}

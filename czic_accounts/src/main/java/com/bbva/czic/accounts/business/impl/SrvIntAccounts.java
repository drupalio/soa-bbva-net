package com.bbva.czic.accounts.business.impl;

import com.bbva.czic.accounts.business.ISrvIntAccounts;
import com.bbva.czic.accounts.business.dto.*;
import com.bbva.czic.accounts.dao.AccountsDAO;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SrvIntAccounts implements ISrvIntAccounts {

	private static I18nLog log = I18nLogFactory
			.getLogI18n(SrvIntAccounts.class, "META-INF/spring/i18n/log/mensajesLog");

	@Autowired
	BusinessServicesToolKit bussinesToolKit;
	@Resource(name = "accounts-dao")
	AccountsDAO accountsDAO;


	@Override
	public List<DTOIntMonthlyBalances> getAccountMonthlyBalance(DTOIntFilterAccount dtoIntFilterAccount) {
		log.info(" getExtractGlobalBalance product ");

		final List<DTOIntMonthlyBalances> initialResult;

		initialResult = accountsDAO.getAccountMonthlyBalance(dtoIntFilterAccount).getListDTOIntMonthlyBalances();

		return initialResult;
	}

	@Override
	public List<DTOIntAccMovementsResume> getAccMovementResume(DTOIntFilterAccount dtoIntFilterAccount) {
		log.info(" getAccMovementResume ");
		return accountsDAO.getAccountMovementResume(dtoIntFilterAccount).getListDTOIntAccMovementsResume();
	}

	@Override
	public DTOIntAccount getAccount(DTOIntFilterAccount dtoIntFilterAccount) {
		log.info(" getAccount ");
		return accountsDAO.getAccount(dtoIntFilterAccount);
	}

	@Override
	public DTOIntCheck listCheck(DTOIntFilterChecks dtoIntFilterChecks) {
		return accountsDAO.getListCheck(dtoIntFilterChecks);
	}

}

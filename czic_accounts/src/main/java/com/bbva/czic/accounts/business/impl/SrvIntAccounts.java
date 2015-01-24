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
import com.bbva.czic.accounts.facade.v01.utils.IListCheckFilterConverter;
import com.bbva.czic.routine.commons.rm.utils.validator.DtoValidator;
import com.bbva.czic.routine.commons.rm.utils.validator.impl.FiqlValidator;
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

	@Resource(name = "listCheck-filter-converter")
	private IListCheckFilterConverter listCheckFilterConverter;

	@Override
	public List<DTOIntMonthlyBalances> getAccountMonthlyBalance(final DTOIntFilterAccount dtoIntFilterAccount) {

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
	public List<DTOIntAccMovementsResume> getAccMovementResume(final DTOIntFilterAccount dtoIntFilterAccount) {
		log.info(" getAccMovementResume ");
		return accountsDAO.getAccountMovementResume(dtoIntFilterAccount);
	}

	@Override
	public DTOIntAccount getAccount(final DTOIntFilterAccount dtoIntFilterAccount) {

		DtoValidator.validate(dtoIntFilterAccount);
		log.info(" getAccount ");
		// Validar filtro

		// Mapear del filtro al dto

		// Validar el dto de filtrado
		return accountsDAO.getAccount(dtoIntFilterAccount);
	}

	@Override
	public List<DTOIntCheck> listCheck(String accountId, String filter, Integer paginationKey, Integer pageSize) {
		log.info("Into SrvIntAccounts.listCheck...");
		// Validacion del filtro
		FiqlValidator fiqlValidator = (FiqlValidator)new FiqlValidator(filter).exist()
				.hasGeAndLeDate("check.issueDate").hasEq("check.status").validate();

		// Mapeo del filtro a DTO
		DTOIntFilterChecks dtoIntFilterChecks = listCheckFilterConverter.getDTOIntFilter(accountId, filter,
				paginationKey, pageSize);

		// Validacion del dto de filtro
		DtoValidator.validate(dtoIntFilterChecks);

		return accountsDAO.getListCheck(dtoIntFilterChecks);
	}

	@Override
	public DTOIntCheckbook getCheckbooks(DTOIntCheckbook intCheckbook) {

		return accountsDAO.getCheckbooks(intCheckbook);
	}

}

package com.bbva.czic.accounts.dao.impl;

import com.bbva.czic.accounts.business.dto.*;
import com.bbva.czic.accounts.dao.AccountsDAO;
import com.bbva.czic.routine.commons.rm.utils.tx.IPaginatedTransaction;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository(value = "accounts-dao")
public class AccountsDAOImpl implements AccountsDAO {

	@Autowired
	private ErrorMappingHelper errorMappingHelper;


	@Autowired
	@Qualifier("tx-get-account-monthly-balance")
	private IPaginatedTransaction txtGetAccountMonthlyBalance;

	@Autowired
	@Qualifier("tx-get-account-movement-resume")
	private IPaginatedTransaction txtGetAccountMovementResume;

	@Autowired
	@Qualifier("tx-lis-check")
	private IPaginatedTransaction txListCheck;

	@Autowired
	@Qualifier("tx-get-account")
	private ISimpleTransaction txtGetAccount;


	@Override
	public DTOIntResponseMonthlyBalances getAccountMonthlyBalance(final DTOIntFilterAccount dtoIntFilterAccount) {

		final DTOIntResponseMonthlyBalances dtoIntResponseMonthlyBalances = txtGetAccountMonthlyBalance.invoke(dtoIntFilterAccount);
		return dtoIntResponseMonthlyBalances;
	}

	@Override
	public DTOIntResponseAccMovementsResumes getAccountMovementResume(final DTOIntFilterAccount dtoIntFilterAccount) {

		final DTOIntResponseAccMovementsResumes dtoIntResponseAccMovementsResumes = txtGetAccountMovementResume.invoke(dtoIntFilterAccount);
		return dtoIntResponseAccMovementsResumes;
	}

	@Override
	public DTOIntAccount getAccount(final DTOIntFilterAccount dtoIntFilterAccount) {
		return txtGetAccount.invoke(dtoIntFilterAccount);
	}

	@Override
	public DTOIntCheck getListCheck(DTOIntCheck dtoIntCheck) {
		return null;
	}


}

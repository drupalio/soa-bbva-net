package com.bbva.czic.accounts.dao.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bbva.czic.accounts.business.dto.DTOIntAccount;
import com.bbva.czic.accounts.business.dto.DTOIntCheck;
import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.czic.accounts.business.dto.DTOIntResponseAccMovementsResumes;
import com.bbva.czic.accounts.business.dto.DTOIntResponseMonthlyBalances;
import com.bbva.czic.accounts.dao.AccountsDAO;
import com.bbva.czic.accounts.dao.tx.impl.TxGetAccountImpl;
import com.bbva.czic.accounts.dao.tx.impl.TxGetAccountMonthlyBalanceImpl;
import com.bbva.czic.accounts.dao.tx.impl.TxGetAccountMovementResumeImpl;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;

@Repository(value = "accounts-dao")
public class AccountsDAOImpl implements AccountsDAO {

	@Autowired
	private ErrorMappingHelper errorMappingHelper;

	// @Autowired
	// @Qualifier("tx-list-check")
	// private IPaginatedTransaction txListCheck;

	@Resource(name = "tx-get-account")
	private TxGetAccountImpl txtGetAccount;

	@Resource(name = "tx-get-account-monthly-balance")
	private TxGetAccountMonthlyBalanceImpl txGetAccountMonthlyBalance;

	@Resource(name = "tx-get-account-movement-resume")
	private TxGetAccountMovementResumeImpl txGetAccountMovementResume;

	@Override
	public DTOIntResponseMonthlyBalances getAccountMonthlyBalance(final DTOIntFilterAccount dtoIntFilterAccount) {

		return txGetAccountMonthlyBalance.invoke(dtoIntFilterAccount);
	}

	@Override
	public DTOIntResponseAccMovementsResumes getAccountMovementResume(final DTOIntFilterAccount dtoIntFilterAccount) {

		return txGetAccountMovementResume.invoke(dtoIntFilterAccount);
	}

	@Override
	public DTOIntAccount getAccount(final DTOIntFilterAccount dtoIntFilterAccount) {
		return txtGetAccount.invoke(dtoIntFilterAccount);
	}

	@Override
	public DTOIntCheck getListCheck(DTOIntFilterChecks dtoIntFilterChecks) {
		final DTOIntResponseListCheck dtoIntResponseListCheck = txListCheck.invoke(dtoIntFilterChecks);
		return dtoIntResponseListCheck;
	}

}

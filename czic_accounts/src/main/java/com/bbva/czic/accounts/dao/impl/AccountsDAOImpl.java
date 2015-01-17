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

	// @Resource(name = "tx-lis-check")
	// private IPaginatedTransaction txListCheck;

	@Resource(name = "tx-get-account")
	private TxGetAccountImpl txGetAccount;

	@Resource(name = "tx-get-account-monthly-balance")
	private TxGetAccountMonthlyBalanceImpl txGetAccountMonthlyBalance;

	@Resource(name = "tx-get-account-movement-resume")
	private TxGetAccountMovementResumeImpl txGetAccountMovementResume;

	// hecho
	@Override
	public DTOIntAccount getAccount(final DTOIntFilterAccount dtoIntFilterAccount) {
		return txGetAccount.invoke(dtoIntFilterAccount);
	}

	@Override
	public DTOIntCheck getListCheck(DTOIntCheck dtoIntCheck) {
		// return txListCheck.invoke(dtoIntCheck);
		return null;

	}

	@Override
	public DTOIntResponseMonthlyBalances getAccountMonthlyBalance(DTOIntFilterAccount dtoIntFilterAccount) {
		// TODO Auto-generated method stub
		return txGetAccountMonthlyBalance.invoke(dtoIntFilterAccount);
	}

	@Override
	public DTOIntResponseAccMovementsResumes getAccountMovementResume(DTOIntFilterAccount dtoIntFilterAccount) {
		// TODO Auto-generated method stub
		return txGetAccountMovementResume.invoke(dtoIntFilterAccount);
	}

}

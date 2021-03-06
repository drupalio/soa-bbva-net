package com.bbva.czic.accounts.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bbva.czic.accounts.business.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.czic.accounts.dao.AccountsDAO;
import com.bbva.czic.accounts.dao.tx.TxGetAccount;
import com.bbva.czic.accounts.dao.tx.TxGetAccountMonthlyBalance;
import com.bbva.czic.accounts.dao.tx.TxGetAccountMovementResume;
import com.bbva.czic.accounts.dao.tx.TxGetCheck;
import com.bbva.czic.accounts.dao.tx.TxGetCheckbook;
import com.bbva.czic.accounts.dao.tx.TxListChecks;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;


@Component(value = "accounts-dao")
public class AccountsDAOImpl implements AccountsDAO {

	@Autowired
	private ErrorMappingHelper errorMappingHelper;

	/**
	 * OZNA
	 */
	@Resource(name = "tx-get-account")
	private TxGetAccount txtGetAccount;

	/**
	 * OZNV
	 */
	@Resource(name = "tx-get-account-monthly-balance")
	private TxGetAccountMonthlyBalance txGetAccountMonthlyBalance;

	/**
	 * OZNU
	 */
	@Resource(name = "tx-get-account-movement-resume")
	private TxGetAccountMovementResume txGetAccountMovementResume;

	@Resource(name = "tx-list-Check-mapperc")
	private TxListChecks txListCheck;

	@Resource(name = "tx-get-checkbook")
	private TxGetCheckbook txGetCheckbook;


	@Resource(name = "tx-get-check")
	private TxGetCheck txGetCheck;

	@Override
	public DTOIntCheck getChecks(DTOIntCheckFilter dtoIntCheckFilter) {
		return txGetCheck.invoke(dtoIntCheckFilter);
	}

	@Override
	public List<DTOIntMonthlyBalances> getAccountMonthlyBalance(final DTOIntFilterAccount dtoIntFilterAccount) {
		return txGetAccountMonthlyBalance.invoke(dtoIntFilterAccount);
	}

	@Override
	public List<DTOIntAccMovementsResume> getAccountMovementResume(final DTOIntFilterMovResumes dtoIntFilter) {
		return txGetAccountMovementResume.invoke(dtoIntFilter);
	}

	@Override
	public DTOIntAccount getAccount(final DTOIntFilterAccount dtoIntFilterAccount) {
		return txtGetAccount.invoke(dtoIntFilterAccount);
	}

	@Override
	public List<DTOIntCheck> getListCheck(DTOIntFilterChecks dtoIntFilterChecks) {
		return txListCheck.invoke(dtoIntFilterChecks);
	}

	@Override
	public DTOIntCheckbook getCheckbook(DTOIntFilterCheckbooks intCheckbook) {
		return txGetCheckbook.invoke(intCheckbook);
	}
}

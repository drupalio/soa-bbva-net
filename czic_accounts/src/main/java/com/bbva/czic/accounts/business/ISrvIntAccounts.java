package com.bbva.czic.accounts.business;

import com.bbva.czic.accounts.business.dto.*;

import java.util.List;

public interface ISrvIntAccounts<Account> {

	public List<DTOIntMonthlyBalances> getAccountMonthlyBalance(DTOIntFilterAccount dtoIntFilterAccount) ;

	public List<DTOIntAccMovementsResume> getAccMovementResume(DTOIntFilterAccount dtoIntFilterAccount);

	public DTOIntAccount getAccount(DTOIntFilterAccount dtoIntFilterAccount) ;

	/**
	 * Created by Entelgy on 12/01/2015.
	 * Metodo incluido manualmente para completar el total de los SMC - listCheck
	 */

	public DTOIntCheck listCheck(DTOIntFilterChecks dtoIntFilterChecks) ;

}
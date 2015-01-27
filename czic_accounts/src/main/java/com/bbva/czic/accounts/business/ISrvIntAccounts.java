package com.bbva.czic.accounts.business;

import java.util.List;

import com.bbva.czic.accounts.business.dto.*;

/**
 * @author Entelgy
 */
public interface ISrvIntAccounts {

	/**
	 * @param dtoIntFilterAccount
	 * @return
	 */
	public List<DTOIntMonthlyBalances> getAccountMonthlyBalance(DTOIntFilterAccount dtoIntFilterAccount);


	public List<DTOIntAccMovementsResume> getAccMovementResume(DTOIntFilterMovResumes filter);

	/**
	 * @param dtoIntFilterAccount
	 * @return
	 */
	public DTOIntAccount getAccount(DTOIntFilterAccount dtoIntFilterAccount);

	/**
	 * Created by Entelgy on 12/01/2015. Metodo incluido manualmente para completar el total de los SMC - listCheck
	 */
	public List<DTOIntCheck> listCheck(DTOIntFilterChecks filter);


	public DTOIntCheckbook getCheckbooks(DTOIntCheckbook intCheckbook);

}
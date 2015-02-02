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
	List<DTOIntMonthlyBalances> getAccountMonthlyBalance(DTOIntFilterAccount dtoIntFilterAccount);


	List<DTOIntAccMovementsResume> getAccMovementResume(DTOIntFilterMovResumes filter);

	/**
	 * @param dtoIntFilterAccount
	 * @return
	 */
	DTOIntAccount getAccount(DTOIntFilterAccount dtoIntFilterAccount);

	/**
	 * Created by Entelgy on 12/01/2015. Metodo incluido manualmente para completar el total de los SMC - listCheck
	 */
	List<DTOIntCheck> listCheck(DTOIntFilterChecks filter);


	DTOIntCheckbook getCheckbooks(DTOIntCheckbook intCheckbook);

	DTOIntCheck getChecks(DTOIntCheckFilter dtoIntCheckFilter);

}
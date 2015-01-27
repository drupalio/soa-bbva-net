package com.bbva.czic.accounts.dao;

import java.util.List;

import com.bbva.czic.accounts.business.dto.*;

/**
 * @author Entelgy
 */
public interface AccountsDAO {

	/**
	 * @param dtoIntFilterAccount
	 * @return
	 */
	List<DTOIntMonthlyBalances> getAccountMonthlyBalance(final DTOIntFilterAccount dtoIntFilterAccount);

	/**
	 * @param 
	 * @return
	 */
	List<DTOIntAccMovementsResume> getAccountMovementResume(final DTOIntFilterMovResumes dtoIntFilter);

	/**
	 * @param dtoIntFilterAccount
	 * @return
	 */
	DTOIntAccount getAccount(final DTOIntFilterAccount dtoIntFilterAccount);

	/**
	 * @param dtoIntFilterChecks
	 * @return
	 */
	List<DTOIntCheck> getListCheck(DTOIntFilterChecks dtoIntFilterChecks);

	/**
	 * @param intCheckbook
	 * @return
	 */
	DTOIntCheckbook getCheckbooks(DTOIntCheckbook intCheckbook);

}

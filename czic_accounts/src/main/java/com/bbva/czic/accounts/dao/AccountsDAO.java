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
	 * @param dtoIntFilterAccount
	 * @return
	 */
	List<DTOIntAccMovementsResume> getAccountMovementResume(final DTOIntFilterAccount dtoIntFilterAccount);

	/**
	 * @param dtoIntFilterAccount
	 * @return
	 */
	DTOIntAccount getAccount(final DTOIntFilterAccount dtoIntFilterAccount);

	/**
	 * @param dtoIntFilterChecks
	 * @return
	 */
	DTOIntCheck getListCheck(DTOIntFilterChecks dtoIntFilterChecks);
	DTOIntCheckbook getCheckbooks(DTOIntCheckbook intCheckbook);



}

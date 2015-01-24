package com.bbva.czic.accounts.dao;

import java.util.List;

import com.bbva.czic.accounts.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.accounts.business.dto.DTOIntAccount;
import com.bbva.czic.accounts.business.dto.DTOIntCheck;
import com.bbva.czic.accounts.business.dto.DTOIntCheckbook;
import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.czic.accounts.business.dto.DTOIntFilterChecks;
import com.bbva.czic.accounts.business.dto.DTOIntMonthlyBalances;

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
	List<DTOIntCheck> getListCheck(DTOIntFilterChecks dtoIntFilterChecks);

	/**
	 * @param intCheckbook
	 * @return
	 */
	DTOIntCheckbook getCheckbooks(DTOIntCheckbook intCheckbook);

}

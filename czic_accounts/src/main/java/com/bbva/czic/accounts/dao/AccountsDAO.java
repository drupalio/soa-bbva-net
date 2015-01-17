package com.bbva.czic.accounts.dao;

import com.bbva.czic.accounts.business.dto.DTOIntAccount;
import com.bbva.czic.accounts.business.dto.DTOIntCheck;
import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.czic.accounts.business.dto.DTOIntResponseAccMovementsResumes;
import com.bbva.czic.accounts.business.dto.DTOIntResponseMonthlyBalances;

public interface AccountsDAO {

	DTOIntResponseMonthlyBalances getAccountMonthlyBalance(final DTOIntFilterAccount dtoIntFilterAccount);

	DTOIntResponseAccMovementsResumes getAccountMovementResume(final DTOIntFilterAccount dtoIntFilterAccount);

	DTOIntAccount getAccount(final DTOIntFilterAccount dtoIntFilterAccount);

	DTOIntCheck getListCheck(DTOIntFilterChecks dtoIntFilterChecks);

}

package com.bbva.czic.accounts.dao;

import com.bbva.czic.accounts.business.dto.*;

public interface AccountsDAO {

	DTOIntResponseMonthlyBalances getAccountMonthlyBalance(final DTOIntFilterAccount dtoIntFilterAccount);

	DTOIntResponseAccMovementsResumes getAccountMovementResume(final DTOIntFilterAccount dtoIntFilterAccount);

	DTOIntAccount getAccount(final DTOIntFilterAccount dtoIntFilterAccount);

	DTOIntCheck getListCheck(DTOIntFilterChecks dtoIntFilterChecks);

}

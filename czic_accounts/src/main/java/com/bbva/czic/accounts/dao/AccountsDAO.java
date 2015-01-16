package com.bbva.czic.accounts.dao;

import com.bbva.czic.accounts.business.dto.*;

public interface AccountsDAO {


	public DTOIntResponseMonthlyBalances getAccountMonthlyBalance(final DTOIntFilterAccount dtoIntFilterAccount);

	public DTOIntResponseAccMovementsResumes getAccountMovementResume(final DTOIntFilterAccount dtoIntFilterAccount);

	public DTOIntAccount getAccount(final DTOIntFilterAccount dtoIntFilterAccount);

	DTOIntCheck getListCheck(DTOIntCheck dtoIntCheck);


}

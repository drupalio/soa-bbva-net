package com.bbva.czic.accounts.dao;

import com.bbva.czic.accounts.business.dto.*;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

import java.util.List;

public interface AccountsDAO {


	public DTOIntResponseMonthlyBalances getAccountMonthlyBalance(final DTOIntFilterAccount dtoIntFilterAccount);

	public DTOIntResponseAccMovementsResumes getAccountMovementResume(final DTOIntFilterAccount dtoIntFilterAccount);

	public DTOIntAccount getAccount(final DTOIntFilterAccount dtoIntFilterAccount);
}

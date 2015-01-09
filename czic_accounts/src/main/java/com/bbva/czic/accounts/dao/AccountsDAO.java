package com.bbva.czic.accounts.dao;

import java.util.Date;

import com.bbva.czic.accounts.business.dto.DTOIntAccount;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public interface AccountsDAO {

	public DTOIntAccount getAccount(String accountId)
			throws BusinessServiceException;

	public DTOIntAccount getAccountMonthlyBalance(String id, Date startMonth,
			Date endMonth) throws BusinessServiceException;

	DTOIntAccount getAccMovementResume(String id, Date startMonth, Date endMonth)
			throws BusinessServiceException;

}

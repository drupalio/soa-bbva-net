package com.bbva.czic.accounts.dao;

import java.util.Date;
import java.util.List;

import com.bbva.czic.accounts.business.dto.DTOIntAccount;
import com.bbva.czic.accounts.business.dto.DTOIntMovement;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public interface AccountsDAO {

	public List<DTOIntMovement> listMovements(String accountId, String starDate, String endDate,
			String bottomValue, String topValue, String paginationKey, String pageSize
			) throws BusinessServiceException;

	public DTOIntMovement getAccount(String accountId
			) throws BusinessServiceException;

	public DTOIntMovement getMovement(String movementId, String accountId
			) throws BusinessServiceException;
	
	public List<DTOIntAccount> listAccounts ( String id, Date startMonth,
			Date endMonth
			) throws BusinessServiceException;

	public DTOIntAccount getAccountMonthlyBalance(String id, Date startMonth,
			Date endMonth) throws BusinessServiceException;

	DTOIntAccount getAccMovementResume(String id, Date startMonth, Date endMonth)
			throws BusinessServiceException;


}

package com.bbva.czic.loan.business;

import java.util.Date;
import java.util.List;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public interface ISrvIntLoan {

	public Loan getRotaryQuota(String idRotaryQuota);

	public List<Movement> listRotaryQuotaMovements(Date starDate, Date endDate, String paginationKey, Integer pageSize,
			String idLoan);

	public Movement getRotaryQuotaMovement(String idMovement, String idLoan) throws BusinessServiceException;
}
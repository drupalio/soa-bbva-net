package com.bbva.czic.loan.business;

import java.util.List;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public interface ISrvIntLoan {

	public Loan getRotaryQuota(String idRotaryQuota);

	public List<Movement> listRotaryQuotaMovements(String idLoan, String filter, String fields, String expands,
			String sort);

	public Movement getRotaryQuotaMovement(String idMovement, String idLoan) throws BusinessServiceException;
}
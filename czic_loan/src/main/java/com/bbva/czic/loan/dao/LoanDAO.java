package com.bbva.czic.loan.dao;

import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public interface LoanDAO {

	public DTOIntLoan getRotaryQuota(String idLoan)
			throws BusinessServiceException;

}

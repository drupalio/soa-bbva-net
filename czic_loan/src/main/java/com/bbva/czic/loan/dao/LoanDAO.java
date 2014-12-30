package com.bbva.czic.loan.dao;

import java.util.List;

import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public interface LoanDAO {

	public List<DTOIntMovement> listRotaryQuotaMovements(String starDate, String endDate, String paginationKey,
			Integer pageSize, String idLoan) throws BusinessServiceException;

	public DTOIntLoan getRotaryQuota(String idLoan) throws BusinessServiceException;

	public DTOIntMovement getRotaryQuotaMovement(String idMovement, String idLoan) throws BusinessServiceException;

}

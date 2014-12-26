package com.bbva.czic.loan.dao;

import java.util.Date;
import java.util.List;

import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public interface LoanDAO {

	public List<DTOIntLoan> listRotaryQuotaMovements(Date starDate, Date endDate, String paginationKey,
			Integer pageSize, String idLoan) throws BusinessServiceException;

	public DTOIntLoan getRotaryQuota(String idLoan) throws BusinessServiceException;

}

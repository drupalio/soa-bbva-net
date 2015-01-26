package com.bbva.czic.loan.dao;


import com.bbva.czic.loan.business.dto.DTOIntFilterLoan;
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.czic.loan.business.dto.DTOIntRotaryQuotaMove;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

import java.util.List;

public interface LoanDAO {

	List<DTOIntMovement> listRotaryQuotaMovements(final DTOIntFilterLoan dtoIntFilterLoan) throws BusinessServiceException;

	DTOIntLoan getRotaryQuota(final String idLoan)	throws BusinessServiceException;

	DTOIntRotaryQuotaMove getRotaryQuotaMovement(final Integer idMovement, final String idLoan) throws BusinessServiceException;

}

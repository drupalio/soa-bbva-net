package com.bbva.czic.loan.dao;

import com.bbva.czic.dto.net.RotaryQuotaMove;
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.czic.loan.business.dto.DTOIntRotaryQuotaMove;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

import java.util.Date;
import java.util.List;

public interface LoanDAO {

	List<DTOIntMovement> listRotaryQuotaMovements(final String idLoan, final String paginationKey, final String pageSize, final Date fechaInicial, final Date fechaFinal) throws BusinessServiceException;

	DTOIntLoan getRotaryQuota(final String idLoan)	throws BusinessServiceException;

	DTOIntRotaryQuotaMove getRotaryQuotaMovement(final Integer idMovement, final String idLoan) throws BusinessServiceException;

}

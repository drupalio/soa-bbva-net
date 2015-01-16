package com.bbva.czic.loan.dao;

import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

import java.util.Date;
import java.util.List;

public interface LoanDAO {

	List<DTOIntMovement> listRotaryQuotaMovements(String idLoan, String paginationKey, String pageSize, String fechaInicial, String fechaFinal) throws BusinessServiceException;

	DTOIntLoan getRotaryQuota(String idLoan)	throws BusinessServiceException;

	DTOIntMovement getRotaryQuotaMovement(String idMovement, String idLoan) throws BusinessServiceException;

}

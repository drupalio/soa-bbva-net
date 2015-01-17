package com.bbva.czic.loan.dao;

import com.bbva.czic.dto.net.RotaryQuotaMove;
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.czic.loan.business.dto.DTOIntRotaryQuotaMove;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

import java.util.Date;
import java.util.List;

public interface LoanDAO {

	List<DTOIntMovement> listRotaryQuotaMovements(String idLoan, String paginationKey, String pageSize, String fechaInicial, String fechaFinal) throws BusinessServiceException;

	DTOIntLoan getRotaryQuota(String idLoan)	throws BusinessServiceException;

	DTOIntRotaryQuotaMove getRotaryQuotaMovement(String idMovement, String idLoan) throws BusinessServiceException;

}

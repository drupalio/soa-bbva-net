package com.bbva.czic.loan.business;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.dto.net.RotaryQuotaMove;
import com.bbva.czic.loan.business.dto.DTOIntFilterLoan;
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.czic.loan.business.dto.DTOIntRotaryQuotaMove;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

import java.util.Date;
import java.util.List;

public interface ISrvIntLoan {

	DTOIntLoan getRotaryQuota(final DTOIntFilterLoan dtoIntFilterLoan);

	List<DTOIntMovement> listRotaryQuotaMovements(final DTOIntFilterLoan dtoIntFilterLoan);

	DTOIntRotaryQuotaMove getRotaryQuotaMovement(final DTOIntFilterLoan dtoIntFilterLoan) throws BusinessServiceException;


}
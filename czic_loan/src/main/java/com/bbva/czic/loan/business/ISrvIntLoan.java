package com.bbva.czic.loan.business;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.dto.net.RotaryQuotaMove;
import com.bbva.czic.loan.business.dto.DTOIntFilterLoan;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

import java.util.Date;
import java.util.List;

public interface ISrvIntLoan {

	Loan getRotaryQuota(String idRotaryQuota);

	List<Movement> listRotaryQuotaMovements(DTOIntFilterLoan dtoIntFilterLoan);

	RotaryQuotaMove getRotaryQuotaMovement(String idMovement, String idLoan) throws BusinessServiceException;


}
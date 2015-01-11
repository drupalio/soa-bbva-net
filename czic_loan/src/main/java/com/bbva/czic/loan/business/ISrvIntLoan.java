package com.bbva.czic.loan.business;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public interface ISrvIntLoan {

	Loan getRotaryQuota(String idRotaryQuota);

}
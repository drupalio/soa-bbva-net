package com.bbva.czic.loan.business;

import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public interface ISrvIntLoan {

	public DTOIntLoan getRotaryQuota(String idRotaryQuota);

}
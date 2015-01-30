package com.bbva.czic.loan.business;

import com.bbva.czic.loan.business.dto.*;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

import java.util.List;

public interface ISrvIntLoan {

	DTOIntLoan getRotaryQuota(final String idLoan);

	List<DTOIntMovement> listRotaryQuotaMovements(final DTOIntFilterLoan dtoIntFilterLoan);

	DTOIntRotaryQuotaMove getRotaryQuotaMovement(final DTOIntFilterRotaryMovement dtoIntFilterRotaryMovement) throws BusinessServiceException;


}
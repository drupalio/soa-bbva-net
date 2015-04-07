package com.bbva.zic.loan.business;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.zic.loan.business.dto.*;

import java.util.List;

public interface ISrvIntLoan {

	DTOIntLoan getRotaryQuota(final String idLoan);

	List<DTOIntMovement> listRotaryQuotaMovements(final DTOIntFilterLoan dtoIntFilterLoan);

	DTOIntRotaryQuotaMove getRotaryQuotaMovement(final DTOIntFilterRotaryMovement dtoIntFilterRotaryMovement) throws BusinessServiceException;


}
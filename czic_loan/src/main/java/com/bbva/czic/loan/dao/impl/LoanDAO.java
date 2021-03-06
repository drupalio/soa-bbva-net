package com.bbva.czic.loan.dao.impl;


import com.bbva.czic.loan.business.dto.*;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

import java.util.List;


public interface LoanDAO {

	List<DTOIntMovement> listRotaryQuotaMovements(final DTOIntFilterLoan dtoIntFilterLoan);

	DTOIntLoan getRotaryQuota(final String idLoan);

	DTOIntRotaryQuotaMove getRotaryQuotaMovement(final DTOIntFilterRotaryMovement dtoIntFilterRotaryMovement);

}

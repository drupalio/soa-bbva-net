package com.bbva.zic.loan.dao.impl;


import com.bbva.zic.loan.business.dto.*;

import java.util.List;


public interface LoanDAO {

	List<DTOIntMovement> listRotaryQuotaMovements(final DTOIntFilterLoan dtoIntFilterLoan);

	DTOIntLoan getRotaryQuota(final String idLoan);

	DTOIntRotaryQuotaMove getRotaryQuotaMovement(final DTOIntFilterRotaryMovement dtoIntFilterRotaryMovement);

}

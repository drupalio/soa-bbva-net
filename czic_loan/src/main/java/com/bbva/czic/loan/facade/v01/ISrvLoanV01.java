package com.bbva.czic.loan.facade.v01;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;

public interface ISrvLoanV01 {

	public Loan getRotaryQuota(String idLoan);

	public Movement getRotaryQuotaMovement(String idMovement, String idLoan);

}
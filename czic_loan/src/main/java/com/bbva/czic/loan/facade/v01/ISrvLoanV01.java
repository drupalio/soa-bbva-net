package com.bbva.czic.loan.facade.v01;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.dto.net.RotaryQuotaMove;

import java.util.List;

public interface ISrvLoanV01 {

	Loan getRotaryQuota(String idLoan);

	List<Movement> listRotaryQuotaMovements(String idLoan, String paginationKey, Integer pageSize, String filter);

	RotaryQuotaMove getRotaryQuotaMovement(String idMovement, String idLoan);
}
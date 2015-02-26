package com.bbva.czic.loan.facade.v01;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.dto.net.RotaryQuotaMove;

import java.util.List;

public interface ISrvLoanV01 {

	Loan getRotaryQuota(String idLoan);

	List<Movement> listRotaryQuotaMovements(String idLoan, Integer paginationKey, Integer pageSize,
												   String filter);

	Movement getRotaryQuotaMovement(String idMovement, String idLoan);
}
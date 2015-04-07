package com.bbva.zic.loan.facade.v01;

import com.bbva.zic.dto.net.Loan;
import com.bbva.zic.dto.net.Movement;
import com.bbva.zic.dto.net.RotaryQuotaMove;

import java.util.List;

public interface ISrvLoanV01 {

	Loan getRotaryQuota(String idLoan);

	List<Movement> listRotaryQuotaMovements(String idLoan, Integer pageSize, String movementInd, String extractInd, String filter);

	RotaryQuotaMove getRotaryQuotaMovement(String idMovement, String idLoan, String filter);
}
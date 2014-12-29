package com.bbva.czic.loan.facade.v01;

import java.util.Date;
import java.util.List;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;

public interface ISrvLoanV01 {

	public Loan getRotaryQuota(String idLoan);

	public List<Movement> listRotaryQuotaMovements(Date starDate, Date endDate, String paginationKey, Integer pageSize,
			String idLoan);

	public Movement getRotaryQuotaMovement(String idMovement, String idLoan);

}
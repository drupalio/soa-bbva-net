package com.bbva.czic.loan.facade.v01;

import java.util.Date;
import java.util.List;

import com.bbva.czic.dto.net.Loan;

public interface ISrvLoanV01 {

	public Loan getRotaryQuota(String idLoan);

	public List<Loan> listRotaryQuotaMovements(Date starDate, Date endDate, String paginationKey, Integer pageSize,
			String idLoan);

	public Loan getRotaryQuotaMovement(String idRotaryQuotaMovement);

}
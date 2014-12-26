package com.bbva.czic.loan.business;

import java.util.Date;
import java.util.List;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.loan.business.dto.DTOIntRotaryQuotaMovement;

public interface ISrvIntLoan {

	public Loan getRotaryQuota(String idRotaryQuota);

	public List<Loan> listRotaryQuotaMovements(Date starDate, Date endDate, String paginationKey, Integer pageSize,
			String idLoan);

	public DTOIntRotaryQuotaMovement getRotaryQuotaMovement(String idRotaryQuotaMovement);

}
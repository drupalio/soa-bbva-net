package com.bbva.czic.loan.business;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

import java.util.Date;
import java.util.List;

public interface ISrvIntLoan {

	Loan getRotaryQuota(String idRotaryQuota);

	public List<Movement> listRotaryQuotaMovements(String idLoan, String paginationKey, String pageSize, Date fechaInicial, Date fechaFinal);

	public Movement getRotaryQuotaMovement(String idMovement, String idLoan) throws BusinessServiceException;


}
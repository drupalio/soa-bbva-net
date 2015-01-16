package com.bbva.czic.loan.dao;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

@Repository(value = "loanDao")
@Profile(value = "dev")
public class LoanDaoImplMock implements LoanDAO{

	@Override
	public List<DTOIntMovement> listRotaryQuotaMovements(String idLoan,
			String paginationKey, String pageSize, String fechaInicial,
			String fechaFinal) throws BusinessServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DTOIntLoan getRotaryQuota(String idLoan)
			throws BusinessServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DTOIntMovement getRotaryQuotaMovement(String idMovement,
			String idLoan) throws BusinessServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}

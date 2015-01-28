package com.bbva.czic.loan.business.impl;


import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.dto.net.RotaryQuotaMove;
import com.bbva.czic.loan.business.dto.DTOIntFilterLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.czic.loan.business.dto.DTOIntRotaryQuotaMove;


import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;

import com.bbva.czic.routine.commons.rm.utils.validator.DtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.loan.business.ISrvIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.dao.LoanDAO;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

import javax.annotation.Resource;

import java.util.List;

@Service
public class SrvIntLoan implements ISrvIntLoan {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvIntLoan.class,
			"META-INF/spring/i18n/log/mensajesLog");

	@Autowired
	BusinessServicesToolKit businessToolKit;

	@Resource(name = "loanDao")
	private LoanDAO loanDao;

	@Override
	public DTOIntLoan getRotaryQuota(final DTOIntFilterLoan dtoIntFilterLoan) throws BusinessServiceException {

	//	DtoValidator.validate(dtoIntFilterLoan);
		log.info(" getRotaryQuota ");
		// Validar filtro

		final DTOIntLoan result = loanDao.getRotaryQuota(dtoIntFilterLoan);

		// Mapear del filtro al dto
	//	DtoValidator.validate(result);
		// Validar el dto de filtrado
		return result;
	}

	@Override
	public List<DTOIntMovement> listRotaryQuotaMovements(final DTOIntFilterLoan dtoIntFilterLoan) throws BusinessServiceException {
		//DtoValidator.validate(dtoIntFilterLoan);
		log.info(" getRotaryQuota ");
		// Validar filtro

		final List<DTOIntMovement> result = loanDao.listRotaryQuotaMovements(dtoIntFilterLoan);

		// Mapear del filtro al dto
		//DtoValidator.validate(result);
		// Validar el dto de filtrado
		return result;
	}
	@Override
	public DTOIntRotaryQuotaMove getRotaryQuotaMovement(final DTOIntFilterLoan dtoIntFilterLoan) throws BusinessServiceException {
	//	DtoValidator.validate(dtoIntFilterLoan);
		log.info(" getRotaryQuota ");
		// Validar filtro

		final DTOIntRotaryQuotaMove result = loanDao.getRotaryQuotaMovement(dtoIntFilterLoan);

		// Mapear del filtro al dto
	//	DtoValidator.validate(result);
		// Validar el dto de filtrado
		return result;
	}
}

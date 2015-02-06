package com.bbva.czic.loan.business.impl;


import com.bbva.czic.loan.business.dto.*;

import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.validator.DtoValidator;
import com.bbva.czic.routine.commons.rm.utils.validator.impl.StringValidator;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.loan.business.ISrvIntLoan;
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

	@Resource(name = "loanDao")
	private LoanDAO loanDao;

	/**
	 *
	 * @param idLoan
	 * @return
	 * @throws BusinessServiceException
	 */
	@Override
	public DTOIntLoan getRotaryQuota(final String idLoan) throws BusinessServiceException {
		log.info(" getRotaryQuota ");

		new StringValidator().notIsNull(idLoan)
				.isNumericText(idLoan)
				.validate();

		final DTOIntLoan result = loanDao.getRotaryQuota(idLoan);

		// Mapear del filtro al dto
		DtoValidator.validate(result);
		// Validar el dto de filtrado
		return result;
	}

	/**
	 *
	 * @param dtoIntFilterLoan
	 * @return
	 * @throws BusinessServiceException
	 */
	@Override
	public List<DTOIntMovement> listRotaryQuotaMovements(final DTOIntFilterLoan dtoIntFilterLoan) throws BusinessServiceException {

		DtoValidator.validate(dtoIntFilterLoan);
		log.info(" getRotaryQuota ");
		// Validar filtro

		final List<DTOIntMovement> result = loanDao.listRotaryQuotaMovements(dtoIntFilterLoan);

		// Mapear del filtro al dto
	    DtoValidator.validate(result);
		// Validar el dto de filtrado
		return result;
	}

	/**
	 *
	 * @param dtoIntFilterRotaryMovement
	 * @return
	 * @throws BusinessServiceException
	 */
	@Override
	public DTOIntRotaryQuotaMove getRotaryQuotaMovement(final DTOIntFilterRotaryMovement dtoIntFilterRotaryMovement) throws BusinessServiceException {

		log.info(" getRotaryQuota ");
		DtoValidator.validate(dtoIntFilterRotaryMovement);
		final DTOIntRotaryQuotaMove result = loanDao.getRotaryQuotaMovement(dtoIntFilterRotaryMovement);

		// Mapear del filtro al dto
		DtoValidator.validate(result);
		// Validar el dto de filtrado
		return result;
	}
}

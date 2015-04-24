package com.bbva.czic.loan.business.impl;


import com.bbva.czic.loan.business.dto.*;

import com.bbva.czic.loan.dao.impl.LoanDAO;
import com.bbva.czic.routine.commons.rm.utils.validator.DtoValidator;
import com.bbva.czic.routine.commons.rm.utils.validator.impl.StringValidator;
import org.springframework.stereotype.Service;
import com.bbva.czic.loan.business.ISrvIntLoan;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
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

		DtoValidator.validate(result);

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

		dtoIntFilterLoan.setIdExtracto(dtoIntFilterLoan.getPaginationKey().substring(0, 4));
		dtoIntFilterLoan.setIdMovement(dtoIntFilterLoan.getPaginationKey().substring(4,dtoIntFilterLoan.getPaginationKey().length()));

		DtoValidator.validate(dtoIntFilterLoan);
		log.info(" getRotaryQuota ");

		final List<DTOIntMovement> result = loanDao.listRotaryQuotaMovements(dtoIntFilterLoan);

	    DtoValidator.validate(result);
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

		dtoIntFilterRotaryMovement.setIdMovement(dtoIntFilterRotaryMovement.getIdMovement().substring(0,5));
		dtoIntFilterRotaryMovement.setIdExtracto(dtoIntFilterRotaryMovement.getIdMovement().substring(6, dtoIntFilterRotaryMovement.getIdMovement().length()));

		DtoValidator.validate(dtoIntFilterRotaryMovement);
		final DTOIntRotaryQuotaMove result = loanDao.getRotaryQuotaMovement(dtoIntFilterRotaryMovement);

		DtoValidator.validate(result);

		return result;
	}
}

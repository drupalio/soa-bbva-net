package com.bbva.czic.loan.business.impl;


import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.dto.net.RotaryQuotaMove;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.czic.loan.business.dto.DTOIntRotaryQuotaMove;
import com.bbva.czic.loan.dao.mapper.LoanMapper;

import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.validator.impl.DateValidator;
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

import java.util.ArrayList;
import java.util.Date;
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
	public Loan getRotaryQuota(final String idRotaryQuota) throws BusinessServiceException {
		try {
			log.info("SrvIntLoan.getRotaryQuota = " + idRotaryQuota);

			final DTOIntLoan dtoIntLoan = loanDao.getRotaryQuota(idRotaryQuota);
			Loan loan = LoanMapper.getLoan(dtoIntLoan);
			return loan;
		}catch(BusinessServiceException ex){
			log.error("SrvIntLoan.getRotaryQuota = " + ex.getMessage());
			throw ex;
		} catch (Exception e) {
			log.error("SrvIntLoan.getRotaryQuota.exception = " + e.getMessage());
			throw new BusinessServiceException(EnumError.TECHNICAL_ERROR.getAlias());
		}
	}

	@Override
	public List<Movement> listRotaryQuotaMovements(final String idLoan, final String paginationKey, final String pageSize, final Date fechaInicila, final Date fechaFinal) throws BusinessServiceException {

		try {
			List<Movement> movementList = new ArrayList<Movement>();

			log.info("A query string (filter) has been sent Loan -----> : " + idLoan + ", " + paginationKey + ", " + pageSize + ", " + fechaInicila + ", " + fechaFinal);

			final List<DTOIntMovement> intLoan = loanDao.listRotaryQuotaMovements(idLoan, paginationKey, pageSize, fechaInicila, fechaFinal);

			for (DTOIntMovement item : intLoan) {
				Movement movement = new Movement();

				movement = LoanMapper.getMovementByDTOIntMovement(item);

				movementList.add(movement);
			}
			return movementList;
		} catch (BusinessServiceException be) {
			log.error("error en listRotaryQuotaMovements = " + be.getMessage());
			throw be;
		} catch (Exception e) {
			log.error("error en listRotaryQuotaMovements = " + e.getMessage());
			throw new BusinessServiceException(EnumError.TECHNICAL_ERROR.getAlias());
		}

	}
	@Override
	public RotaryQuotaMove getRotaryQuotaMovement(final String idLoan, final String idMovement) throws BusinessServiceException {

		try {
			log.info("SrvIntLoan.getRotaryQuotaMovement = " + idMovement + ", " + idLoan);

			final DTOIntRotaryQuotaMove dtoIntRotaryQuotaMove = loanDao.getRotaryQuotaMovement( Integer.parseInt(idMovement), idLoan);
			log.info("SrvIntLoan.getRotaryQuotaMovement retorno exitoso inicio mapeo... ");
			RotaryQuotaMove movement = LoanMapper.getMovementByDTOIntMovement(dtoIntRotaryQuotaMove);
			log.info("SrvIntLoan.getRotaryQuotaMovement mapeo OK... ");
			return movement;
		} catch (BusinessServiceException be) {
			log.info("SrvIntLoan.getRotaryQuotaMovement.BusinessServiceException = " + be.getMessage());
			throw be;
		} catch (Exception e) {
			log.info("SrvIntLoan.getRotaryQuotaMovement.exception = " + e.getMessage());
			throw new BusinessServiceException(EnumError.TECHNICAL_ERROR.getAlias());
		}
	}
}

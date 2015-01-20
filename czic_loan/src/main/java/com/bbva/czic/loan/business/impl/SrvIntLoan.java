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
			if (idRotaryQuota == null || idRotaryQuota.equals("null") || idRotaryQuota.trim().isEmpty()) {
				throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias());
			}
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
			Movement movement = null;
			List<Movement> movementList = new ArrayList<Movement>();

			log.info("A query string (filter) has been sended Loan -----> : " + idLoan + ", " + paginationKey + ", " + pageSize + ", " + fechaInicila + ", " + fechaFinal);

			if (paginationKey == null || paginationKey.equals("null") ||
					pageSize == null || pageSize.equals("null")){
				log.info("SrvIntLoan.listRotaryQuotaMovements.nullParameters------------ " );
				throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias());
			}

			final List<DTOIntMovement> intLoan = loanDao.listRotaryQuotaMovements(idLoan, paginationKey, pageSize, fechaInicila, fechaFinal);

			for (DTOIntMovement item : intLoan) {
				movement = new Movement();

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
			RotaryQuotaMove movement = null;
			log.info("SrvIntLoan.getRotaryQuotaMovement = " + idMovement + ", " + idLoan);
			if (idMovement == null || idMovement.isEmpty() || idLoan == null || idLoan.trim().isEmpty()) throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias());

			final DTOIntRotaryQuotaMove dtoIntRotaryQuotaMove = loanDao.getRotaryQuotaMovement( Integer.parseInt(idMovement), idLoan);
			movement = LoanMapper.getMovementByDTOIntMovement(dtoIntRotaryQuotaMove);

			return movement;
		} catch (Exception e) {
			log.info("SrvIntLoan.getRotaryQuotaMovement.exception = " + e.getMessage());
			throw new BusinessServiceException(EnumError.TECHNICAL_ERROR.getAlias());
		}
	}
}

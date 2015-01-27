package com.bbva.czic.loan.business.impl;


import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.czic.loan.dao.mapper.LoanMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bbva.czic.loan.business.ISrvIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.dao.LoanDAO;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SrvIntLoan implements ISrvIntLoan {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvIntLoan.class,
			"META-INF/spring/i18n/log/mensajesLog");

	@Autowired
	BusinessServicesToolKit businessToolKit;

	@Autowired
	@Qualifier("loanDao")
	private LoanDAO loanDao;

	@Override
	public Loan getRotaryQuota(final String idRotaryQuota) throws BusinessServiceException {
		try {
			log.info("SrvIntLoan.getRotaryQuota = " + idRotaryQuota);
			if (idRotaryQuota == null) {
				throw new BusinessServiceException("loanPeticiongetRotaryQuota");
			}
			final DTOIntLoan dtoIntLoan = loanDao.getRotaryQuota(idRotaryQuota);
			Loan loan = LoanMapper.getLoan(dtoIntLoan);
			return loan;
		}catch(BusinessServiceException ex){
			log.error("SrvIntLoan.getRotaryQuota = " + ex.getMessage());
			throw ex;
		} catch (Exception e) {
			log.error("SrvIntLoan.getRotaryQuota.exception = " + e.getMessage());
			throw new BusinessServiceException(e.getMessage());
		}
	}

	@Override
	public List<Movement> listRotaryQuotaMovements(final String idLoan, final String paginationKey, final String pageSize, final Date fechaInicila, Date fechaFinal) throws BusinessServiceException {

		try {
			Movement movement = null;
			List<Movement> movementList = new ArrayList<Movement>();

			log.info("A query string (filter) has been sended Loan -----> : " + idLoan + ", " + paginationKey + ", " + pageSize + ", " + fechaInicila + ", " + fechaFinal);

			if (paginationKey == null || paginationKey.equals("null") ||
					pageSize == null || pageSize.equals("null")){
				log.info("SrvIntLoan.listRotaryQuotaMovements.nullParameters------------ " );
				throw new BusinessServiceException("loanPeticionListRotary");
			}		

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
            String fechaIni = simpleDateFormat.format(fechaInicila);
			String fechaFin = simpleDateFormat.format(fechaFinal);

			final List<DTOIntMovement> intLoan = loanDao.listRotaryQuotaMovements(idLoan, paginationKey, pageSize, fechaIni, fechaFin);

			for (DTOIntMovement item : intLoan) {
				movement = new Movement();

				movement = LoanMapper.getMovementByDTOIntMovement(item);

				movementList.add(movement);
			}
			return movementList;
		} catch (Exception e) {
			log.error("error en listRotaryQuotaMovements = " + e.getMessage());
			throw new BusinessServiceException(e.getMessage());
		}

	}
	@Override
	public Movement getRotaryQuotaMovement(final String idLoan, final String idMovement) throws BusinessServiceException {

		try {
			Movement movement = null;
			log.info("SrvIntLoan.getRotaryQuotaMovement = " + idMovement + ", " + idLoan);
			if (idMovement == null || idLoan == null) throw new BusinessServiceException("loanPeticionRotaryMovement");

			final DTOIntMovement dtoIntMovement = loanDao.getRotaryQuotaMovement(idMovement, idLoan);
			movement = LoanMapper.getMovementByDTOIntMovement(dtoIntMovement);

			return movement;
		} catch (Exception e) {
			log.info("SrvIntLoan.getRotaryQuotaMovement.exception = " + e.getMessage());
			throw new BusinessServiceException(e.getMessage());
		}
	}
}

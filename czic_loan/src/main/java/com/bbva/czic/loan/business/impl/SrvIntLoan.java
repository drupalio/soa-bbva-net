package com.bbva.czic.loan.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.loan.business.ISrvIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.czic.loan.dao.LoanDAO;
import com.bbva.czic.mapper.LoanMapper;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

@Service
public class SrvIntLoan implements ISrvIntLoan {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvIntLoan.class, "META-INF/spring/i18n/log/mensajesLog");

	@Autowired
	BusinessServicesToolKit businessToolKit;

	@Autowired
	private LoanDAO loanDao;

	@Override
	public Loan getRotaryQuota(String idRotaryQuota) throws BusinessServiceException {
		try {
			Loan loan = new Loan();

			if (idRotaryQuota == null) throw new BusinessServiceException("loanPeticiongetRotaryQuota");

			DTOIntLoan dtoIntLoan = loanDao.getRotaryQuota(idRotaryQuota);

			loan.setPayment(dtoIntLoan.getPayment());
			loan.setStatus(dtoIntLoan.getStatus());
			loan.setBalance(dtoIntLoan.getBalance());

			return loan;
		} catch (Exception e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}

	@Override
	public List<Movement> listRotaryQuotaMovements(String idLoan, String filter, String fields, String expands,
			String sort) throws BusinessServiceException {

		try {
			Movement movement = null;
			List<Movement> movementList = new ArrayList<Movement>();

			log.info("A query string (filter) has been sended: " + filter + ", " + fields + ", " + expands + ", "
					+ sort);

			if (idLoan == null || filter == null || fields == null || expands == null || sort == null)
				throw new BusinessServiceException("loanPeticionListRotary");

			List<DTOIntMovement> intLoan = loanDao.listRotaryQuotaMovements(idLoan, filter, fields, expands, sort);

			for (DTOIntMovement item : intLoan) {
				movement = new Movement();

				movement = (Movement)LoanMapper.getInstance().getMapper(item, Movement.class);

				movementList.add(movement);
			}
			return movementList;
		} catch (Exception e) {
			throw new BusinessServiceException(e.getMessage());
		}

	}

	@Override
	public Movement getRotaryQuotaMovement(String idMovement, String idLoan) throws BusinessServiceException {

		try {
			Movement movement = null;
			if (idMovement == null || idLoan == null) throw new BusinessServiceException("loanPeticionRotaryMuvement");

			DTOIntMovement dtoIntMovement = loanDao.getRotaryQuotaMovement(idMovement, idLoan);
			movement = (Movement)LoanMapper.getInstance().getMapper(dtoIntMovement, Movement.class);

			return movement;
		} catch (Exception e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}
}

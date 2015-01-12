package com.bbva.czic.loan.business.impl;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.mapper.LoanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.loan.business.ISrvIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.dao.LoanDAO;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

@Service
public class SrvIntLoan implements ISrvIntLoan {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvIntLoan.class,
			"META-INF/spring/i18n/log/mensajesLog");

	@Autowired
	BusinessServicesToolKit businessToolKit;

	@Autowired
	private LoanDAO loanDao;

	@Override
	public Loan getRotaryQuota(String idRotaryQuota) throws BusinessServiceException {
		try {

			if (idRotaryQuota == null) {
				throw new BusinessServiceException("loanPeticiongetRotaryQuota");
			}
			DTOIntLoan dtoIntLoan = loanDao.getRotaryQuota(idRotaryQuota);
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
}

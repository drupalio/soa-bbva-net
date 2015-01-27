package com.bbva.czic.loan.dao;


import com.bbva.czic.loan.business.dto.*;
import com.bbva.czic.loan.dao.model.ozni.*;
import com.bbva.czic.loan.dao.model.oznk.*;
import com.bbva.czic.loan.dao.tx.TxGetRotaryQuota;
import com.bbva.czic.loan.dao.tx.TxGetRotaryQuotaMovement;
import com.bbva.czic.loan.dao.tx.TxListRotaryQuotaMovements;
import com.bbva.czic.loan.facade.v01.utils.impl.LoanDAOMock;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.bbva.czic.loan.business.impl.SrvIntLoan;

import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

import javax.annotation.Resource;

import java.util.List;

@Component(value = "loanDao")
public class LoanDAOImpl implements LoanDAO {
	
	private static I18nLog log = I18nLogFactory.getLogI18n(SrvIntLoan.class,
			"META-INF/spring/i18n/log/mensajesLog");

	/**
	 * OZNJ
	 */
	@Resource(name = "tx-get-rotary-quota")
	private TxGetRotaryQuota txGetRotaryQuota;

	/**
	 * OZNI
	 */
	@Resource(name = "tx-list-rotary-quota-movements")
	private TxListRotaryQuotaMovements txListRotaryQuotaMovements;

	/**
	 * OZNK
	 */
	@Resource(name = "tx-get-rotary-quota-movement")
	private TxGetRotaryQuotaMovement txGetRotaryQuotaMovement;


	public DTOIntLoan getRotaryQuota(final DTOIntFilterLoan dtoIntFilterLoan){
		return txGetRotaryQuota.invoke(dtoIntFilterLoan);
	}

	@Override
	public List<DTOIntMovement> listRotaryQuotaMovements(final DTOIntFilterLoan dtoIntFilterLoan) {
		return txListRotaryQuotaMovements.invoke(dtoIntFilterLoan);
	}


	@Override
	public DTOIntRotaryQuotaMove getRotaryQuotaMovement(final DTOIntFilterLoan dtoIntFilterLoan){
		return txGetRotaryQuotaMovement.invoke(dtoIntFilterLoan);
	}
}

package com.bbva.czic.loan.dao;

import com.bbva.czic.loan.business.dto.*;

import com.bbva.czic.loan.dao.impl.LoanDAO;
import com.bbva.czic.loan.dao.tx.TxGetRotaryQuota;
import com.bbva.czic.loan.dao.tx.TxGetRotaryQuotaMovement;
import com.bbva.czic.loan.dao.tx.TxListRotaryQuotaMovements;
import org.springframework.stereotype.Repository;

import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

import javax.annotation.Resource;

import java.util.List;

@Repository(value = "loanDao")
public class LoanDAOImpl implements LoanDAO {
	
	private static I18nLog log = I18nLogFactory.getLogI18n(LoanDAOImpl.class,
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


	/**
	 *
	 * @param idLoan
	 * @return
	 */
	public DTOIntLoan getRotaryQuota(final String idLoan){
		return txGetRotaryQuota.invoke(idLoan);
	}

	/**
	 *
	 * @param dtoIntFilterLoan
	 * @return
	 */
	@Override
	public List<DTOIntMovement> listRotaryQuotaMovements(final DTOIntFilterLoan dtoIntFilterLoan) {
		return txListRotaryQuotaMovements.invoke(dtoIntFilterLoan);
	}

	/**
	 *
	 * @param dtoIntFilterRotaryMovement
	 * @return
	 */
	@Override
	public DTOIntRotaryQuotaMove getRotaryQuotaMovement(final DTOIntFilterRotaryMovement dtoIntFilterRotaryMovement){
		return txGetRotaryQuotaMovement.invoke(dtoIntFilterRotaryMovement);
	}
}

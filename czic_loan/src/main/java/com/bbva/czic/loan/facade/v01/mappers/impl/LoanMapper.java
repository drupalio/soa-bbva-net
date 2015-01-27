package com.bbva.czic.loan.facade.v01.mappers.impl;


import com.bbva.czic.dto.net.Account;
import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.dto.net.RotaryQuotaMove;
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.czic.loan.business.dto.DTOIntRotaryQuotaMove;
import com.bbva.czic.loan.facade.v01.mappers.ILoanMapper;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaConfigurableMapper;
import com.bbva.czic.routine.commons.rm.utils.mappers.Mapper;
import com.bbva.czic.routine.mapper.MapperFactory;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

import java.util.List;


@Mapper(value = "loan-mapper")
public class LoanMapper extends AbstractBbvaConfigurableMapper implements ILoanMapper {

	private static I18nLog log = I18nLogFactory
			.getLogI18n(LoanMapper.class, "META-INF/spring/i18n/log/mensajesLog");

	@Override
	protected void configure(MapperFactory factory) {

	/*	super.configure(factory);

		// Map DTOIntCheckbook <-> CheckBook
		factory.classMap(DTOIntCheckbook.class, Checkbook.class).field("id", "id").field("firstCheck", "firstCheck")
				.field("lastCheck", "lastCheck").field("totalCheck", "totalCheck").field("actualState", "actualState")
				.field("deliveryDate", "deliveryDate").field("requestDate", "requestDate").byDefault().register();

		factory.classMap(DTOIntBalance.class, Balance.class).field("total", "total")
				.field("availableBalance", "availableBalance").byDefault().register();

		// Map DTOIntAccount <-> FormatoOZECNVE0
		factory.classMap(DTOIntAccount.class, Account.class).field("name", "name").field("idAccount", "id")
				.field("balance", "balance").field("listaCheckBook", "checkbooks").byDefault().register();

		// // Map DTOIntCheck <-> FormatoOZECNVE0
		factory.classMap(DTOIntCheck.class, Check.class).field("id", "id").field("status", "status")
				.field("issueDate", "issueDate").field("value", "value").byDefault().register();
		//
		// // Map DTOIntMonthlyBalances <-> MonthlyBalances
		factory.classMap(DTOIntMonthlyBalances.class, MonthlyBalances.class).field("balance", "balance")
				.field("month", "month").byDefault().register();

		// // Map DTOIntAccMovementsResume <-> AccMovementsResume
		factory.classMap(DTOIntAccMovementsResume.class, AccMovementsResume.class).field("month.mes", "month")
				.field("balance", "balance").field("income", "income").field("outcome", "outcome").byDefault()
				.register();
*/
	}


	@Override
	public Loan map(DTOIntLoan dtoIntLoan) {
		return map(dtoIntLoan, Loan.class);
	}

	@Override
	public List<Movement> map(List<DTOIntMovement> listaDtoIntMovement) {
		return null;
	}

	@Override
	public RotaryQuotaMove map(DTOIntRotaryQuotaMove dtoIntRotaryQuotaMove) {
		return null;
	}
}
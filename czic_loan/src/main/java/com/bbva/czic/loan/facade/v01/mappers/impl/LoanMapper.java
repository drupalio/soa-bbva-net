package com.bbva.czic.loan.facade.v01.mappers.impl;


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
import com.bbva.czic.routine.mapper.factory.MoneyFactory;
import com.bbva.czic.routine.mapper.metadata.TypeFactory;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

import java.util.List;


@Mapper(value = "loan-mapper")
public class LoanMapper extends AbstractBbvaConfigurableMapper implements ILoanMapper {

	private static I18nLog log = I18nLogFactory
			.getLogI18n(LoanMapper.class, "META-INF/spring/i18n/log/mensajesLog");

	/**
	 *
	 * @param factory
	 */
	@Override
	protected void configure(MapperFactory factory) {

		super.configure(factory);


		// Map DTOIntLoan <-> Loan
		factory.classMap(DTOIntLoan.class, Loan.class)
				.field("id", "id")
				.field("type", "type")
				.field("name", "name")
				.field("status", "status")
				.field("payment", "payment")
				.field("debt", "debt")
				.field("balance", "balance")
				.byDefault().register();

		// Map DTOIntRotaryQuotaMove <-> RotaryQuotaMove
		factory.classMap(DTOIntRotaryQuotaMove.class, RotaryQuotaMove.class)
				.field("id", "id")
				.field("concept", "concept")
				.field("transactionDate", "transactionDate")
				.field("operation", "operation")
				.field("status", "status")
				.field("value", "value")
				.field("balance", "balance")
				.byDefault().register();

		// Map DTOIntMovement <-> Movement
		factory.classMap(DTOIntRotaryQuotaMove.class, RotaryQuotaMove.class)
				.field("id", "id")
				.field("concept", "concept")
				.field("transactionDate", "transactionDate")
				.field("operation", "operation")
				.field("status", "status")
				.field("value", "value")
				.field("balance", "balance")
				.byDefault().register();
	}

	/**
	 *
	 * @param dtoIntLoan
	 * @return
	 */
	@Override
	public Loan map(DTOIntLoan dtoIntLoan) {
		return map(dtoIntLoan, Loan.class);
	}

	/**
	 *
	 * @param listaDtoIntMovement
	 * @return
	 */
	@Override
	public List<Movement> map(List<DTOIntMovement> listaDtoIntMovement) {
		return mapAsList(listaDtoIntMovement, Movement.class);
	}

	/**
	 *
	 * @param dtoIntRotaryQuotaMove
	 * @return
	 */
	@Override
	public RotaryQuotaMove map(DTOIntRotaryQuotaMove dtoIntRotaryQuotaMove) {return map(dtoIntRotaryQuotaMove, RotaryQuotaMove.class);
	}
}
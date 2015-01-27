package com.bbva.czic.loan.facade.v01.mappers.impl;


import com.bbva.czic.dto.net.Account;
import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.dto.net.RotaryQuotaMove;
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.czic.loan.business.dto.DTOIntRotaryQuotaMove;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCENJ0;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCSNJ0;
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

	@Override
	protected void configure(MapperFactory factory) {

		super.configure(factory);

		factory.registerObjectFactory(new MoneyFactory(), TypeFactory.<Money>valueOf(Money.class));

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

		// Map DTOIntMovement <-> Movement
		factory.classMap(DTOIntMovement.class, Movement.class)
				.field("id", "id").field("concept", "concept").field("transactionDate", "transactionDate")
				.field("operation.description", "operation.description").field("status", "status").field("value", "value")
				.field("balance", "balance")
				.byDefault().register();
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
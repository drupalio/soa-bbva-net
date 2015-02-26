package com.bbva.czic.loan.facade.v01.mappers.impl;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.dto.net.RotaryQuotaMove;
import com.bbva.czic.loan.business.dto.DTOIntFilterLoan;
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.czic.loan.business.dto.DTOIntRotaryQuotaMove;
import com.bbva.czic.loan.facade.v01.mappers.ILoanMapper;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.fiql.FiqlType;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaConfigurableMapper;
import com.bbva.czic.routine.commons.rm.utils.mappers.Mapper;
import com.bbva.czic.routine.mapper.MapperFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Mapper(value = "loan-mapper")
public class LoanMapper extends AbstractBbvaConfigurableMapper implements ILoanMapper {

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

		// Map DTOIntLoan <-> Loan
		factory.classMap(DTOIntMovement.class, Movement.class)
				.field("id", "id")
				.field("concept", "concept")
				.field("transactionDate", "transactionDate")
				.field("operation", "operation")
				.field("value", "value")
				.field("balance", "balance")

				.byDefault().register();

		// Map DTOIntMovement <-> RotaryQuotaMove
		factory.classMap(DTOIntRotaryQuotaMove.class, RotaryQuotaMove.class)
				.field("id", "id")
				.field("concept", "concept")
				.field("transactionDate", "transactionDate")
				.field("operation", "operation")
				.field("status", "status")
				.field("value", "value")
				.field("balance", "balance")
				.field("numbersOfQuota", "numbersOfQuota")
				.field("remainingQuotas", "remainingQuotas")
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

	@Override
	public DTOIntFilterLoan getDtoIntFilter(String filter) {
		final String startDate =  this.getGeValue(filter, FiqlType.transactionDate.name());
		final String endDate = this.getLeValue(filter, FiqlType.transactionDate.name());

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		final DTOIntFilterLoan dtoIntFilterLoan = new DTOIntFilterLoan();
		try {
			dtoIntFilterLoan.setFechaInicial(simpleDateFormat.parse(startDate));
			dtoIntFilterLoan.setFechaFinal(simpleDateFormat.parse(endDate));
		} catch (ParseException e) {
			throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias());
		}

		return dtoIntFilterLoan;
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
	public RotaryQuotaMove map(DTOIntRotaryQuotaMove dtoIntRotaryQuotaMove) {
		return map(dtoIntRotaryQuotaMove, RotaryQuotaMove.class);
	}
}
package com.bbva.czic.loan.dao.mappers;

import com.bbva.czic.loan.business.dto.DTOIntFilterLoan;

import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.dao.mappers.impl.ITxLoanMapper;

import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCENJ0;

import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCSNJ0;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaTxConfigurableMapper;
import com.bbva.czic.routine.mapper.MapperFactory;
import com.bbva.czic.routine.mapper.factory.MoneyFactory;
import com.bbva.czic.routine.mapper.impl.ConfigurableMapper;
import com.bbva.czic.routine.mapper.metadata.TypeFactory;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.springframework.stereotype.Component;


@Component(value = "tx-loan-mapper")
public class TxLoanMapper extends AbstractBbvaTxConfigurableMapper implements ITxLoanMapper {

	private static I18nLog log = I18nLogFactory.getLogI18n(TxLoanMapper.class,
			"META-INF/spring/i18n/log/mensajesLog");


	@Override
	protected void configure(MapperFactory factory) {

		super.configure(factory);

		// Map  FormatoOZNCENJ0 DTOIntLoan
		factory.classMap(FormatoOZNCENJ0.class, DTOIntLoan.class)
				.field("nomtarj", "id").byDefault().register();

		// Map  FormatoOZNCSNJ0 DTOIntLoan
		factory.classMap(FormatoOZNCSNJ0.class, DTOIntLoan.class)
				.field("numcont", "id")
				.field("tipprod", "type")
				.field("desctar", "name")
				.field("saldoto", "balance.total")
				.field("pagomin", "payment.minimumPayment")
				.field("mntosol", "debt.total")
				.field("saldope", "debt.availableBalance")
				.field("fechaca", "payment.dueDate")
				.field("fechali", "payment.shortDate")
				.field("fechaco", "payment.shortDate")
				.field("honorar", "payment.fees")
				.field("cuotato", "payment.numbersOfQuota")
				.field("estadot", "status")
				.byDefault().register();

	}


		@Override
	public FormatoOZNCENJ0 mapInOznj(DTOIntFilterLoan dtoIn) {
		return map(dtoIn, FormatoOZNCENJ0.class);
	}

	@Override
	public DTOIntLoan mapOutOznj(FormatoOZNCSNJ0 formatOutput) {
		return map(formatOutput, DTOIntLoan.class);
	}
}

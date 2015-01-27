package com.bbva.czic.loan.dao.mappers;

import com.bbva.czic.loan.business.dto.DTOIntFilterLoan;

import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.dao.mappers.impl.ITxLoanMapper;

import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCENJ0;

import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCSNJ0;
import com.bbva.czic.routine.mapper.impl.ConfigurableMapper;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;


public class TxLoanMapper extends ConfigurableMapper implements ITxLoanMapper {

	private static I18nLog log = I18nLogFactory.getLogI18n(TxLoanMapper.class,
			"META-INF/spring/i18n/log/mensajesLog");


	@Override
	public FormatoOZNCENJ0 mapInOznj(DTOIntFilterLoan dtoIn) {
		return map(dtoIn, FormatoOZNCENJ0.class);
	}

	@Override
	public DTOIntLoan mapOutOznj(FormatoOZNCSNJ0 formatOutput) {
		return map(formatOutput, DTOIntLoan.class);
	}
}

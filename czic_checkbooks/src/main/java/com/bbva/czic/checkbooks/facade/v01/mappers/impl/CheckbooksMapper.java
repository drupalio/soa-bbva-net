package com.bbva.czic.checkbooks.facade.v01.mappers.impl;

import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckFilter;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckbook;
import com.bbva.czic.dto.net.*;
import com.bbva.czic.checkbooks.facade.v01.mappers.ICheckbookMapper;
import com.bbva.czic.routine.commons.rm.utils.fiql.FiqlType;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaConfigurableMapper;
import com.bbva.czic.routine.mapper.MapperFactory;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component(value = "checkbooks-mapper")
public class CheckbooksMapper extends AbstractBbvaConfigurableMapper implements ICheckbookMapper {

	@Override
	protected void configure(MapperFactory factory) {

		super.configure(factory);

		// Map DTOIntCheckbook <-> CheckBook
		factory.classMap(DTOIntCheck.class, Check.class).field("id", "id").field("issueDate", "issueDate")
				.field("value", "value").field("status", "status").field("modifiedDate", "modifiedDate").byDefault().register();
	}


	@Override
	public Check map(DTOIntCheck intCheck) {
		log.info("map- return:Check-parameter:dtoIntExecutive");
		return map(intCheck, Check.class);
	}


	@Override
	public DTOIntCheckFilter getDTOIntFilter(String checkId,String accountId) {

	//	final String ge = this.getGeValue(filter, FiqlType.month.name());
	//	final String le = this.getLeValue(filter, FiqlType.month.name());

		final DTOIntCheckFilter dtoIntCheckFilter = new DTOIntCheckFilter();
	//	dtoIntFilterAccount.setStartDate(ge);
	//	dtoIntFilterAccount.setEndDate(le);
		dtoIntCheckFilter.setCheckId(checkId);
		dtoIntCheckFilter.setAccountId(accountId);

		return dtoIntCheckFilter;

	}
}

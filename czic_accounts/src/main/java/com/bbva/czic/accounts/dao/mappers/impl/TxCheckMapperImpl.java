package com.bbva.czic.accounts.dao.mappers.impl;

import com.bbva.czic.accounts.business.dto.*;
import com.bbva.czic.accounts.dao.mappers.TxAccountMapper;
import com.bbva.czic.accounts.dao.mappers.TxCheckMapper;
import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCENA0;
import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCSNA0;
import com.bbva.czic.accounts.dao.model.oznu.FormatoOZECNUE0;
import com.bbva.czic.accounts.dao.model.oznu.FormatoOZECNUS0;
import com.bbva.czic.accounts.dao.model.oznv.FormatoOZECNVE0;
import com.bbva.czic.accounts.dao.model.oznv.FormatoOZECNVS0;
import com.bbva.czic.accounts.dao.model.oznx.FormatoOZECNXE0;
import com.bbva.czic.accounts.dao.model.oznx.FormatoOZECNXS0;
import com.bbva.czic.routine.commons.rm.utils.converter.StringMoneyConverter;
import com.bbva.czic.routine.commons.rm.utils.mappers.Mapper;
import com.bbva.czic.routine.mapper.CustomMapper;
import com.bbva.czic.routine.mapper.MapperFactory;
import com.bbva.czic.routine.mapper.MappingContext;
import com.bbva.czic.routine.mapper.impl.ConfigurableMapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(value = "txCheckMapper")
public class TxCheckMapperImpl extends ConfigurableMapper implements TxCheckMapper {

	/**
	 * 
	 */
	@Override
	protected void configure(MapperFactory factory) {

		/**
		 * Convert HOST FORMAT (+EEEEEEEEDD) to COP Money
		 */
		factory.getConverterFactory().registerConverter(new StringMoneyConverter());

		/**
		 * MAPEO DE ENTRADAS
		 */
		// Map DTOIntFilterChecks <-> FormatoOZECNXE0 (OZNX)
		factory.classMap(DTOIntFilterChecks.class, FormatoOZECNXE0.class)
				.field("accountId", "numprod")
				.field("startDate", "fechini")
				.field("endDate", "fechfin")
				.field("paginationKey", "indpagi")
				.field("pageSize", "tampagi")
				.field("status", "estcheq")
				.byDefault().register();
		/**
		 * MAPEO DE SALIDAS
		 */
		// Map FormatoOZECNVS0 <-> DTOIntMonthlyBalances (OZNA)
		factory.classMap(DTOIntCheck.class, FormatoOZECNXS0.class)
				.field("id", "numcheq")
				.field("issueDate", "fechemi")
				.field("value", "valcheq")
				.field("status", "estcheq")
				.field("modifiedDate", "fechmod")
				.byDefault().register();

	}


	@Override
	public FormatoOZECNXE0 mapInOznx(DTOIntFilterChecks dtoIn) {
		return map(dtoIn, FormatoOZECNXE0.class);
	}

	@Override
	public DTOIntCheck mapOutOznx(FormatoOZECNXS0 formatOutput) {
		return map(formatOutput, DTOIntCheck.class);
	}
}

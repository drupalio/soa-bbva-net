package com.bbva.zic.accounts.dao.mappers.impl;

import com.bbva.zic.accounts.business.dto.DTOIntCheck;
import com.bbva.zic.accounts.business.dto.DTOIntFilterChecks;
import com.bbva.zic.accounts.dao.mappers.TxCheckMapper;
import com.bbva.zic.accounts.dao.model.oznx.FormatoOZECNXE0;
import com.bbva.zic.accounts.dao.model.oznx.FormatoOZECNXS0;
import com.bbva.zic.routine.commons.rm.utils.mappers.AbstractBbvaTxConfigurableMapper;
import com.bbva.zic.routine.commons.rm.utils.mappers.Mapper;
import com.bbva.zic.routine.mapper.MapperFactory;

@Mapper(value = "txCheckMapper")
public class TxCheckMapperImpl extends AbstractBbvaTxConfigurableMapper implements TxCheckMapper {

	private static final String ENUM_CHECK_STATUS_TO_STRING_MAPPER = "EnumCheckStatusToStringMapper";
	private static final String STRING_TO_ENUM_CHECK_STATUS_MAPPER = "StringToEnumCheckStatusMapper";

	@Override
	protected void configure(MapperFactory factory) {

		super.configure(factory);

//		factory.getConverterFactory().registerConverter(ENUM_CHECK_STATUS_TO_STRING_MAPPER,new EnumCheckStatusConverter());
//		factory.getConverterFactory().registerConverter(STRING_TO_ENUM_CHECK_STATUS_MAPPER,new StringEnumCheckStatusConverter());

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
		factory.classMap(FormatoOZECNXS0.class, DTOIntCheck.class)
				.field("numcheq", "id")
				.field("fechemi", "issueDate")
				.field("valcheq", "value")
				.field("estcheq", "status")
				.field("fechmod", "modifiedDate")
				.byDefault().register();

	}


	@Override
	public FormatoOZECNXE0 mapInOznx(DTOIntFilterChecks dtoIn) {
		FormatoOZECNXE0 formato = map(dtoIn, FormatoOZECNXE0.class);
		return formato;
	}

	@Override
	public DTOIntCheck mapOutOznx(FormatoOZECNXS0 formatOutput) {
		DTOIntCheck dto = map(formatOutput, DTOIntCheck.class);
		return dto;
	}
}

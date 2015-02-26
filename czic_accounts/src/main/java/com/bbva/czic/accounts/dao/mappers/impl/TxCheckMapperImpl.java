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
import com.bbva.czic.dto.net.EnumCheckStatus;
import com.bbva.czic.routine.commons.rm.utils.converter.EnumCheckStatusConverter;
import com.bbva.czic.routine.commons.rm.utils.converter.StringEnumCheckStatusConverter;
import com.bbva.czic.routine.commons.rm.utils.converter.StringMoneyConverter;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaTxConfigurableMapper;
import com.bbva.czic.routine.commons.rm.utils.mappers.Mapper;
import com.bbva.czic.routine.mapper.CustomMapper;
import com.bbva.czic.routine.mapper.MapperFactory;
import com.bbva.czic.routine.mapper.MappingContext;
import com.bbva.czic.routine.mapper.impl.ConfigurableMapper;

import java.util.ArrayList;
import java.util.List;

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
		if(formato.getEstcheq() != null) {
			formato.setEstcheq(EnumCheckStatus.valueOf(formato.getEstcheq()).getCodigo());
		}
		return formato;
	}

	@Override
	public DTOIntCheck mapOutOznx(FormatoOZECNXS0 formatOutput) {
		DTOIntCheck dto = map(formatOutput, DTOIntCheck.class);
		if(EnumCheckStatus.getByCode(dto.getStatus()) != null) {
			dto.setStatus(EnumCheckStatus.getByCode(dto.getStatus()).name());
		}
		return dto;
	}
}

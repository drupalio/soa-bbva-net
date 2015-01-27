package com.bbva.czic.executives.dao.mapper.impl;

import com.bbva.czic.dto.net.Office;
import com.bbva.czic.executives.business.dto.DTOIntExecutive;
import com.bbva.czic.executives.business.dto.DTOIntExecutivesFilter;
import com.bbva.czic.executives.business.dto.DTOIntOffice;
import com.bbva.czic.executives.dao.mapper.TxExecutiveMapper;
import com.bbva.czic.executives.dao.model.oznr.FormatoOZECNRE0;
import com.bbva.czic.executives.dao.model.oznr.FormatoOZECNRS0;
import com.bbva.czic.routine.commons.rm.utils.converter.StringMoneyConverter;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaTxConfigurableMapper;
import com.bbva.czic.routine.commons.rm.utils.mappers.Mapper;
import com.bbva.czic.routine.mapper.MapperFactory;

@Mapper(value = "txExecutiveMapper")
public class TxExecutiveMapperImpl extends AbstractBbvaTxConfigurableMapper implements TxExecutiveMapper {

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
		// Map DTOIntFilter <-> FormatoOZNCENA0 (OZNA)
		factory.classMap(DTOIntExecutivesFilter.class, FormatoOZECNRE0.class).field("id", "idusuar").byDefault()
				.register();

		/**
		 * MAPEO DE SALIDAS
		 */
		// Map FormatoOZECNVS0 <-> DTOIntMonthlyBalances (OZNA)
		factory.classMap(DTOIntExecutive.class, FormatoOZECNRS0.class).field("executiveId", "idejecu").field("name", "nomejec")
				.field("phone", "telejec").field("office.name", "ofiejec")
				.field("email", "emailej").byDefault().register();

		// Map Office <-> DTOIntOffice
		factory.classMap(Office.class, DTOIntOffice.class).field("code", "code").field("name", "name")
				.field("postalAddress", "postalAddress").byDefault().register();



	}


	@Override
	public FormatoOZECNRE0 mapInOznr(DTOIntExecutivesFilter dtoIn) {
		return map(dtoIn, FormatoOZECNRE0.class);
	}

	@Override
	public DTOIntExecutive mapOutOznr(FormatoOZECNRS0 formatOutput) {
		return map(formatOutput, DTOIntExecutive.class);
	}

}
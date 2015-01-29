package com.bbva.czic.routine.commons.rm.utils.mappers;

import com.bbva.czic.routine.commons.rm.utils.EDateFormat;
import com.bbva.czic.routine.commons.rm.utils.converter.BigDecimalMoneyConverter;
import com.bbva.czic.routine.commons.rm.utils.converter.CalendarDateConverter;
import com.bbva.czic.routine.commons.rm.utils.converter.DateCalendarConverter;
import com.bbva.czic.routine.commons.rm.utils.converter.StringMoneyConverter;
import com.bbva.czic.routine.mapper.MapperFactory;
import com.bbva.czic.routine.mapper.converter.builtin.DateToStringConverter;
import com.bbva.czic.routine.mapper.impl.ConfigurableMapper;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

public abstract class AbstractBbvaTxConfigurableMapper extends ConfigurableMapper {

	protected static I18nLog log = I18nLogFactory.getLogI18n(AbstractBbvaTxConfigurableMapper.class,
			"META-INF/spring/i18n/log/mensajesLog");

	@Override
	protected void configure(MapperFactory factory) {

		// Add Converter
		factory.getConverterFactory().registerConverter(new CalendarDateConverter());

		/**
		 * Convert HOST FORMAT (+EEEEEEEEDD) to COP Money
		 */
		factory.getConverterFactory().registerConverter(new StringMoneyConverter());

		/**
		 * Convert HOST Date to Calendar DtoInt
		 */
		factory.getConverterFactory().registerConverter(new DateCalendarConverter());


		/**
		 * Convert HOST BigDecimal to Money
		 */
		factory.getConverterFactory().registerConverter(new BigDecimalMoneyConverter());
		/**
		 * Convert HOST Date to String
		 */
		factory.getConverterFactory().registerConverter(
				new DateToStringConverter(EDateFormat.ANIO_MES_DIA.getPattern()));

	}

}

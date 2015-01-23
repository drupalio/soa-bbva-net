package com.bbva.czic.routine.commons.rm.utils.mappers;

import com.bbva.czic.routine.commons.rm.utils.converter.CalendarConverter;
import com.bbva.czic.routine.mapper.MapperFactory;
import com.bbva.czic.routine.mapper.factory.MoneyFactory;
import com.bbva.czic.routine.mapper.impl.ConfigurableMapper;
import com.bbva.czic.routine.mapper.metadata.TypeFactory;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

public abstract class AbstractBbvaConfigurableMapper extends ConfigurableMapper {

	protected static I18nLog log = I18nLogFactory.getLogI18n(AbstractBbvaConfigurableMapper.class,
			"META-INF/spring/i18n/log/mensajesLog");

	@Override
	protected void configure(MapperFactory factory) {

		// Add Converter
		factory.getConverterFactory().registerConverter(new CalendarConverter());

		// Add Money Factory
		factory.registerObjectFactory(new MoneyFactory(), TypeFactory.<Money> valueOf(Money.class));

	}

}

package com.bbva.czic.routine.commons.rm.utils.mappers;

import com.bbva.czic.routine.commons.rm.utils.converter.GregorianCalendarConverter;
import com.bbva.czic.routine.mapper.factory.CalendarFactory;
import org.apache.commons.collections.CollectionUtils;
import org.apache.cxf.jaxrs.ext.search.ConditionType;
import org.apache.cxf.jaxrs.ext.search.PrimitiveStatement;
import org.apache.cxf.jaxrs.ext.search.SearchBean;
import org.apache.cxf.jaxrs.ext.search.SearchCondition;
import org.apache.cxf.jaxrs.ext.search.fiql.FiqlParser;

import com.bbva.czic.routine.commons.rm.utils.converter.CalendarDateConverter;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.fiql.FiqlUtils;
import com.bbva.czic.routine.commons.rm.utils.predicate.AbstractPredicate;
import com.bbva.czic.routine.mapper.MapperFactory;
import com.bbva.czic.routine.mapper.factory.MoneyFactory;
import com.bbva.czic.routine.mapper.impl.ConfigurableMapper;
import com.bbva.czic.routine.mapper.metadata.TypeFactory;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

import java.util.Calendar;

public abstract class AbstractBbvaConfigurableMapper extends ConfigurableMapper {

	protected static I18nLog log = I18nLogFactory.getLogI18n(AbstractBbvaConfigurableMapper.class,
			"META-INF/spring/i18n/log/mensajesLog");

	@Override
	protected void configure(MapperFactory factory) {

		// Add Converter
		factory.getConverterFactory().registerConverter(new CalendarDateConverter());

        // Add Calendar Converter to GregorianCalendar
		factory.getConverterFactory().registerConverter(new GregorianCalendarConverter());

		// Add Money Factory
		factory.registerObjectFactory(new MoneyFactory(), TypeFactory.<Money> valueOf(Money.class));

		// Add Calendar Factory
		factory.registerObjectFactory(new CalendarFactory(), TypeFactory.<Calendar> valueOf(Calendar.class));
	}

	/**
	 * 
	 */
	protected String getGeValue(String filter, final String propertyName) {
		return getValueFromCondiontType(filter, propertyName, ConditionType.GREATER_OR_EQUALS);
	}

	/**
	 * 
	 */
	protected String getLeValue(String filter, final String propertyName) {
		return getValueFromCondiontType(filter, propertyName, ConditionType.LESS_OR_EQUALS);
	}

	/**
	 * 
	 */
	protected String getGtValue(String filter, final String propertyName) {
		return getValueFromCondiontType(filter, propertyName, ConditionType.GREATER_THAN);
	}

	/**
	 * 
	 */
	protected String getLtValue(String filter, final String propertyName) {
		return getValueFromCondiontType(filter, propertyName, ConditionType.LESS_THAN);
	}

	/**
	 * 
	 */
	protected String getEqValue(String filter, final String propertyName) {
		return getValueFromCondiontType(filter, propertyName, ConditionType.EQUALS);
	}

	/**
	 * @param filter
	 * @param property
	 * @param conditionType
	 * @return
	 */
	private String getValueFromCondiontType(String filter, String property, ConditionType conditionType) {

		SearchCondition<SearchBean> sc = null;
		try {
			sc = new FiqlParser<SearchBean>(SearchBean.class).parse(filter);

			final PrimitiveStatement primitiveStatement = (PrimitiveStatement)CollectionUtils
					.select(FiqlUtils.getDataFromFilter(sc), new PrimitivePredicate(property, conditionType))
					.iterator().next();

			return primitiveStatement.getValue().toString();
		} catch (Exception e) {
			throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias());
		}

	}

	/**
	 * @author Entelgy
	 */
	private static class PrimitivePredicate extends AbstractPredicate<PrimitiveStatement> {

		private ConditionType conditionType;

		private String property;

		/**
		 * 
		 * @param property
		 * @param conditionType
		 */
		public PrimitivePredicate(final String property, final ConditionType conditionType) {
			this.conditionType = conditionType;
			this.property = property;
		}

		/**
		 * 
		 */
		@Override
		protected boolean eval(PrimitiveStatement primitive) {
			return (primitive.getCondition().equals(this.conditionType) && primitive.getProperty()
					.equals(this.property));
		}
	}

}

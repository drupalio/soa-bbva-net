package com.bbva.zic.cards.facade.v01.mapper.impl;

import com.bbva.zic.cards.business.dto.DTOIntCardCharge;
import com.bbva.zic.cards.business.dto.DTOIntFilterCards;
import com.bbva.zic.cards.facade.v01.mapper.ICardsMapper;
import com.bbva.zic.cards.facade.v01.mapper.converters.EnumCategoryConverter;
import com.bbva.zic.dto.net.*;
import com.bbva.zic.routine.commons.rm.utils.mappers.AbstractBbvaConfigurableMapper;
import com.bbva.zic.routine.commons.rm.utils.mappers.Mapper;
import com.bbva.zic.routine.mapper.MapperFactory;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Mapper(value = "cards-mapper")
public class CardsMapper extends AbstractBbvaConfigurableMapper implements ICardsMapper {

	private static I18nLog log = I18nLogFactory
			.getLogI18n(CardsMapper.class, "META-INF/spring/i18n/log/mensajesLog");

	final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	protected void configure(MapperFactory factory) {

		super.configure(factory);

		// Custom converters
		factory.getConverterFactory().registerConverter("enumCategoryConverter", new EnumCategoryConverter());

		// Map DTOIntCardCharge <-> CheckBook
		factory.classMap(DTOIntCardCharge.class, CardCharge.class)
				.fieldMap("category", "category").converter("enumCategoryConverter").add()
				.field("amount", "amount")
				.byDefault().register();


	}

	@Override
	public DTOIntFilterCards map(String id, String filter) {

		final String ge = this.getGeValue(filter, "chargeDate");
		final String le = this.getLeValue(filter, "chargeDate");

		DTOIntFilterCards dtoFilter = new DTOIntFilterCards();
		dtoFilter.setProductId(id);
		dtoFilter.setStartDate(ge);
		dtoFilter.setEndDate(le);

		return dtoFilter;
	}

	@Override
	public List<CardCharge> map(List<DTOIntCardCharge> charges) {
		return mapAsList(charges,CardCharge.class);
	}
}
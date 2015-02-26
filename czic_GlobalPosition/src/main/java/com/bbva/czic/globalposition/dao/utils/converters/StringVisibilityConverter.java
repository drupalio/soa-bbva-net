package com.bbva.czic.globalposition.dao.utils.converters;

import com.bbva.czic.routine.mapper.converter.BidirectionalConverter;
import com.bbva.czic.routine.mapper.metadata.Type;

/**
 * @author Entelgy Colombia.
 */
public class StringVisibilityConverter extends BidirectionalConverter<String, Boolean> {

	private static final String VISIBLE = "M";
	private static final String HIDDEN = "O";

	@Override
	public Boolean convertTo(String source, Type<Boolean> destinationType) {
		return VISIBLE.equalsIgnoreCase(source);
	}

	@Override
	public String convertFrom(Boolean source, Type<String> destinationType) {
		return (source) ? VISIBLE : HIDDEN;
	}

}


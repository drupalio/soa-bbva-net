package com.bbva.zic.globalposition.dao.utils.converters;

import com.bbva.zic.routine.mapper.converter.BidirectionalConverter;
import com.bbva.zic.routine.mapper.metadata.Type;
import org.mockito.Mock;

/**
 * @author Entelgy Colombia.
 */
public class StringOperabilityConverter extends BidirectionalConverter<String, Boolean>{

	private static final String BLOCKED = "B";
	public static final String UNBLOCKED = "U";

	@Override
	public Boolean convertTo(String source, Type<Boolean> destinationType) {
		return BLOCKED.equalsIgnoreCase(source.trim());
	}

	@Override
	public String convertFrom(Boolean source, Type<String> destinationType) {
		return (source) ? UNBLOCKED : BLOCKED;
	}

}

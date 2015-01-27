package com.bbva.czic.globalposition.dao.utils.converters;

import com.bbva.czic.routine.mapper.CustomConverter;
import com.bbva.czic.routine.mapper.metadata.Type;

/**
 * @author Entelgy Colombia.
 */
public class StringOperabilityConverter extends CustomConverter<String, Boolean> {
    private static final String BLOCKED = "B";

    @Override
    public Boolean convert(String source, Type<? extends Boolean> destinationType) {
        return !BLOCKED.equalsIgnoreCase(source);
    }
}

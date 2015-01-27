package com.bbva.czic.globalposition.dao.utils.converters;

import com.bbva.czic.routine.mapper.CustomConverter;
import com.bbva.czic.routine.mapper.metadata.Type;

/**
 * @author Entelgy Colombia.
 */
public class StringVisibilityConverter extends CustomConverter<String, Boolean> {

    private static final String VISIBLE = "C";

    @Override
    public Boolean convert(String source, Type<? extends Boolean> destinationType) {
        return VISIBLE.equalsIgnoreCase(source);
    }
}

package com.bbva.czic.routine.commons.rm.utils.converter;

import com.bbva.czic.dto.net.EnumMonth;
import com.bbva.czic.routine.mapper.converter.BidirectionalConverter;
import com.bbva.czic.routine.mapper.metadata.Type;

/**
 * @author Entelgy Colombia.
 */
public class MonthEnumConverter extends BidirectionalConverter<String, EnumMonth> {

    @Override
    public EnumMonth convertTo(String source, Type<EnumMonth> destinationType) {
        return EnumMonth.getByCode(source);
    }

    @Override
    public String convertFrom(EnumMonth source, Type<String> destinationType) {
        return source.getCode();
    }
}

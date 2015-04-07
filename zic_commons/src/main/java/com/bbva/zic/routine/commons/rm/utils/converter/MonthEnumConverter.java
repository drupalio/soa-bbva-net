package com.bbva.zic.routine.commons.rm.utils.converter;

import com.bbva.zic.dto.net.EnumMonth;
import com.bbva.zic.routine.mapper.converter.BidirectionalConverter;
import com.bbva.zic.routine.mapper.metadata.Type;

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

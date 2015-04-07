package com.bbva.zic.cards.facade.v01.mapper.converters;

import com.bbva.zic.dto.net.EnumCardChargeCategory;
import com.bbva.zic.routine.mapper.converter.BidirectionalConverter;
import com.bbva.zic.routine.mapper.metadata.Type;

/**
 * Created by Entelgy on 28/01/2015.
 */
public class EnumCategoryConverter extends BidirectionalConverter<String, EnumCardChargeCategory> {

    @Override
    public EnumCardChargeCategory convertTo(String source, Type<EnumCardChargeCategory> destinationType) {
        return EnumCardChargeCategory.fromString(source);
    }

    @Override
    public String convertFrom(EnumCardChargeCategory source, Type<String> destinationType) {
        return source.toString();
    }
}

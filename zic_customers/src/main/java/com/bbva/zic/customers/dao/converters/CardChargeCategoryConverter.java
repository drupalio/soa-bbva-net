package com.bbva.zic.customers.dao.converters;

import com.bbva.zic.dto.net.EnumCardChargeCategory;
import com.bbva.zic.routine.mapper.converter.BidirectionalConverter;
import com.bbva.zic.routine.mapper.metadata.Type;

/**
 * @author Entelgy Colombia.
 */
public class CardChargeCategoryConverter extends BidirectionalConverter<String, EnumCardChargeCategory> {
    @Override
    public EnumCardChargeCategory convertTo(String source, Type<EnumCardChargeCategory> destinationType) {
        return EnumCardChargeCategory.fromString(source);
    }

    @Override
    public String convertFrom(EnumCardChargeCategory source, Type<String> destinationType) {
        return source.name();
    }
}

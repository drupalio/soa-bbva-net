package com.bbva.czic.customers.dao.converters;

import com.bbva.czic.dto.net.EnumCardChargeCategory;
import com.bbva.czic.routine.mapper.converter.BidirectionalConverter;
import com.bbva.czic.routine.mapper.metadata.Type;

/**
 * @author Entelgy Colombia.
 */
public class CardChargeCategoryConverter extends BidirectionalConverter<String, EnumCardChargeCategory> {
    @Override
    public EnumCardChargeCategory convertTo(String source, Type<EnumCardChargeCategory> destinationType) {
        return EnumCardChargeCategory.valueOf(source);
    }

    @Override
    public String convertFrom(EnumCardChargeCategory source, Type<String> destinationType) {
        return source.name();
    }
}

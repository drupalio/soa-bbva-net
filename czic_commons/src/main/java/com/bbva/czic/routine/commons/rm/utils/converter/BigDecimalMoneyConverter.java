package com.bbva.czic.routine.commons.rm.utils.converter;

import com.bbva.czic.routine.commons.rm.utils.CurrencyEnum;
import com.bbva.czic.routine.mapper.CustomConverter;
import com.bbva.czic.routine.mapper.metadata.Type;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;

/**
 * Created by Entelgy on 27/01/2015.
 */
public class BigDecimalMoneyConverter extends CustomConverter<BigDecimal, Money> {
    @Override
    public Money convert(BigDecimal source, Type<? extends Money> destinationType) {
        final Money result = new Money();
        result.setCurrency(CurrencyEnum.COP.name());
        result.setAmount(source);

        return result;
    }
}

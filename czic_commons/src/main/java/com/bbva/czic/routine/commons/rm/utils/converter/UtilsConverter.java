package com.bbva.czic.routine.commons.rm.utils.converter;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by Entelgy on 11/01/2015.
 */
public class UtilsConverter {

    public static Money getMoneyDTO(BigDecimal amount){
        Money money = new Money();
        money.setCurrency(Currency.getInstance("COP").getCurrencyCode());
        money.setAmount(amount);
        return money;
    }
}

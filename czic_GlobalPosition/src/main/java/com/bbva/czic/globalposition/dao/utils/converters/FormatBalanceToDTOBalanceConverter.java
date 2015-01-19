package com.bbva.czic.globalposition.dao.utils.converters;

import com.bbva.czic.globalposition.business.dto.DTOIntBalance;
import com.bbva.czic.routine.commons.rm.utils.CurrencyEnum;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * @author Entelgy Colombia
 */
public class FormatBalanceToDTOBalanceConverter {

    @Value("locale.default.currency.iso")
    private String CURRENCY;

    @Value("currency.default.decimal.divider")
    private BigDecimal DECIMAL_DIVIDER;

    public DTOIntBalance convert(String totalBalance, String availableBalance) {
        final DTOIntBalance balance = new DTOIntBalance();

        if (totalBalance != null) {
            final Money totalMoney = new Money(
                    Currency.getInstance(CURRENCY),
                    new BigDecimal(totalBalance).divide(DECIMAL_DIVIDER));
            balance.setTotal(totalMoney);
        }

        if (availableBalance != null) {
            final Money availableMoney = new Money(
                    Currency.getInstance(CURRENCY),
                    new BigDecimal(availableBalance).divide(DECIMAL_DIVIDER));
            balance.setAvailableBalance(availableMoney);
        }

        return balance;
    }

}
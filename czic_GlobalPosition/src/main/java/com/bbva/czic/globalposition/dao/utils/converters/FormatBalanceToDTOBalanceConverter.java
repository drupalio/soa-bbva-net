package com.bbva.czic.globalposition.dao.utils.converters;

import com.bbva.czic.dto.net.Balance;
import com.bbva.czic.globalposition.business.dto.DTOIntBalance;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by Entelgy
 */
public class FormatBalanceToDTOBalanceConverter {

    public DTOIntBalance convert(String totalBalance, String availableBalance, String tradeBalance) {
        final DTOIntBalance balance = new DTOIntBalance();

        if (!totalBalance.equals(null)) {
            final Money totalMoney = new Money(
                    Currency.getInstance("COP"),
                    new BigDecimal(totalBalance));
            balance.setTotal(totalMoney);
        }

        if (!availableBalance.equals(null)) {
            final Money availableMoney = new Money(
                    Currency.getInstance("COP"),
                    new BigDecimal(availableBalance));
            balance.setAvailableBalance(availableMoney);
        }

        if (!tradeBalance.equals(null)) {
            final Money tradeMoney = new Money(
                    Currency.getInstance("COP"),
                    new BigDecimal(tradeBalance));
            balance.setTotal(tradeMoney);
        }

        return balance;
    }

}
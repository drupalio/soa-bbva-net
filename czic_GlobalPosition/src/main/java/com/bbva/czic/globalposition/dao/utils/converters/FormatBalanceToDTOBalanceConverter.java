package com.bbva.czic.globalposition.dao.utils.converters;

import com.bbva.czic.dto.net.Balance;
import com.bbva.czic.globalposition.business.dto.DTOIntBalance;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by Administrador on 05/01/2015.
 */
public class FormatBalanceToDTOBalanceConverter {

    public DTOIntBalance convert(String totalBalance, String availableBalance) {
        final Money totalMoney = new Money(
                Currency.getInstance("COP"),
                new BigDecimal(totalBalance));
        final Money availableMoney = new Money(
                Currency.getInstance("COP"),
                new BigDecimal(availableBalance));

        final DTOIntBalance balance = new DTOIntBalance();
        balance.setAvailableBalance(availableMoney);
        balance.setTotal(totalMoney);

        return balance;
    }

}
package com.bbva.czic.globalposition.business.dto;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;

import javax.validation.constraints.NotNull;

/**
 * @author Entelgy Colombia.
 */
public class DTOIntBalance {

    public final static long serialVersionUID = 1L;

    @NotNull
    private Money total;

    @NotNull
    private Money availableBalance;

    @NotNull
    private Money tradeBalance;

    public DTOIntBalance() {

    }

    public Money getTotal() {
        return total;
    }

    public void setTotal(Money total) {
        this.total = total;
    }

    public Money getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Money availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Money getTradeBalance() {
        return tradeBalance;
    }

    public void setTradeBalance(Money tradeBalance) {
        this.tradeBalance = tradeBalance;
    }
}
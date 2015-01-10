package com.bbva.czic.globalposition.business.dto;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;

/**
 * Created by Administrador on 05/01/2015.
 */
public class DTOIntBalance {

    public final static long serialVersionUID = 1L;

    private Money total;

    private Money availableBalance;

    private Money tradeBalance;

    public DTOIntBalance() {
        //default constructor
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

package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.bbva.jee.arq.spring.core.servicing.utils.MoneyAdapter;


import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Account", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Account", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Account
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @XmlJavaTypeAdapter(MoneyAdapter.class)
    @XmlElement(type = Money.class)
    @ApiModelProperty("Saldo en canje de una cuenta")
    private Money tradeBalance;
    @ApiModelProperty("Chequeras asociadas a la cuenta")
    private List<CheckbookTest> checkbooks;

    public Account() {
        //default constructor
    }

    public Money getTradeBalance() {
        return tradeBalance;
    }

    public void setTradeBalance(Money tradeBalance) {
        this.tradeBalance = tradeBalance;
    }

    public List<CheckbookTest> getCheckbooks() {
        return checkbooks;
    }

    public void setCheckbooks(List<CheckbookTest> checkbooks) {
        this.checkbooks = checkbooks;
    }

}

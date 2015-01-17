
package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import com.bbva.jee.arq.spring.core.servicing.utils.MoneyAdapter;
import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "MonthlyBalances", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "MonthlyBalances", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class MonthlyBalances
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @XmlJavaTypeAdapter(MoneyAdapter.class)
    @XmlElement(type = Money.class)
    @ApiModelProperty("saldo consolidado del mes")
    private Money balance;
    @ApiModelProperty("mes de evaluacion para el saldo")
    private EnumMonth month;

    public MonthlyBalances() {
        //default constructor
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

	public EnumMonth getMonth() {
		return month;
	}

	public void setMonth(EnumMonth month) {
		this.month = month;
	}

    

}


package com.bbva.czic.accounts.facade.v01.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.bbva.jee.arq.spring.core.servicing.utils.MoneyAdapter;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "accMovementsResume", namespace = "urn:com:bbva:czic:accounts:facade:v01:dto")
@XmlType(name = "accMovementsResume", namespace = "urn:com:bbva:czic:accounts:facade:v01:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccMovementsResume<EnumMonth>
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @XmlJavaTypeAdapter(MoneyAdapter.class)
    @XmlElement(type = Money.class)
    @ApiModelProperty("Ingresos a la cuenta")
    private Money income;
    @XmlJavaTypeAdapter(MoneyAdapter.class)
    @XmlElement(type = Money.class)
    @ApiModelProperty("Egresos de la cuenta")
    private Money outcome;
    @XmlJavaTypeAdapter(MoneyAdapter.class)
    @XmlElement(type = Money.class)
    @ApiModelProperty("Saldo de la cuenta")
    private Money balance;
    @ApiModelProperty(value = "Mes en el cual se calculan los valores del resumen", required = true)
    private EnumMonth month;

    public AccMovementsResume() {
        //default constructor
    }

    public Money getIncome() {
        return income;
    }

    public void setIncome(Money income) {
        this.income = income;
    }

    public Money getOutcome() {
        return outcome;
    }

    public void setOutcome(Money outcome) {
        this.outcome = outcome;
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

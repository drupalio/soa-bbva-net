
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

@XmlRootElement(name = "ElectronicDespositValue", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "ElectronicDespositValue", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class ElectronicDespositValue
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @XmlJavaTypeAdapter(MoneyAdapter.class)
    @XmlElement(type = Money.class)
    @ApiModelProperty(value = "saldo total que se dispone para el usuario", required = true)
    @NotNull
    private Money overallInvestment;
    @ApiModelProperty(value = "Mes sobre el cual se hace el analisis o evaluo", required = true)
    @NotNull
    private EnumMonth month;

    public ElectronicDespositValue() {
        //default constructor
    }

    public Money getOverallInvestment() {
        return overallInvestment;
    }

    public void setOverallInvestment(Money overallInvestment) {
        this.overallInvestment = overallInvestment;
    }

	public EnumMonth getMonth() {
		return month;
	}

	public void setMonth(EnumMonth month) {
		this.month = month;
	}

}

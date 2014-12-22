
package com.bbva.czic.dto.net;

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

@XmlRootElement(name = "CardCharge", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "CardCharge", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class CardCharge
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty(value = "Aspecto comercial", required = true)
    private EnumCardChargeCategory category;
    @XmlJavaTypeAdapter(MoneyAdapter.class)
    @XmlElement(type = Money.class)
    @ApiModelProperty("Valor del consumo total diferido a cada una de las categorias")
    private Money amount;

    public CardCharge() {
        //default constructor
    }

    public EnumCardChargeCategory getCategory() {
        return category;
    }

    public void setCategory(EnumCardChargeCategory category) {
        this.category = category;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

}

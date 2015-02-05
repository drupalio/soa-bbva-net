
package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.bbva.jee.arq.spring.core.servicing.utils.CalendarAdapter;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import com.bbva.jee.arq.spring.core.servicing.utils.MoneyAdapter;
import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Payment", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Payment", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Payment
    implements Serializable
{

    public final static long serialVersionUID = 1L;
   // @XmlJavaTypeAdapter(CalendarAdapter.class)
    //@XmlSchemaType(name = "dateTime")
    @ApiModelProperty("Fecha de vencimiento del pago")
    private String dueDate;
    //@XmlJavaTypeAdapter(CalendarAdapter.class)
    //@XmlSchemaType(name = "dateTime")
    @ApiModelProperty("Fecha de pago")
    private String paymentDate;
    //@XmlJavaTypeAdapter(CalendarAdapter.class)
    //@XmlSchemaType(name = "dateTime")
    @ApiModelProperty("Fecha de corte del producto")
    private String shortDate;
   // @XmlJavaTypeAdapter(MoneyAdapter.class)
    @XmlElement(type = Money.class)
    @ApiModelProperty("Honorarios del pago")
    private Money fees;
  //  @XmlJavaTypeAdapter(MoneyAdapter.class)
    @XmlElement(type = Money.class)
    @ApiModelProperty("Pago minimo")
    private Money minimumPayment;
    @ApiModelProperty("Numero de cuotas")
    @Min(0)
    private Integer numbersOfQuota;

    public Payment() {
        //default constructor
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getShortDate() {
        return shortDate;
    }

    public void setShortDate(String shortDate) {
        this.shortDate = shortDate;
    }

    public Money getFees() {
        return fees;
    }

    public void setFees(Money fees) {
        this.fees = fees;
    }

    public Money getMinimumPayment() {
        return minimumPayment;
    }

    public void setMinimumPayment(Money minimumPayment) {
        this.minimumPayment = minimumPayment;
    }

    public Integer getNumbersOfQuota() {
        return numbersOfQuota;
    }

    public void setNumbersOfQuota(Integer numbersOfQuota) {
        this.numbersOfQuota = numbersOfQuota;
    }

}

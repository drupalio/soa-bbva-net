
package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


import com.bbva.jee.arq.spring.core.servicing.utils.CalendarAdapter;
import com.bbva.jee.arq.spring.core.servicing.utils.MoneyAdapter;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Payment", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Payment", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Payment
    implements Serializable
{

    public final static long serialVersionUID = 1L;
//    @XmlJavaTypeAdapter(CalendarAdapter.class)
    @XmlSchemaType(name = "dateTime")
    @ApiModelProperty("Fecha de vencimiento del pago")
    private Calendar dueDate;
//    @XmlJavaTypeAdapter(CalendarAdapter.class)
    @XmlSchemaType(name = "dateTime")
    @ApiModelProperty("Fecha de pago")
    private Calendar paymentDate;
//    @XmlJavaTypeAdapter(CalendarAdapter.class)
    @XmlSchemaType(name = "dateTime")
    @ApiModelProperty("Fecha corta del pago")
    private Date shortDate;
    @XmlJavaTypeAdapter(MoneyAdapter.class)
    @XmlElement(type = Money.class)
    @ApiModelProperty("Honorarios del pago")
    private Money fees;
    @XmlJavaTypeAdapter(MoneyAdapter.class)
    @XmlElement(type = Money.class)
    @ApiModelProperty("Pago minimo")
    private Money minimumPayment;
    @ApiModelProperty("Numero de cuotas")
    private Integer numbersOfQuota;

    public Payment() {
        //default constructor
    }

    public Calendar getDueDate() {
        return dueDate;
    }

    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
    }

    public Calendar getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Calendar paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getShortDate() {
        return shortDate;
    }

    public void setShortDate(Date shortDate) {
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


package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.Calendar;
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

@XmlRootElement(name = "movement", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "movement", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Movement
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty(value = "Identificador de la operacion", required = true)
    private String id;
    @ApiModelProperty(value = "concepto de la operacion", required = true)
    private String concept;

    @XmlJavaTypeAdapter(CalendarAdapter.class)
    //@XmlSchemaType(name = "dateTime")
    @ApiModelProperty("")
    private Calendar transactionDate;

    @ApiModelProperty("")
    private String sourceReference;

    @ApiModelProperty("")
    private String destinationReference;

    @ApiModelProperty("")
    private Operation operation;

    @XmlJavaTypeAdapter(MoneyAdapter.class)
    @XmlElement(type = Money.class)
    @ApiModelProperty("")
    private Money value;
    @XmlJavaTypeAdapter(MoneyAdapter.class)
    @XmlElement(type = Money.class)
    @ApiModelProperty("")
    private Money balance;

    public Movement() {
        //default constructor
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public Calendar getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Calendar transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getSourceReference() {
        return sourceReference;
    }

    public void setSourceReference(String sourceReference) {
        this.sourceReference = sourceReference;
    }

    public String getDestinationReference() {
        return destinationReference;
    }

    public void setDestinationReference(String destinationReference) {
        this.destinationReference = destinationReference;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Money getValue() {
        return value;
    }

    public void setValue(Money value) {
        this.value = value;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

}


package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.bbva.jee.arq.spring.core.servicing.utils.MoneyAdapter;


import com.bbva.jee.arq.spring.core.servicing.utils.CalendarAdapter;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Check", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Check", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Check
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty(value = "Identificador del cheque", required = true)
    private String id;
    @XmlJavaTypeAdapter(CalendarAdapter.class)
    @XmlSchemaType(name = "dateTime")
    @ApiModelProperty(value = "description", required = true)
    private Date issueDate;
    @XmlJavaTypeAdapter(MoneyAdapter.class)
    @XmlElement(type = Money.class)
    @ApiModelProperty(value = "Valor del cheque", required = true)
    private Money value;
    @ApiModelProperty(value = "Estado actual del cheque", required = true)
    private EnumCheckStatus status;
    @XmlJavaTypeAdapter(CalendarAdapter.class)
    @XmlSchemaType(name = "dateTime")
    @ApiModelProperty(value = "Fecha de modificacion", required = true)
    private Date modifiedDate;

    public Check() {
        //default constructor
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Money getValue() {
        return value;
    }

    public void setValue(Money value) {
        this.value = value;
    }

    public EnumCheckStatus getStatus() {
        return status;
    }

    public void setStatus(EnumCheckStatus status) {
        this.status = status;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

}


package com.bbva.czic.accounts.facade.v01.dto;

import com.bbva.czic.dto.net.EnumCheckStatus;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import com.bbva.jee.arq.spring.core.servicing.utils.MoneyAdapter;
import com.wordnik.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;

@XmlRootElement(name = "check", namespace = "urn:com:bbva:czic:accounts:facade:v01:dto")
@XmlType(name = "check", namespace = "urn:com:bbva:czic:accounts:facade:v01:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class listCheck<EnumcheckStatus>
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty("Identificador del cheque")
    private String id;
    @ApiModelProperty("Fecha emision del cheque")
    public Date issueDate;
    @XmlJavaTypeAdapter(MoneyAdapter.class)
    @XmlElement(type = Money.class)
    @ApiModelProperty("Valor total del cheque")
    private Money value;
    @ApiModelProperty(value = "Estado actual del cheque", required = true)
    private EnumCheckStatus status;

    public listCheck() {
        //default constructor
    }

    public String id() {
        return id;
    }

    public void setid(String id) {  this.id = id;
    }

    public Date getissueDate() {
        return issueDate;
    }

    public void setissueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Money getvalue() {
        return value;
    }

    public void setvalue(Money value) {
        this.value = value;
    }

    public EnumCheckStatus getstatus() {
        return status;
    }

    public void setstatus(EnumCheckStatus status) {
        this.status = status;
    }

}

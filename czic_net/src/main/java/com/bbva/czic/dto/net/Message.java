
package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.hibernate.validator.constraints.NotBlank;

import com.bbva.jee.arq.spring.core.servicing.utils.CalendarAdapter;
import com.bbva.jee.arq.spring.core.servicing.utils.MoneyAdapter;


import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Message", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Message", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Message
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty("Identificador del mensaje")
    private String id;
    @ApiModelProperty(value = "Titulo del mensaje", required = true)
    private String title;
    @ApiModelProperty(value = "Plantilla del mensaje", required = true)
    private String template;
    @ApiModelProperty(value = "Tipo de mensaje", required = true)
    private EnumMessageType reference;
    @XmlSchemaType(name = "dateTime")
    @ApiModelProperty("Tiempo de mensaje")
    private Calendar time;
    @XmlJavaTypeAdapter(MoneyAdapter.class)
    @XmlElement(type = Money.class)
    @ApiModelProperty("Valor de mensaje")
    private Money value;
    @ApiModelProperty("Descripcion del mensaje")
    private String info;

    public Message() {
        //default constructor
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public EnumMessageType getReference() {
        return reference;
    }

    public void setReference(EnumMessageType reference) {
        this.reference = reference;
    }

    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }

    public Money getValue() {
        return value;
    }

    public void setValue(Money value) {
        this.value = value;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}

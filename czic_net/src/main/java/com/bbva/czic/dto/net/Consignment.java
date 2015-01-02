
package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.bbva.jee.arq.spring.core.servicing.utils.CalendarAdapter;


import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Consignment", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Consignment", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Consignment
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty(value = "Numero de la consignacion", required = true)
    private String number;
    @ApiModelProperty(value = "Campo alfab\u00e9tico que identifica la forma como se realiza la consignacion", required = true)
    private EnumConsignmentType type;
//    @XmlJavaTypeAdapter(CalendarAdapter.class)
    @XmlSchemaType(name = "dateTime")
    @ApiModelProperty(value = "Fecha de la consignacion", required = true)
    private Calendar date;

    public Consignment() {
        //default constructor
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public EnumConsignmentType getType() {
        return type;
    }

    public void setType(EnumConsignmentType type) {
        this.type = type;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
}

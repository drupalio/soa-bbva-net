
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

@XmlRootElement(name = "Conditions", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Conditions", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Conditions
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty(value = "Tipo de plan asociado al producto", required = true)
    private String category;
    @ApiModelProperty("Descripcion del tipo de producto")
    private String description;
//    @XmlJavaTypeAdapter(CalendarAdapter.class)
    @XmlSchemaType(name = "dateTime")
    @ApiModelProperty(value = " Fecha en la que se realizo la apertura del producto", required = true)
    private Calendar openingDate;
    @ApiModelProperty(value = "Tipo de comision que aplica para el producto", required = true)
    private String commission;
    @ApiModelProperty(value = "Datos de la oficina donde se realizo la apertura del producto", required = true)
    private Office office;
    @ApiModelProperty("")
    private String mobilizationConditions;

    public Conditions() {
        //default constructor
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Calendar openingDate) {
        this.openingDate = openingDate;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public String getMobilizationConditions() {
        return mobilizationConditions;
    }

    public void setMobilizationConditions(String mobilizationConditions) {
        this.mobilizationConditions = mobilizationConditions;
    }

}

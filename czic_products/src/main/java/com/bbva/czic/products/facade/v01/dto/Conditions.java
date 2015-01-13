
package com.bbva.czic.products.facade.v01.dto;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.bbva.czic.dto.net.Activity;
import com.bbva.czic.dto.net.Office;
import com.bbva.jee.arq.spring.core.servicing.utils.CalendarAdapter;


import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Conditions", namespace = "urn:com:bbva:czic:products:facade:v01:dto")
@XmlType(name = "Conditions", namespace = "urn:com:bbva:czic:products:facade:v01:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Conditions
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty(value = "Alias asociado al titular de la cuenta", required = true)
    private String alias;
    @ApiModelProperty(value = "Tipo de plan asociado al producto", required = true)
    private String category;
    @ApiModelProperty("Descripcion del tipo de producto")
    private String description;
    @XmlJavaTypeAdapter(CalendarAdapter.class)
    @XmlSchemaType(name = "dateTime")
    @ApiModelProperty(value = " Fecha en la que se realizo la apertura del producto", required = true)
    private Date openingDate;
    @ApiModelProperty(value = "Tipo de comision que aplica para el producto", required = true)
    private String commission;
    @ApiModelProperty("")
    private Office office;
    @ApiModelProperty("Condiciones de movilizacion")
    private String mobilizationConditions;
    @ApiModelProperty("")
    private Activity activities;

    public Conditions() {
        //default constructor
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
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

    public Activity getActivities() {
        return activities;
    }

    public void setActivities(Activity activities) {
        this.activities = activities;
    }

}


package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Product", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Product", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty(value = "Identificador del usuario ejecutivo de ventas", required = true)
    private String id;
    @ApiModelProperty(value = "", required = true)
    private EnumProductType type;
    @ApiModelProperty(value = "Nombre del producto", required = true)
    private String name;
    @ApiModelProperty("Alias del producto")
    private String alias;
    @ApiModelProperty(value = "Identificador que referencia si un producto es un activo o un pasivo", required = true)
    private EnumFinancialStatusType financialState;
    @ApiModelProperty(value = "Visibilidad del producto", required = true)
    private Boolean visible;
    @ApiModelProperty(value = "Operatibilidad del producto", required = true)
    private Boolean operable;
    @ApiModelProperty(value = "Entidad con toda la informaci\u00f3n del balance de la cuenta", required = true)
    private Balance balance;
    @ApiModelProperty(value = "description", required = true)
    private ContactInfo contactInfo;
    @ApiModelProperty("")
    private Conditions conditions;
    @ApiModelProperty("")
    private List<Movement> movement;

    public Product() {
        //default constructor
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnumProductType getType() {
        return type;
    }

    public void setType(EnumProductType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public EnumFinancialStatusType getFinancialState() {
        return financialState;
    }

    public void setFinancialState(EnumFinancialStatusType financialState) {
        this.financialState = financialState;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getOperable() {
        return operable;
    }

    public void setOperable(Boolean operable) {
        this.operable = operable;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Conditions getConditions() {
        return conditions;
    }

    public void setConditions(Conditions conditions) {
        this.conditions = conditions;
    }

    public List<Movement> getMovement() {
        return movement;
    }

    public void setMovement(List<Movement> movement) {
        this.movement = movement;
    }

}

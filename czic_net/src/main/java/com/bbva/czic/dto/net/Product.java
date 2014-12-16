
package com.bbva.czic.dto.net;

import com.wordnik.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "product", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "product", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product
    implements Serializable
{

    public final static long serialVersionUID = 1L;

    @ApiModelProperty(value = "Identificador del producto", required = true)
    private String productId;

    @ApiModelProperty("")
    private EnumProductType type;

    @ApiModelProperty("")
    private String name;

    @ApiModelProperty("")
    private String alias;

    @ApiModelProperty("")
    private EnumFinancialStatusType financialState;

    @ApiModelProperty("")
    private Boolean visible;

    @ApiModelProperty("")
    private Boolean operable;

    @ApiModelProperty("")
    private Balance balance;

    @ApiModelProperty("")
    private ContactInformation contactInfo;

    @ApiModelProperty("")
    private List<Movement> movements;

    public Product() {
        //default constructor
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    public ContactInformation getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInformation contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<Movement> getMovements() {
        return movements;
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }
}

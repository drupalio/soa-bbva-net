
package com.bbva.zic.dto.net;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "ThirdParty", namespace = "urn:com:bbva:zic:dto:net")
@XmlType(name = "ThirdParty", namespace = "urn:com:bbva:zic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class ThirdParty
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty("Identificador del tercero")
    private User customerId;
    @ApiModelProperty(value = "Tipo de tercero: (CUSTOMER, LEAD, AGGREGATE)", required = true)
    private EnumThirdPartyType type;

    public ThirdParty() {
        //default constructor
    }

    public User getCustomerId() {
        return customerId;
    }

    public void setCustomerId(User customerId) {
        this.customerId = customerId;
    }

    public EnumThirdPartyType getType() {
        return type;
    }

    public void setType(EnumThirdPartyType type) {
        this.type = type;
    }

}

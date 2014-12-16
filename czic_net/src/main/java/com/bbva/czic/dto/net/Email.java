
package com.bbva.czic.dto.net;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "email", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "email", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Email
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty("")
    private String address;
    @ApiModelProperty("")
    private Boolean primary;
    @ApiModelProperty("")
    private Boolean active;
    @ApiModelProperty("")
    private EnumContactSourceType source;

    public Email() {
        //default constructor
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public EnumContactSourceType getSource() {
        return source;
    }

    public void setSource(EnumContactSourceType source) {
        this.source = source;
    }

}


package com.bbva.czic.products.facade.v01.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "EnumProductType", namespace = "urn:com:bbva:czic:products:facade:v01:dto")
@XmlType(name = "EnumProductType", namespace = "urn:com:bbva:czic:products:facade:v01:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class EnumProductType
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty("")
    private String AC;
    @ApiModelProperty("")
    private String CA;
    @ApiModelProperty("")
    private String LO;
    @ApiModelProperty("")
    private String SI;

    public EnumProductType() {
        //default constructor
    }

    public String getAC() {
        return AC;
    }

    public void setAC(String AC) {
        this.AC = AC;
    }

    public String getCA() {
        return CA;
    }

    public void setCA(String CA) {
        this.CA = CA;
    }

    public String getLO() {
        return LO;
    }

    public void setLO(String LO) {
        this.LO = LO;
    }

    public String getSI() {
        return SI;
    }

    public void setSI(String SI) {
        this.SI = SI;
    }

}

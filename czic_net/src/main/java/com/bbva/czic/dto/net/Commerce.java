
package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.validator.constraints.NotBlank;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Commerce", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Commerce", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Commerce
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty(value = "Red a la que pertenece el comercio", required = true)
    private EnumNetType net;
    @ApiModelProperty(value = "C\u00f3digo \u00fanico de comercio de 10 posiciones", required = true)
    private String code;
    @ApiModelProperty(value = "Nombre del establecimiento o comercio", required = true)
    private String name;
    @ApiModelProperty(value = " Ciudad donde esta el establecimiento o comercio", required = true)
    private City city;

    public Commerce() {
        //default constructor
    }

    public EnumNetType getNet() {
        return net;
    }

    public void setNet(EnumNetType net) {
        this.net = net;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}

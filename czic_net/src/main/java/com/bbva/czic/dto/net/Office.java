
package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;




import org.hibernate.validator.constraints.NotBlank;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Office", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Office", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Office
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty(value = "Codigo del corresponsal financiero", required = true)
    private String code;
    @ApiModelProperty(value = "Nombre del corresponsal financiero", required = true)
    private String name;
    @ApiModelProperty("Informacion de la ubicacion de un origen")
    private Location location;
    @ApiModelProperty(value = "Direccion postal de la oficina donde se realizo la apertura del producto", required = true)
    private String postalAddress;

    public Office() {
        //default constructor
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

}


package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Excecutive", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Excecutive", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Excecutive
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty(value = "  Identificador del ejecutivo de cuenta", required = true)
    private String id;
    @ApiModelProperty("Nombre del ejecutivo de cuenta")
    private String name;
    @ApiModelProperty("Telefono del ejecutivo de cuenta")
    private String phone;
    @ApiModelProperty("Oficina a la cual esta asignado un ejecutivo de cuenta")
    private Office office;
    @ApiModelProperty("Correo electronico de un ejecutivo de cuenta")
    private String email;
    @ApiModelProperty("Clientes que tiene asignado un ejecutivo de cuenta")
    private List<User> customer;

    public Excecutive() {
        //default constructor
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<User> getCustomer() {
        return customer;
    }

    public void setCustomer(List<User> customer) {
        this.customer = customer;
    }

}

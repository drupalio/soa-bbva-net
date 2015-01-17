
package com.bbva.czic.dto.net;

import com.wordnik.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "Executive", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Executive", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Executive
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
    @Email
    private String email;
    @ApiModelProperty("Clientes que tiene asignado un ejecutivo de cuenta")
    private List<ThirdParty> customer;

    public Executive() {
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

    /*public Email getEmail() {
            return email;
        }

        public void setEmail(Email email) {
            this.email = email;
        }
    */
    public List<ThirdParty> getCustomer() {
        return customer;
    }

    public void setCustomer(List<ThirdParty> customer) {
        this.customer = customer;
    }

}

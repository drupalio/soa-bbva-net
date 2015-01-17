
package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.validator.constraints.NotBlank;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "User", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "User", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class User
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty(value = "Identificador del usuario", required = true)
    private String customerId;
    @ApiModelProperty("Nombre del usuario")
    private String name;
    @ApiModelProperty("Identificador de la informacion del contacto")
    private ContactInfo contactInfo;
    @ApiModelProperty("Entidad con toda la informaci\u00f3n del ejecutivo de ventas")
    private Executive salesExecutive;
    @XmlSchemaType(name = "dateTime")
    @ApiModelProperty("Fecha de la \u00faltima vez que accedi\u00f3 el usuario al portal")
    @Past
    private Calendar lastAccessDate;
    @ApiModelProperty("Arreglo de los mensajes de alerta generados para el usuario")
    private List<Message> message;
    @ApiModelProperty("Arreglo de los productos correspondientes al usuario")
    private List<Product> products;

    public User() {
        //default constructor
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public Executive getSalesExecutive() {
		return salesExecutive;
	}

	public void setSalesExecutive(Executive salesExecutive) {
		this.salesExecutive = salesExecutive;
	}

	public Calendar getLastAccessDate() {
        return lastAccessDate;
    }

    public void setLastAccessDate(Calendar lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}

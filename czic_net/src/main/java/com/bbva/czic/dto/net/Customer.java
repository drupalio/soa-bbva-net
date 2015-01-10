
package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Customer", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Customer", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty(value = "docmento del cliente", required = true)
    private Document document;
    @ApiModelProperty("Nombre del cliente")
    private String name;
    @ApiModelProperty("Identificador de la informacion del contacto")
    private ContactInfo contactInfo;
    @ApiModelProperty("Ubicacion de la casa")
    private Location homeLocation;
    @ApiModelProperty("Estrato del cliente")
    private Integer stratum;
    @ApiModelProperty("Años de residencia en la ciudad")
    private Integer residenceYears;
    @ApiModelProperty("Miembros del hogar")
    private Integer homeMembers;
    @ApiModelProperty("Estrato del cliente")
    private EnumDwelingType dwelingType;
    @ApiModelProperty("Ubicacion de la oficina")
    private Location officeLocation;
    @XmlSchemaType(name = "dateTime")
    @ApiModelProperty("Fecha de última conexión del cliente")
    private Calendar lastConnectionTime;
    

    public Customer() {
        //default constructor
    }


	public Document getDocument() {
		return document;
	}


	public void setDocument(Document document) {
		this.document = document;
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


	public Location getHomeLocation() {
		return homeLocation;
	}


	public void setHomeLocation(Location homeLocation) {
		this.homeLocation = homeLocation;
	}


	public Integer getStratum() {
		return stratum;
	}


	public void setStratum(Integer stratum) {
		this.stratum = stratum;
	}


	public Integer getResidenceYears() {
		return residenceYears;
	}


	public void setResidenceYears(Integer residenceYears) {
		this.residenceYears = residenceYears;
	}


	public Integer getHomeMembers() {
		return homeMembers;
	}


	public void setHomeMembers(Integer homeMembers) {
		this.homeMembers = homeMembers;
	}


	public EnumDwelingType getDwelingType() {
		return dwelingType;
	}


	public void setDwelingType(EnumDwelingType dwelingType) {
		this.dwelingType = dwelingType;
	}


	public Location getOfficeLocation() {
		return officeLocation;
	}


	public void setOfficeLocation(Location officeLocation) {
		this.officeLocation = officeLocation;
	}


	public Calendar getLastConnectionTime() {
		return lastConnectionTime;
	}


	public void setLastConnectionTime(Calendar lastConnectionTime) {
		this.lastConnectionTime = lastConnectionTime;
	}

    

}

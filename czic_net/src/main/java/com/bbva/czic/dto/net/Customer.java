package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.Calendar;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.bbva.jee.arq.spring.core.servicing.utils.CalendarAdapter;
import org.hibernate.validator.constraints.NotBlank;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Customer", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Customer", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer implements Serializable {

	public final static long serialVersionUID = 1L;
	@ApiModelProperty(value = "documento del cliente", required = true)
	private String id;
	@ApiModelProperty(value = "documento del cliente", required = true)
	private Document document;
	@ApiModelProperty("Nombre de usuario del cliente")
	private String username;
	@ApiModelProperty("Nombre del cliente")
	private String name;
	@ApiModelProperty("Segmento del cliente")
	private EnumSegmentType segment;
	@ApiModelProperty("Información de contacto que contiene los emails del cliente")
	private ContactInfo contactInfo;
	@ApiModelProperty("Ubicacion de la casa")
	private Place homeLocation;
	@ApiModelProperty("Estrato del cliente")
	@Min(0)
	private Integer stratum;
	@ApiModelProperty("Años de residencia en la ciudad")
	@Min(0)
	private Integer residenceYears;
	@ApiModelProperty("Miembros del hogar")
	@Min(0)
	private Integer homeMembers;
	@ApiModelProperty("Estrato del cliente")
	private EnumDwelingType dwelingType;
	@ApiModelProperty("Ubicacion de la oficina")
	private Place officeLocation;
	@XmlJavaTypeAdapter(CalendarAdapter.class)
	@ApiModelProperty("Fecha de último acceso")
	private Calendar lastAccessDate;

	public Customer() {
		// default constructor
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EnumSegmentType getSegment() {
		return segment;
	}

	public void setSegment(EnumSegmentType segment) {
		this.segment = segment;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public Place getHomeLocation() {
		return homeLocation;
	}

	public void setHomeLocation(Place homeLocation) {
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

	public Place getOfficeLocation() {
		return officeLocation;
	}

	public void setOfficeLocation(Place officeLocation) {
		this.officeLocation = officeLocation;
	}

	public Calendar getLastAccessDate() {
		return lastAccessDate;
	}

	public void setLastAccessDate(Calendar lastAccessDate) {
		this.lastAccessDate = lastAccessDate;
	}

}

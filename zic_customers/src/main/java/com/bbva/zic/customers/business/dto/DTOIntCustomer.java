
package com.bbva.zic.customers.business.dto;

import com.bbva.zic.dto.net.ContactInfo;
import com.bbva.zic.dto.net.Document;
import com.bbva.zic.dto.net.Place;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class DTOIntCustomer {

    public final static long serialVersionUID = 1L;

	private String id;
	private Document document;
	private String username;
	private String name;
	private String segment;
	private ContactInfo emails= new ContactInfo();
	private Place homeLocation;
	private Integer stratum;
	private Integer residenceYears;
	private Integer homeMembers;
	private String dwelingType;
	private Place officeLocation;
	private String lastAccessDate;

    public DTOIntCustomer() {
        //default constructor
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

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public ContactInfo getEmails() {
		return emails;
	}

	public void setEmails(ContactInfo emails) {
		this.emails = emails;
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

	public String getDwelingType() {
		return dwelingType;
	}

	public void setDwelingType(String dwelingType) {
		this.dwelingType = dwelingType;
	}

	public Place getOfficeLocation() {
		return officeLocation;
	}

	public void setOfficeLocation(Place officeLocation) {
		this.officeLocation = officeLocation;
	}

	public String getLastConnectionTime() {
		return lastAccessDate;
	}

	public void setLastConnectionTime(String lastConnectionTime) {
		this.lastAccessDate = lastConnectionTime;
	}

}

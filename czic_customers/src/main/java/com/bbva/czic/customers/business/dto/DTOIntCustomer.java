
package com.bbva.czic.customers.business.dto;

import java.util.Calendar;

import com.bbva.czic.dto.net.ContactInfo;
import com.bbva.czic.dto.net.Document;
import com.bbva.czic.dto.net.EnumDwelingType;
import com.bbva.czic.dto.net.EnumSegmentType;
import com.bbva.czic.dto.net.Place;




public class DTOIntCustomer {

    public final static long serialVersionUID = 1L;

	private String id;
	private Document document;
	private String username;
	private String name;
	private EnumSegmentType segment;
	private ContactInfo emails= new ContactInfo();
	private Place homeLocation;
	private Integer stratum;
	private Integer residenceYears;
	private Integer homeMembers;
	private EnumDwelingType dwelingType;
	private Place officeLocation;
	private Calendar lastConnectionTime;

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

	public EnumSegmentType getSegment() {
		return segment;
	}

	public void setSegment(EnumSegmentType segment) {
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

	public Calendar getLastConnectionTime() {
		return lastConnectionTime;
	}

	public void setLastConnectionTime(Calendar lastConnectionTime) {
		this.lastConnectionTime = lastConnectionTime;
	}

}

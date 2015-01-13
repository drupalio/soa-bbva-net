
package com.bbva.czic.customers.business.dto;

import java.util.Calendar;

import com.bbva.czic.dto.net.ContactInfo;
import com.bbva.czic.dto.net.Document;
import com.bbva.czic.dto.net.EnumDwelingType;
import com.bbva.czic.dto.net.Location;




public class DTOIntCustomer {

    public final static long serialVersionUID = 1L;

    private Document document;
	private String name;
	private ContactInfo contactInfo;
	private Location homeLocation;
	private Integer stratum;
	private Integer residenceYears;
	private Integer homeMembers;
	private EnumDwelingType dwelingType;
	private Location officeLocation;
	private Calendar lastConnectionTime;

    public DTOIntCustomer() {
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

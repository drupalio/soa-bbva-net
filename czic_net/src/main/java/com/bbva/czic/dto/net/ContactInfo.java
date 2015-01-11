package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "ContactInfo", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "ContactInfo", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContactInfo implements Serializable {

	public final static long serialVersionUID = 1L;
	@ApiModelProperty(" Listado de numeros de telefono del usuario")
	@NotNull
	private List<PhoneNumber> phoneNumbers;
	@ApiModelProperty("Listado de mails del usuario")
	@NotNull
	private List<Email> emails;

	public ContactInfo() {
		// default constructor
	}

	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

}

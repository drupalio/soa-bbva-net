
package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "ContactInfo", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "ContactInfo", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContactInfo
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty(" Listado de numeros de telefono del usuario")
    private List<PhoneNumbersTest> phoneNumbers;
    @ApiModelProperty("Listado de mails del usuario")
    private List<EmailTest> emails;

    public ContactInfo() {
        //default constructor
    }

    public List<PhoneNumbersTest> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumbersTest> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<EmailTest> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailTest> emails) {
        this.emails = emails;
    }

}

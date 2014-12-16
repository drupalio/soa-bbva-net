
package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;



@XmlRootElement(name = "enumPhoneNumberType", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "enumPhoneNumberType", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public enum EnumPhoneNumberType
    implements Serializable
{
    MOBILE, LANDLINE, FAX
}

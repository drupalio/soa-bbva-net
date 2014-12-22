package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "EnumMonth", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "EnumMonth", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public enum EnumMonth implements Serializable {
	JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER

}

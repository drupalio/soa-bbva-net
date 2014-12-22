package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "EnumContactSourceType", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "EnumContactSourceType", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public enum EnumContactSourceType implements Serializable {
	MOBILE, WEB, THIRD_PARTY

}

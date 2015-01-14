package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "EnumCardChargeCategory", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "EnumCardChargeCategory", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public enum EnumCardChargeCategory implements Serializable {
	CHANNEL_SALES,
	LEISURE,
	OTHERS,
	BASIC_COMMERCE,
	GIFT_BOOK_DISC,
	CLOTHING,
	OCIO
}

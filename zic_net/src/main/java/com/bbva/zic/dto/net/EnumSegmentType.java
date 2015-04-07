package com.bbva.zic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "EnumSegmentType", namespace = "urn:com:bbva:zic:dto:net")
@XmlType(name = "EnumSegmentType", namespace = "urn:com:bbva:zic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public enum EnumSegmentType implements Serializable {
	PERSONA, JURIDICA, CORPORATIVO, OTRO

}

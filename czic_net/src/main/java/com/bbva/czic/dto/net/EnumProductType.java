package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "EnumProductType", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "EnumProductType", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public enum EnumProductType implements Serializable {

    PC, TDC, LO, SI, ED, RQ, LI, AQ
}

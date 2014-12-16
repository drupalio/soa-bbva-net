
package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;



@XmlRootElement(name = "enumProductType", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "enumProductType", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public enum EnumProductType
    implements Serializable
{
    PC, CA, TDC, LO, SI, CC, RQ, LI, AQ
}

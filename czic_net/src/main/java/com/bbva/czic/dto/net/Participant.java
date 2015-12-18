package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "participant", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "participant", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Participant extends Person implements Serializable{

	public final static long serialVersionUID = 1L;
	
	public Participant(){
		
	}
}

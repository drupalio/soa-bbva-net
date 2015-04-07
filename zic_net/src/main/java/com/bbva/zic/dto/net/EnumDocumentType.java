package com.bbva.zic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "EnumDocumentType", namespace = "urn:com:bbva:zic:dto:net")
@XmlType(name = "EnumDocumentType", namespace = "urn:com:bbva:zic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public enum EnumDocumentType implements Serializable {
	CEDULACIUDADANIA("1"), CEDULAEXTRANJERIA("2"), TARJETAIDENTIDAD("4"), PASAPORTE("4"), IDENTIFICACIONPERSONAL("5");

	private String code;

	private EnumDocumentType(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

}

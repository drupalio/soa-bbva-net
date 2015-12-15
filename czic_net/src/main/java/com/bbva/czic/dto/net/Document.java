package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Document", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Document", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Document implements Serializable {

	public final static long serialVersionUID = 1L;

	@ApiModelProperty("Identificador unico del documento")
	private String id;

	@ApiModelProperty(value = "Numero de documento", required = true)
	private String number;

	@ApiModelProperty(value = "Tipo de documento", required = true)
	private EnumDocumentType type;

	public Document() {
		// default constructor
	}

	public String getNumber() {
		return number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public EnumDocumentType getType() {
		return type;
	}

	public void setType(EnumDocumentType type) {
		this.type = type;
	}

}

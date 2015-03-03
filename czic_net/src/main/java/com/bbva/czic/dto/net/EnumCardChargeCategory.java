package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.regex.Pattern;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "EnumCardChargeCategory", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "EnumCardChargeCategory", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public enum EnumCardChargeCategory implements Serializable {

	OCIO("OCIO"),
	REGALOS_LIBROS_DISCOS("(REGALOS|LIBROS,DISCOS)"),
	COMERCIOBASICO("COMERCIO BASICO"),
	ROPA_CALZADO_PERSONAL("(ROPA|CALZADO Y PERSONAL)"),
	VARIOS("VARIOS"),
	COMPRASPORCANALES("COMPRAS POR CANALES")
	;

	private String text;

	private EnumCardChargeCategory(String text) {
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}
	
	public static EnumCardChargeCategory fromString(String text) {
	    if (text != null) {
	      for (EnumCardChargeCategory cardChargeCategory : EnumCardChargeCategory.values()) {
	        if (Pattern.compile(cardChargeCategory.text).matcher(text).matches()) {
	          return cardChargeCategory;
	        }
	      }
	    }
	    return null;
	}
}

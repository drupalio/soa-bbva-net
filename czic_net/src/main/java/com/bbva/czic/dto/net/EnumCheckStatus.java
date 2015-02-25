package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "EnumCheckStatus", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "EnumCheckStatus", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public enum EnumCheckStatus implements Serializable {
	ANULADO("1"),
	PED_OFICINA("A"),
	EN_IMPRESOR("I"),
	EN_OFICINA("O"),
	ENTRE_CLIENTE("E"),
	DE_BAJA("B"),
	NO_RECIBIDO("N"),
	ANULADO_PETICION("C"),
	PERDIDO("2");

	private String codigo;

	private EnumCheckStatus(String codigo){
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public static EnumCheckStatus getByCode(String code){
		if(code != null) {
			for (EnumCheckStatus ech : EnumCheckStatus.values()){
				if(ech.getCodigo().equals(code)){
					return ech;
				}
			}
		}
		return null;
	}
}

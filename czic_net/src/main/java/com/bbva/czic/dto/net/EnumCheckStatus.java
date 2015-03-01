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
	DISPONIBLE("0"),
	ANULADO("1"),
	PERDIDO("2"),
	PAGADOCPD("3"),
	PAGADOOFF("4"),
	EXTRAVIADO("5"),
	REEXPEDIDO("6"),
	ORDENOPAGO("8"),
	CPENDIENTEE("9"),
	REGISTPTE("A"),
	CEMPAREJADO("B"),
	REGISTEMP("C"),
	REEMPLAZADO("R"),
	REEMPLAZADO1("E");

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

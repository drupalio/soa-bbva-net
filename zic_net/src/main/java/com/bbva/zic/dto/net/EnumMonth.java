package com.bbva.zic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "EnumMonth", namespace = "urn:com:bbva:zic:dto:net")
@XmlType(name = "EnumMonth", namespace = "urn:com:bbva:zic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public enum EnumMonth implements Serializable {
	JANUARY("01"),
	FEBRUARY("02"),
	MARCH("03"),
	APRIL("04"),
	MAY("05"),
	JUNE("06"),
	JULY("07"),
	AUGUST("08"),
	SEPTEMBER("09"),
	OCTOBER("10"),
	NOVEMBER("11"),
	DECEMBER("12");

	String code;

	private EnumMonth(String codigo){
		this.code = codigo;
	}

	public String getCode() {
		return code;
	}

	public static EnumMonth getByCode(String code){
		for(EnumMonth em : EnumMonth.values()){
			if(em.getCode().equals(code)){
				return em;
			}
		}
		return null;
	}
}

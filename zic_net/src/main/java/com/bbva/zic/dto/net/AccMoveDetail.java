package com.bbva.zic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "AccMoveDetail", namespace = "urn:com:bbva:zic:dto:net")
@XmlType(name = "AccMoveDetail", namespace = "urn:com:bbva:zic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccMoveDetail extends Movement implements Serializable {

	public final static long serialVersionUID = 1L;
	@ApiModelProperty("Valor de origen")
	private Money originValue;

	public AccMoveDetail() {
		// default constructor
	}

	public Money getOriginValue() {
		return originValue;
	}

	public void setOriginValue(Money originValue) {
		this.originValue = originValue;
	}

}

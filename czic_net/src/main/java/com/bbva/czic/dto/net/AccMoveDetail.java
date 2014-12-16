package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.bbva.jee.arq.spring.core.servicing.utils.CalendarAdapter;
import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "AccMoveDetail", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "AccMoveDetail", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccMoveDetail implements Serializable {

	public final static long serialVersionUID = 1L;

	@XmlJavaTypeAdapter(CalendarAdapter.class)
	@XmlSchemaType(name = "dateTime")
	@ApiModelProperty("fecha del valor del moviiento de la cuenta")
	private Date valueDate;

	@XmlJavaTypeAdapter(CalendarAdapter.class)
	@XmlSchemaType(name = "dateTime")
	@ApiModelProperty("hora de ejecucion del movimiento de la cuenta")
	private Date operationTime;

	@ApiModelProperty("Informacion de la oficina o corresponsal de origen de la operacion sobre cuenta")
	private Office office;

	@ApiModelProperty("Estado de la operacion")
	private EnumAccountMoveStatus status;

	public AccMoveDetail() {
		// default constructor
	}

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	public Date getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public EnumAccountMoveStatus getStatus() {
		return status;
	}

	public void setStatus(EnumAccountMoveStatus status) {
		this.status = status;
	}

}

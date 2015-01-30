package com.bbva.czic.dto.net;

import com.bbva.jee.arq.spring.core.servicing.utils.CalendarAdapter;
import com.wordnik.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Calendar;

@XmlRootElement(name = "AccMoveDetail", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "AccMoveDetail", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccMoveDetail extends Movement implements Serializable {

	public final static long serialVersionUID = 1L;
	@XmlJavaTypeAdapter(CalendarAdapter.class)
	//@XmlSchemaType(name = "dateTime")
	@ApiModelProperty("fecha del valor del moviiento de la cuenta")
	private Calendar valueDate;
	@XmlJavaTypeAdapter(CalendarAdapter.class)
	//@XmlSchemaType(name = "dateTime")
	@ApiModelProperty("hora de ejecucion del movimiento de la cuenta")
	private Calendar operationTime;
	@ApiModelProperty("Informacion de la oficina o corresponsal de origen de la operacion sobre cuenta")
	private Office office;

	public AccMoveDetail() {
		// default constructor
	}

	public Calendar getValueDate() {
		return valueDate;
	}

	public void setValueDate(Calendar valueDate) {
		this.valueDate = valueDate;
	}

	public Calendar getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(Calendar operationTime) {
		this.operationTime = operationTime;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

}

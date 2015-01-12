package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.hibernate.validator.constraints.NotBlank;

import com.bbva.jee.arq.spring.core.servicing.utils.CalendarAdapter;
import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Checkbook", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Checkbook", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Checkbook implements Serializable {

	public final static long serialVersionUID = 1L;
	@ApiModelProperty(value = "Numero identificativo del cheque", required = true)
	@NotBlank
	private String id;
	@ApiModelProperty(value = "Numero del primer cheque del intervalo de consulta", required = true)
	private Integer firstCheck;
	@ApiModelProperty(" ultimo cheque de intervalo de consulta")
	private Integer lastCheck;
	@ApiModelProperty(" numero de cheques totales de la chequera ")
	private String totalCheck;
	@XmlSchemaType(name = "dateTime")
	@ApiModelProperty("Fecha de solicitud de la chequera ")
	@NotNull
	@Past
	private Calendar requestDate;
	@XmlSchemaType(name = "dateTime")
	@ApiModelProperty("Fecha de entrega de la nueva chequera")
	@NotNull
	@Past
	private Calendar deliveryDate;
	@ApiModelProperty(value = "Estado actual de la chequera solicitada", required = true)
	@NotNull
	private EnumCheckbookStatus actualState;
	@ApiModelProperty(value = "Cheques asociados a una chequera", required = true)
	@NotNull
	private List<Check> checks;

	public Checkbook() {
		// default constructor
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getFirstCheck() {
		return firstCheck;
	}

	public void setFirstCheck(Integer firstCheck) {
		this.firstCheck = firstCheck;
	}

	public Integer getLastCheck() {
		return lastCheck;
	}

	public void setLastCheck(Integer lastCheck) {
		this.lastCheck = lastCheck;
	}

	public String getTotalCheck() {
		return totalCheck;
	}

	public void setTotalCheck(String totalCheck) {
		this.totalCheck = totalCheck;
	}

	public Calendar getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Calendar requestDate) {
		this.requestDate = requestDate;
	}

	public Calendar getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Calendar deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public EnumCheckbookStatus getActualState() {
		return actualState;
	}

	public void setActualState(EnumCheckbookStatus actualState) {
		this.actualState = actualState;
	}

	public List<Check> getChecks() {
		return checks;
	}

	public void setChecks(List<Check> checks) {
		this.checks = checks;
	}

}

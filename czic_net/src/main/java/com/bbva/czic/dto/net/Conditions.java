package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.bbva.jee.arq.spring.core.servicing.utils.CalendarAdapter;
import org.hibernate.validator.constraints.NotBlank;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Conditions", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Conditions", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Conditions implements Serializable {

	public final static long serialVersionUID = 1L;
	@ApiModelProperty(value = "tipo decuenta", required = true)
	private String type;
	@ApiModelProperty(value = "Alias asociado al titular de la cuenta", required = true)
	private String alias;
	@ApiModelProperty(value = "Tipo de plan asociado al producto", required = true)
	private String category;
	@ApiModelProperty("Descripcion del tipo de producto")
	private String description;
	@XmlJavaTypeAdapter(CalendarAdapter.class)
	@ApiModelProperty(value = " Fecha en la que se realizo la apertura del producto", required = true)
	private Calendar openingDate;
	@ApiModelProperty(value = "Tipo de comision que aplica para el producto", required = true)
	private String commission;
	@ApiModelProperty(value = "Datos de la oficina donde se realizo la apertura del producto", required = true)
	private Office office;
	@ApiModelProperty("")
	private String mobilizationConditions;
	@ApiModelProperty(value = "ultimas actividades realizadas", required = true)
	private List<Activity> activities;

	public Conditions() {
		// default constructor
	}

	public String getCategory() {
		return category;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Calendar openingDate) {
		this.openingDate = openingDate;
	}

	public String getCommission() {
		return commission;
	}

	public void setCommission(String commission) {
		this.commission = commission;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public String getMobilizationConditions() {
		return mobilizationConditions;
	}

	public void setMobilizationConditions(String mobilizationConditions) {
		this.mobilizationConditions = mobilizationConditions;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}

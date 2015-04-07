package com.bbva.zic.dto.net;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Conditions", namespace = "urn:com:bbva:zic:dto:net")
@XmlType(name = "Conditions", namespace = "urn:com:bbva:zic:dto:net")
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
	//@XmlJavaTypeAdapter(CalendarAdapter.class)
	@ApiModelProperty(value = " Fecha en la que se realizo la apertura del producto", required = true)
	private Date openingDate;
	@ApiModelProperty(value = "Tipo de comision que aplica para el producto", required = true)
	private String commission;
	@ApiModelProperty(value = "Datos de la oficina donde se realizo la apertura del producto", required = true)
	private Office office;
	@ApiModelProperty("")
	private String mobilizationConditions;
	@ApiModelProperty(value = "ultimas actividades realizadas", required = true)
	private Activity activity;

	private List<Holder> holders;

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

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public List<Holder> getHolders() {
		return holders;
	}

	public void setHolders(List<Holder> holders) {
		this.holders = holders;
	}
}

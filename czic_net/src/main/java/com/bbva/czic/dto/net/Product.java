package com.bbva.czic.dto.net;

import com.wordnik.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Product", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Product", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product implements Serializable {

	public final static long serialVersionUID = 1L;

	@ApiModelProperty(value = "Identificador del producto", required = true)
	@Pattern(regexp = "^(\\d{20}|\\d{16})$")
	private String id;

	@ApiModelProperty(value = "", required = true)
//	@Pattern(regexp = "^[A-Z]{2}$")
	@Length(max = 2)
	private String type;

	@ApiModelProperty(value = "Nombre del producto", required = true)
	private String name;

	@ApiModelProperty("Alias del producto")
	private String alias;

	@ApiModelProperty(value = "Identificador que referencia si un producto es un activo o un pasivo", required = true)
	private String financialState;

	@ApiModelProperty(value = "Visibilidad del producto", required = true)
	private Boolean visible;

	@ApiModelProperty(value = "Operatibilidad del producto", required = true)
	private Boolean operable;

	@ApiModelProperty(value = "Entidad con toda la informaci\u00f3n del balance de la cuenta", required = true)
	private Balance balance;

	@ApiModelProperty(value = "description", required = true)
	private ContactInfo contactInfo;

	@ApiModelProperty("")
	private Conditions conditions;

	@ApiModelProperty("")
	private List<Movement> movement;

	@ApiModelProperty("")
	private Contract contract;
	
	@ApiModelProperty("")
	private List<Extract> extracts;

	public Product() {
		movement = new ArrayList<Movement>();
	}

	public Product(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getFinancialState() {
		return financialState;
	}

	public void setFinancialState(String financialState) {
		this.financialState = financialState;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public Boolean getOperable() {
		return operable;
	}

	public void setOperable(Boolean operable) {
		this.operable = operable;
	}

	public Balance getBalance() {
		return balance;
	}

	public void setBalance(Balance balance) {
		this.balance = balance;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public Conditions getConditions() {
		return conditions;
	}

	public void setConditions(Conditions conditions) {
		this.conditions = conditions;
	}

	public List<Movement> getMovement() {
		return movement;
	}

	public void setMovement(List<Movement> movement) {
		this.movement = movement;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public List<Extract> getExtracts() {
		return extracts;
	}

	public void setExtracts(List<Extract> extracts) {
		this.extracts = extracts;
	}
	
	
}

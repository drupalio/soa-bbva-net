package com.bbva.czic.internationalcontracttransfer.business.dto;

public class DTOIntTransfer {

	public final static long serialVersionUID = 1L;

	private String id;

	private String typeName;

	private String date;

	private DTOIntMoney amount;

	private String state;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public DTOIntMoney getAmount() {
		return amount;
	}

	public void setAmount(DTOIntMoney amount) {
		this.amount = amount;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}

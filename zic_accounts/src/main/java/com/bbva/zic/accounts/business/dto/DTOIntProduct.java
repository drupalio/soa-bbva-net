package com.bbva.zic.accounts.business.dto;

import java.util.List;

public class DTOIntProduct {

	public final static long serialVersionUID = 1L;
	private String id;
	private String name;
	private String alias;
	private DTOIntBalance balance;
	private List<DTOIntMovement> movement;

	public DTOIntProduct() {
		// default constructor
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public DTOIntBalance getBalance() {
		return balance;
	}

	public void setBalance(DTOIntBalance balance) {
		this.balance = balance;
	}

	public List<DTOIntMovement> getMovement() {
		return movement;
	}

	public void setMovement(List<DTOIntMovement> movement) {
		this.movement = movement;
	}

}
